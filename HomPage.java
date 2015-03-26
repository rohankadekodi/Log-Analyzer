import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;


public class HomPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomPage frame = new HomPage();
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
	public HomPage() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogAnalyzer = new JLabel("Log Analyzer");
		lblLogAnalyzer.setForeground(Color.WHITE);
		lblLogAnalyzer.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblLogAnalyzer.setBounds(208, 24, 148, 31);
		contentPane.add(lblLogAnalyzer);
		
		JButton btnNewButton = new JButton("Create your own log");
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPage m = new MenuPage();
				m.setVisible(true);
			}
		});
		btnNewButton.setBounds(97, 110, 178, 25);
		contentPane.add(btnNewButton);
		
		JButton btnImportExternalLog = new JButton("Import external log");
		btnImportExternalLog.setBackground(SystemColor.activeCaptionBorder);
		btnImportExternalLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPageImport m = new MenuPageImport();
				m.setVisible(true);
			}
		});
		btnImportExternalLog.setBounds(310, 110, 178, 25);
		contentPane.add(btnImportExternalLog);
	}

}
