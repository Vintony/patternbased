package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_Screen extends JFrame {

	private JPanel contentPane;
	private JTextField Search_content;
	private JList List;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Screen frame = new Main_Screen();
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
	public Main_Screen() {
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
		Search_button.addMouseListener(new MouseAdapter() {
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
		Search_button.setBounds(653, 24, 105, 31);
		contentPane.add(Search_button);
		
		JLabel lblWordStatisticalAnalysis = new JLabel("Word statistical analysis");
		lblWordStatisticalAnalysis.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblWordStatisticalAnalysis.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordStatisticalAnalysis.setBounds(0, 2, 403, 73);
		contentPane.add(lblWordStatisticalAnalysis);
		
		List = new JList();
		List.setBounds(21, 135, 737, 413);
		contentPane.add(List);
		
		JRadioButton Sort_max = new JRadioButton("Max");
		Sort_max.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Sort_max.setHorizontalAlignment(SwingConstants.CENTER);
		Sort_max.setBounds(135, 97, 78, 31);
		contentPane.add(Sort_max);
		
		JLabel lblNewLabel = new JLabel("Sort by");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 96, 108, 29);
		contentPane.add(lblNewLabel);
		
		JRadioButton Sort_min = new JRadioButton("Min");
		Sort_min.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Sort_min.setHorizontalAlignment(SwingConstants.CENTER);
		Sort_min.setBounds(226, 97, 85, 31);
		contentPane.add(Sort_min);
	}
}
