package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import controller.LogIn;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField Username;
    private JPasswordField Password;
    private JButton Confirm_button;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 640);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Username = new JTextField();
        Username.setBounds(283, 229, 291, 51);
        Username.setColumns(10);
        contentPane.add(Username);

        Password = new JPasswordField();
        Password.setBounds(283, 319, 291, 51);
        contentPane.add(Password);

        Confirm_button = new JButton("Confirm");
        Confirm_button.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        /*Confirm_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username=Username.getText();
                char[] password=Password.getPassword();
                if(username.equals("")||password.equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter username or password", "Warning", JOptionPane.ERROR_MESSAGE);
                    //check the username and password---need modify
                else if(username.equals("admin")&&password.equals("admin")) {
                    Main_Screen main_screen=new Main_Screen();
                    main_screen.setVisible(true);
                    Login.this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "username or password is wrong", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/
        Confirm_button.setBounds(569, 458, 117, 51);
        contentPane.add(Confirm_button);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lblNewLabel.setBounds(321, 94, 133, 70);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(154, 240, 108, 29);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(154, 331, 108, 29);
        contentPane.add(lblNewLabel_2);

        AddListener();
    }

    private void AddListener(){
        Confirm_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogIn();
            }
        });
    }

    private void LogIn(){
        String username = Username.getText();
        String password = Password.getText();
        if(username.equals("")||password.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter username or password", "Warning", JOptionPane.ERROR_MESSAGE);
            //check the username and password---need modify
        }else{
            LogIn logIn = new LogIn(username, password);
            if (logIn.Connect()){
                Main_Screen main_screen=new Main_Screen();
                main_screen.setVisible(true);
                Login.this.dispose();
            }else{
                Username.setText("");
                Password.setText("");
                JOptionPane.showMessageDialog(null, "username or password is wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}