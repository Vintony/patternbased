package view;
import controller.FetchDetail;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Screen extends JFrame {

    private JPanel contentPane;
    private JTextField Search_content;
    private JList Stat_list;
    private List raw_data;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main_Screen frame = new Main_Screen(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Main_Screen(List<String> detailName) {
        /*
        *
        * Just for test
        * use fetchDetail object to getRawTweet
        * sequence: latest to earliest
        * raw_data stores all tweets raw data
        * tweets format: {tweet_id, created_at, id, text}
        *
        * */
        raw_data = new ArrayList();
        for (int i = 0; i < detailName.size(); i++){
            FetchDetail fetchDetail = new FetchDetail(detailName.get(i));
            raw_data.addAll(fetchDetail.getRawTweet());
            for (int j = 0; j < 2; j++){
                System.out.println(fetchDetail.getRawTweet().get(j));
            }
        }

        //raw_data process to usable data
        //separate the word and delete meaningless word

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Search_content = new JTextField();
        Search_content.setToolTipText("Search");
        Search_content.setBounds(412, 21, 220, 37);
        contentPane.add(Search_content);
        Search_content.setColumns(10);

        JButton Search_button = new JButton("Search");
        Search_button.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        Search_button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//need modify
        	}
        });
        /*Search_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                String search_content=Search_content.getText();
                if(search_content.equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter search content", "Warning", JOptionPane.ERROR_MESSAGE);
                else {
                    Search_Screen search_screen=new Search_Screen(search_content);
                    search_screen.setVisible(true);
                    Main_Screen.this.dispose();
                }
            }
        });*/
        Search_button.setBounds(655, 20, 105, 40);
        contentPane.add(Search_button);
        
        JButton Show_result = new JButton("Show result");
        Show_result.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		String search_content=Search_content.getText();
                if(search_content.equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter search content", "Warning", JOptionPane.ERROR_MESSAGE);
                else {
                    Search_Screen search_screen=new Search_Screen(search_content);
                    search_screen.setVisible(true);
                    Main_Screen.this.dispose();
                }
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
        Stat_list.setBounds(21, 135, 737, 368);
        contentPane.add(Stat_list);

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
