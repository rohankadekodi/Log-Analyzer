import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class InsideCreateLog extends JFrame {
	private JTextField txtEnterAmount;
	private JTextField txtEnterAmount_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsideCreateLog frame = new InsideCreateLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	String s2=new String();
	String[] dd = {null,"Login successful","Login failed","Update phone no","Update address"};
	JLabel withdrawal,deposit;
	JTextField wdrl,dpst;
	JButton submitWithdraw,submitDeposit,update_addr,update_tele;
	String myUser = new String();
	String myIp = new String();
	
	public InsideCreateLog(String user,String ip) {
		setTitle("Inside create");
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		getContentPane().setLayout(null);
		
		wdrl = new JTextField();
		wdrl.setBackground(SystemColor.activeCaptionBorder);
		wdrl.setText("Enter Amount");
		wdrl.setBounds(263, 89, 114, 19);
		getContentPane().add(wdrl);
		wdrl.setColumns(10);
		
		dpst = new JTextField();
		dpst.setBackground(SystemColor.activeCaptionBorder);
		dpst.setText("Enter Amount");
		dpst.setBounds(263, 171, 114, 19);
		getContentPane().add(dpst);
		dpst.setColumns(10);
		
		myUser = user;
		myIp = ip;
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.activeCaptionBorder);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1 = new String();
				s1 = wdrl.getText();
				s2 = "amount withdrawn is " + s1;
				InsertingLog.java_to_mongo(myUser,s2, myIp);
				InsertingLog.java_to_text(myUser, s2, myIp);
				JOptionPane.showMessageDialog(null,String.format("Inserted successfully"));
			}
		});
		btnSubmit.setBounds(431, 86, 117, 25);
		getContentPane().add(btnSubmit);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setBackground(SystemColor.activeCaptionBorder);
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1 = new String();
				s1 = dpst.getText();
				s2 = "amount deposited is " + s1;
				InsertingLog.java_to_mongo(myUser,s2, myIp);
				InsertingLog.java_to_text(myUser, s2, myIp);
				JOptionPane.showMessageDialog(null,String.format("Inserted successfully"));
			}
		});
		btnSubmit_1.setBounds(431, 168, 117, 25);
		getContentPane().add(btnSubmit_1);
		
		JButton btnUpdateAddress = new JButton("Update Address");
		btnUpdateAddress.setBackground(SystemColor.activeCaptionBorder);
		btnUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s2 = "address updated";
				InsertingLog.java_to_mongo(myUser,s2, myIp);
				InsertingLog.java_to_text(myUser, s2, myIp);
			}
		});
		btnUpdateAddress.setBounds(132, 274, 160, 25);
		getContentPane().add(btnUpdateAddress);
		
		JButton btnUpdateTelephone = new JButton("Update telephone");
		btnUpdateTelephone.setBackground(SystemColor.activeCaptionBorder);
		btnUpdateTelephone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s2 = "telephone number updated";
				InsertingLog.java_to_mongo(myUser,s2, myIp);
				InsertingLog.java_to_text(myUser, s2, myIp);
			}
		});
		btnUpdateTelephone.setBounds(358, 274, 173, 25);
		getContentPane().add(btnUpdateTelephone);
		
		JLabel lblInserting = new JLabel("Inserting");
		lblInserting.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblInserting.setForeground(Color.WHITE);
		lblInserting.setBounds(253, 22, 127, 25);
		getContentPane().add(lblInserting);
		
		JLabel lblWithdrawAmount = new JLabel("Withdraw Amount :");
		lblWithdrawAmount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblWithdrawAmount.setForeground(Color.WHITE);
		lblWithdrawAmount.setBounds(72, 91, 160, 15);
		getContentPane().add(lblWithdrawAmount);
		
		JLabel lblDepositAmount = new JLabel("Deposit Amount :");
		lblDepositAmount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblDepositAmount.setForeground(Color.WHITE);
		lblDepositAmount.setBounds(72, 173, 160, 15);
		getContentPane().add(lblDepositAmount);
		
		/*dataWrapping.keys[0] = "user";
		dataWrapping.keys[1] = "action";
		dataWrapping.keys[2] = "ip";
		dataWrapping.numOfKeys = 3;*/

	}
}
