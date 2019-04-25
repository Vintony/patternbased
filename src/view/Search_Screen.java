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
		
		JList list = new JList();
		list.setBounds(21, 173, 732, 375);
		contentPane.add(list);
	}

}
