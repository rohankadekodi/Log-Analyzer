import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jfree.ui.ExtensionFileFilter;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;


public class ImportLog extends JFrame {

	private JPanel contentPane;
	private JTextField logLayoutText;
	private JTextField logText;
	String layout = new String();
	String log = new String();
	JFileChooser fc;
	FileFilter fileFilter;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportLog frame = new ImportLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ImportLog() {
		fc = new JFileChooser();
		fileFilter = new ExtensionFileFilter("Text", "txt");
		fc.setFileFilter(fileFilter);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImportLayout = new JLabel("Import Layout");
		lblImportLayout.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblImportLayout.setForeground(Color.WHITE);
		lblImportLayout.setBounds(78, 142, 120, 15);
		contentPane.add(lblImportLayout);
		
		JLabel lblImimportLog = new JLabel("Import Log");
		lblImimportLog.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblImimportLog.setForeground(Color.WHITE);
		lblImimportLog.setBounds(78, 220, 105, 15);
		contentPane.add(lblImimportLog);
		
		logLayoutText = new JTextField();
		logLayoutText.setBackground(SystemColor.activeCaptionBorder);
		logLayoutText.setText("Enter the text file");
		logLayoutText.setBounds(229, 140, 151, 19);
		contentPane.add(logLayoutText);
		logLayoutText.setColumns(10);
		
		logText = new JTextField();
		logText.setBackground(SystemColor.activeCaptionBorder);
		logText.setText("Enter the text file");
		logText.setBounds(229, 218, 151, 19);
		contentPane.add(logText);
		logText.setColumns(10);
		
		JButton layoutSubmit = new JButton("Browse");
		layoutSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*layout = logLayoutText.getText().toString();
				JOptionPane.showMessageDialog(null,String.format("Layout imported successfully"));*/
				int returnVal = fc.showOpenDialog(ImportLog.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					logLayoutText.setText(file.getAbsolutePath());
					layout = file.getAbsolutePath();
				}
			}
		});
		layoutSubmit.setBackground(SystemColor.activeCaptionBorder);
		layoutSubmit.setBounds(428, 137, 117, 25);
		contentPane.add(layoutSubmit);
		
		JButton logSubmit = new JButton("Browse\n\n");
		logSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*log = logText.getText().toString();
				JOptionPane.showMessageDialog(null,String.format("Log imported successfully"));*/
				int returnVal = fc.showOpenDialog(ImportLog.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					logText.setText(file.getAbsolutePath());
					log = file.getAbsolutePath();
				}
			}
		});
		logSubmit.setBackground(SystemColor.activeCaptionBorder);
		logSubmit.setBounds(428, 215, 117, 25);
		contentPane.add(logSubmit);
		
		JLabel lblImportLog = new JLabel("Import Log");
		lblImportLog.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblImportLog.setForeground(Color.WHITE);
		lblImportLog.setBounds(242, 33, 138, 25);
		contentPane.add(lblImportLog);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogLayoutInsert.insertion(layout, log);
				JOptionPane.showMessageDialog(null,String.format("Log added to database"));
			}
		});
		btnSubmit.setBackground(SystemColor.activeCaptionBorder);
		btnSubmit.setBounds(242, 321, 117, 25);
		contentPane.add(btnSubmit);
		
		
	}
}
