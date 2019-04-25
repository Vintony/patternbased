package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

    private JFrame frmLogin;
    private JPasswordField Password;
    private JTextField Username;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frmLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLogin = new JFrame();
        frmLogin.setTitle("Login");
        frmLogin.setBounds(100, 100, 540, 400);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel.setBounds(185, 21, 108, 29);
        frmLogin.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(66, 100, 108, 29);
        frmLogin.getContentPane().add(lblNewLabel_1);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPassword.setBounds(66, 163, 108, 29);
        frmLogin.getContentPane().add(lblPassword);

        Password = new JPasswordField();
        Password.setToolTipText("Enter Password");
        Password.setBounds(172, 158, 218, 34);
        frmLogin.getContentPane().add(Password);

        Username = new JTextField();
        Username.setBounds(171, 95, 219, 34);
        frmLogin.getContentPane().add(Username);
        Username.setColumns(10);

        JButton Confirm_button = new JButton("Confirm");
        Confirm_button.setBounds(335, 247, 124, 37);
        frmLogin.getContentPane().add(Confirm_button);
    }
}