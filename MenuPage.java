

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class MenuPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public MenuPage() {
		dataWrapping.importing = 0;
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Create Log");
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateLog c = new CreateLog();
				c.setVisible(true);
			}
		});
		/*button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});*/
		button.setBounds(57, 111, 157, 32);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("Search Log");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataWrapping.keys[0] = "user";
				dataWrapping.keys[1] = "action";
				dataWrapping.keys[2] = "ip";
				dataWrapping.numOfKeys = 3;

				
				//SearchLog s = new SearchLog();
				SearchLogExtended s = new SearchLogExtended();
				s.setVisible(true);
			}
		});
		btnNewButton.setBounds(57, 171, 157, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Analyze");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataWrapping.keys[0] = "user";
				dataWrapping.keys[1] = "action";
				dataWrapping.keys[2] = "ip";
				dataWrapping.numOfKeys = 3;
				LogAnalyzeMenu a = new LogAnalyzeMenu();
				a.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(57, 230, 157, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Log Management");
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(193, 25, 217, 25);
		contentPane.add(lblNewLabel);
	}
}
