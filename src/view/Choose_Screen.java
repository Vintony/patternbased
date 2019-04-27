package view;

import controller.FetchList;
import model.*;
import controller.FetchAbstract;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Choose_Screen extends JFrame {

    private JPanel contentPane;
    private JList<String> Choose_list;
    private JButton Confirm_button;

    private FetchAbstract fetchAbstract = new FetchAbstract();
    private FetchList fetchList = new FetchList();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Choose_Screen frame = new Choose_Screen();
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
    public Choose_Screen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Choose List");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel.setBounds(21, 21, 160, 50);
        contentPane.add(lblNewLabel);

        Choose_list = new JList<>();
        Choose_list.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if (super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                } else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        setList();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 92, 732, 382);
        scrollPane.setViewportView(Choose_list);
        contentPane.add(scrollPane);

        Confirm_button = new JButton("Confirm");
//        Confirm_button.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent arg0) {
//                /*if("List choice is empty")
//                 * JOptionPane.showMessageDialog(null, "Please choose from the list", "Warning", JOptionPane.ERROR_MESSAGE);
//                 * else
//                 * need modify
//                 */
//                for (int i = 0; i< Choose_list.getSelectedIndices().length; i++){
//                    System.out.println(Choose_list.getSelectedIndices()[i]);
//                }
//                Main_Screen main_screen=new Main_Screen();
//                main_screen.setVisible(true);
//                Choose_Screen.this.dispose();
//            }
//        });
        Confirm_button.setBounds(593, 495, 160, 53);
        contentPane.add(Confirm_button);

        AddListener();
    }

    private void AddListener(){
        Confirm_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FetchAbstract();
            }
        });
    }

    private void FetchAbstract(){
        if (Choose_list.getSelectedIndices().length == 0){
            JOptionPane.showMessageDialog(null, "Please choose at least one Tweeter!", "Warning", JOptionPane.ERROR_MESSAGE);
        }else{
            List<String> detailName = new ArrayList<>();
            for (int i = 0; i < Choose_list.getSelectedIndices().length; i++){
                int index = Choose_list.getSelectedIndices()[i];
                detailName.add(fetchList.getDetailList().get(index));
                JOptionPane.showMessageDialog(null, "Fetch " + fetchAbstract.getCountList().get(index) + "Tweets from" +
                        fetchAbstract.getDateList().get(index) + " for " + fetchAbstract.getNameList().get(index), "Data info", JOptionPane.INFORMATION_MESSAGE);
            }
            Main_Screen main_screen=new Main_Screen(detailName);
            main_screen.setVisible(true);
            Choose_Screen.this.dispose();
        }
    }

    private void setList(){
        Choose_list.setListData(FetchList());
        Check_Box cell = new Check_Box();
        Choose_list.setCellRenderer(cell);
    }

    private String[] FetchList(){
        List<String> namelist = fetchList.getNameList();
        List<String> introlist = fetchList.getIntroList();
        String[] result = new String[namelist.size()];
        for (int i = 0; i <namelist.size();i++){
            result[i] = namelist.get(i) + " " + introlist.get(i);
        }
        return result;
    }
}
