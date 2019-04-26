package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Choose_Screen extends JFrame {

	private JPanel contentPane;

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
		
		JList Choose_list = new JList();
		Choose_list.setBounds(21, 92, 732, 382);
		contentPane.add(Choose_list);
		
		JButton Confirm_button = new JButton("Confirm");
		Confirm_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*if("List choice is empty")
				 * JOptionPane.showMessageDialog(null, "Please choose from the list", "Warning", JOptionPane.ERROR_MESSAGE);
				 * else
				 * need modify
				 */
				Main_Screen main_screen=new Main_Screen();
				main_screen.setVisible(true);
				Choose_Screen.this.dispose();
			}
		});
		Confirm_button.setBounds(593, 495, 160, 53);
		contentPane.add(Confirm_button);
	}
}
