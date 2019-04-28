package view;
import controller.DataDisplay;
import controller.DataPreprocess;
import controller.FilterInterpreter;
import controller.RegexAccelerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_Screen extends JFrame {
    private JPanel contentPane;
    private JTextField Filter_content;
    private JList Stat_list;
    private DataPreprocess dataPreprocess;
    private DataDisplay dataDisplay;
    private List<String> detailName;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main_Screen frame = new Main_Screen(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Main_Screen(List<String> detailName) {
        this.detailName = detailName;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Filter_content = new JTextField();
        Filter_content.setToolTipText("Search");
        Filter_content.setBounds(412, 21, 220, 37);
        contentPane.add(Filter_content);
        Filter_content.setColumns(10);

        JButton ApplyFilter = new JButton("Filter");
        ApplyFilter.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        /*ApplyFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //need modify
            }
        });*/
        ApplyFilter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                String filter_contentText=Filter_content.getText();
                if(filter_contentText.equals("")) {
                    JOptionPane.showMessageDialog(null, "Show origin data", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    dataPreprocess = new DataPreprocess(detailName);
                    dataDisplay = new DataDisplay(dataPreprocess);
                    Stat_list.setListData(dataDisplay.FetchDisplayData());
                } else {
                    FilterInterpreter interpreter = new FilterInterpreter(filter_contentText, dataDisplay);
                    RegexAccelerator accelerator = new RegexAccelerator();
                    interpreter.addObserver(accelerator);
                    Stat_list.setListData(interpreter.DisplayNewData());
                }
            }
        });
        ApplyFilter.setBounds(655, 20, 105, 40);
        contentPane.add(ApplyFilter);

        JButton Show_result = new JButton("Display Analysis Result");
        Show_result.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Analyze_Screen analyze_screen =new Analyze_Screen(dataDisplay);
                analyze_screen.setVisible(true);
            }
        });
        Show_result.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        Show_result.setBounds(607, 514, 153, 47);
        contentPane.add(Show_result);

        JLabel lblWordStatisticalAnalysis = new JLabel("Word statistical analysis");
        lblWordStatisticalAnalysis.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblWordStatisticalAnalysis.setHorizontalAlignment(SwingConstants.CENTER);
        lblWordStatisticalAnalysis.setBounds(0, 2, 403, 73);
        contentPane.add(lblWordStatisticalAnalysis);

        Stat_list = new JList();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 135, 737, 368);
        scrollPane.setViewportView(Stat_list);

        dataPreprocess = new DataPreprocess(this.detailName);
        dataDisplay = new DataDisplay(dataPreprocess);
        Stat_list.setListData(dataDisplay.FetchDisplayData());

        contentPane.add(scrollPane);

        JRadioButton Sort_max = new JRadioButton("Max");
        Sort_max.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Sort_max.setHorizontalAlignment(SwingConstants.CENTER);
        Sort_max.setBounds(457, 87, 78, 31);
        contentPane.add(Sort_max);

        JRadioButton Sort_min = new JRadioButton("Min");
        Sort_min.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Sort_min.setHorizontalAlignment(SwingConstants.CENTER);
        Sort_min.setBounds(548, 87, 85, 31);
        contentPane.add(Sort_min);

        JLabel lblStatFor = new JLabel("Stat for");
        lblStatFor.setHorizontalAlignment(SwingConstants.CENTER);
        lblStatFor.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblStatFor.setBounds(21, 85, 78, 29);
        contentPane.add(lblStatFor);

        JLabel Choose_name = new JLabel("the chose name from the former list");
        Choose_name.setBounds(108, 85, 333, 29);
        contentPane.add(Choose_name);

        JButton Sort_button = new JButton("Sort");
        Sort_button.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        Sort_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        Sort_button.setBounds(655, 82, 105, 40);
        contentPane.add(Sort_button);
    }
}