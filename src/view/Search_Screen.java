package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Search_Screen extends JFrame {


    private JPanel contentPane;
    private Main_Screen main_screen;
    static String content="";
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Search_Screen frame = new Search_Screen(content);
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
    public Search_Screen(String content) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Search_word = new JLabel("New label");
        Search_word.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Search_word.setText(content);
        Search_word.setBounds(252, 21, 501, 29);
        contentPane.add(Search_word);

        JLabel lblNewLabel_1 = new JLabel("Search result for");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel_1.setBounds(21, 21, 210, 29);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("Return");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Choose_Screen choose_screen=new Choose_Screen();
        		choose_screen.setVisible(true);
        		Search_Screen.this.dispose();
        	}
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        btnNewButton.setBounds(600, 511, 153, 37);
        contentPane.add(btnNewButton);
        
        JLabel label_0 = new JLabel("New label");
        label_0.setToolTipText("show stat result");
        label_0.setBounds(31, 71, 722, 29);
        contentPane.add(label_0);
        
        JLabel label_1 = new JLabel("New label");
        label_1.setToolTipText("show stat result");
        label_1.setBounds(31, 121, 722, 29);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("New label");
        label_2.setToolTipText("show stat result");
        label_2.setBounds(31, 274, 722, 29);
        contentPane.add(label_2);
        
        JLabel label_3 = new JLabel("New label");
        label_3.setToolTipText("show stat result");
        label_3.setBounds(31, 224, 722, 29);
        contentPane.add(label_3);
        
        JLabel label_4 = new JLabel("New label");
        label_4.setToolTipText("show stat result");
        label_4.setBounds(31, 171, 722, 29);
        contentPane.add(label_4);
        
        JLabel label_5 = new JLabel("New label");
        label_5.setToolTipText("show stat result");
        label_5.setBounds(31, 324, 722, 29);
        contentPane.add(label_5);
        
        JLabel label_6 = new JLabel("New label");
        label_6.setToolTipText("show stat result");
        label_6.setBounds(31, 374, 722, 29);
        contentPane.add(label_6);
        
        JLabel label_7 = new JLabel("New label");
        label_7.setToolTipText("show stat result");
        label_7.setBounds(31, 424, 722, 29);
        contentPane.add(label_7);
        
        JLabel label_8 = new JLabel("New label");
        label_8.setBounds(31, 474, 722, 29);
        contentPane.add(label_8);
    }
}
