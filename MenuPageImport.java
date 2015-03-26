import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuPageImport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public MenuPageImport() {
		setTitle("External Log");
		dataWrapping.importing = 1;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Search Log");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
				SearchLogExtended s = new SearchLogExtended();
				s.setVisible(true);
				}
			});
		
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(85, 190, 157, 32);
		contentPane.add(button);
		
		final JButton btnImport = new JButton("Import Log");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportLog i = new ImportLog();
				i.setVisible(true);
			}
		});
		
		btnImport.setBackground(Color.LIGHT_GRAY);
		btnImport.setBounds(85, 127, 157, 32);
		contentPane.add(btnImport);
		
		JLabel lblLogManagement = new JLabel("Log Management");
		lblLogManagement.setForeground(Color.WHITE);
		lblLogManagement.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblLogManagement.setBounds(213, 33, 164, 32);
		contentPane.add(lblLogManagement);
		
		JButton button_1 = new JButton("Analyze");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogAnalyzeMenu a = new LogAnalyzeMenu();
				a.setVisible(true);
			}
		});
		
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(85, 254, 157, 32);
		contentPane.add(button_1);
	}

}
