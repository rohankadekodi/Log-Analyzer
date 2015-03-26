

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;

public class CreateLog extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField pwdPassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateLog frame = new CreateLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	JComboBox user,ip;
	boolean auth = false;
	/**
	 * Create the frame.
	 */
	public CreateLog() {
		setTitle("Creation");
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User :");
		lblUser.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblUser.setBounds(73, 97, 92, 15);
		lblUser.setForeground(Color.WHITE);
		contentPane.add(lblUser);
		
		String[] usrdd = DisplayLists.user_droplist();
		user = new JComboBox(usrdd);
		user.setBackground(SystemColor.activeCaptionBorder);
		user.setBounds(223, 92, 213, 24);
		contentPane.add(user);
		
		JLabel lblP = new JLabel("Password :");
		lblP.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblP.setBounds(73, 160, 104, 15);
		lblP.setForeground(Color.WHITE);
		contentPane.add(lblP);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.activeCaptionBorder);
		textField.setBounds(223, 158, 213, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIpAddress = new JLabel("IP address :");
		lblIpAddress.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblIpAddress.setForeground(Color.WHITE);
		lblIpAddress.setBounds(73, 235, 104, 15);
		contentPane.add(lblIpAddress);
		
		String []ipdd = DisplayLists.ip_droplist();
		ip = new JComboBox(ipdd);
		ip.setBackground(SystemColor.activeCaptionBorder);
		ip.setBounds(223, 230, 213, 24);
		contentPane.add(ip);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] s = new String[3];
				s[0] = user.getSelectedItem().toString();
				s[1] = textField.getText();
				//s[1]=a.toString();
				s[2] = ip.getSelectedItem().toString();
				
				auth = AuthenticateUser.authenticate_user(s[0], s[1], s[2]);
			
				if(auth == true)
				{
					InsideCreateLog inside = new InsideCreateLog(s[0],s[2]);
					inside.setVisible(true);
					
					setVisible(false);
				}
			
				else
				{
					JOptionPane.showMessageDialog(null,String.format("Invalid Password"));
				}
				
			}
		});
		btnNewButton.setBounds(161, 317, 104, 36);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(344, 317, 92, 36);
		contentPane.add(btnClear);
		
		JLabel lblLogCreation = new JLabel("Log Creation");
		lblLogCreation.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblLogCreation.setForeground(SystemColor.text);
		lblLogCreation.setBounds(172, 12, 213, 34);
		contentPane.add(lblLogCreation);
				
	}
}
