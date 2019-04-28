package view;
import controller.AnalysisResult;
import controller.DataDisplay;
import controller.FrequencyResult;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

public class Analyze_Screen extends JFrame {


    private JPanel contentPane;
    static String content="";
    private DataDisplay dataDisplay;
    private List<Map.Entry<String, Integer>> word_frequency;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Analyze_Screen frame = new Analyze_Screen(null);
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
    public Analyze_Screen(DataDisplay dataDisplay) {
        this.dataDisplay = dataDisplay;
        AnalysisResult result = new FrequencyResult(dataDisplay);
        this.word_frequency = result.getValue();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Search_word = new JLabel("New label1");
        Search_word.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Search_word.setText(content);
        Search_word.setBounds(252, 21, 501, 29);
        contentPane.add(Search_word);

        JLabel lblNewLabel_1 = new JLabel("Analysis result");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel_1.setBounds(21, 21, 210, 29);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Close");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Analyze_Screen.this.dispose();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        btnNewButton.setBounds(600, 511, 153, 37);
        contentPane.add(btnNewButton);

        JLabel label_0 = new JLabel(word_frequency.get(0).getKey() + "=" + word_frequency.get(0).getValue().toString());
        label_0.setToolTipText("show stat result");
        label_0.setBounds(31, 71, 722, 29);
        contentPane.add(label_0);

        JLabel label_1 = new JLabel(word_frequency.get(1).getKey() + "=" + word_frequency.get(1).getValue().toString());
        label_1.setToolTipText("show stat result");
        label_1.setBounds(31, 121, 722, 29);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel(word_frequency.get(2).getKey() + "=" + word_frequency.get(2).getValue().toString());
        label_2.setToolTipText("show stat result");
        label_2.setBounds(31, 274, 722, 29);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel(word_frequency.get(3).getKey() + "=" + word_frequency.get(3).getValue().toString());
        label_3.setToolTipText("show stat result");
        label_3.setBounds(31, 224, 722, 29);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel(word_frequency.get(4).getKey() + "=" + word_frequency.get(4).getValue().toString());
        label_4.setToolTipText("show stat result");
        label_4.setBounds(31, 171, 722, 29);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel(word_frequency.get(5).getKey() + "=" + word_frequency.get(5).getValue().toString());
        label_5.setToolTipText("show stat result");
        label_5.setBounds(31, 324, 722, 29);
        contentPane.add(label_5);

        JLabel label_6 = new JLabel(word_frequency.get(6).getKey() + "=" + word_frequency.get(6).getValue().toString());
        label_6.setToolTipText("show stat result");
        label_6.setBounds(31, 374, 722, 29);
        contentPane.add(label_6);

        JLabel label_7 = new JLabel(word_frequency.get(7).getKey() + "=" + word_frequency.get(7).getValue().toString());
        label_7.setToolTipText("show stat result");
        label_7.setBounds(31, 424, 722, 29);
        contentPane.add(label_7);

        JLabel label_8 = new JLabel(word_frequency.get(8).getKey() + "=" + word_frequency.get(8).getValue().toString());
        label_8.setBounds(31, 474, 722, 29);
        contentPane.add(label_8);
    }
}