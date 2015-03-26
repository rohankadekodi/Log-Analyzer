import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SearchLogExtended extends JFrame {

	private JPanel contentPane;
	final JTextField textField1;
	final JTextField textField2;
	String timeFrom = null;
	String timeTo = null;
	String operator = null;
	String[][] logRetrieval = new String[500][dataWrapping.numOfKeys+3];

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public SearchLogExtended() {
		setTitle("Searching");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox combo1 = new JComboBox(dataWrapping.keys);
		combo1.setBounds(100, 68, 157, 24);
		contentPane.add(combo1);
		
		JLabel lblSelect = new JLabel("Select");
		lblSelect.setForeground(Color.WHITE);
		lblSelect.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblSelect.setBounds(37, 73, 70, 15);
		contentPane.add(lblSelect);
		
		JLabel label = new JLabel("=");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(275, 73, 31, 15);
		contentPane.add(label);
		
		textField1 = new JTextField();
		textField1.setText("ALL");
		textField1.setBounds(306, 70, 114, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JButton btnAnd = new JButton("AND");
		btnAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "AND";
			}
		});
		btnAnd.setBackground(SystemColor.activeCaptionBorder);
		btnAnd.setBounds(170, 129, 87, 25);
		contentPane.add(btnAnd);
		
		JButton btnOr = new JButton("OR");
		btnOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "OR";
			}
		});
		btnOr.setBackground(SystemColor.activeCaptionBorder);
		btnOr.setBounds(306, 129, 87, 25);
		contentPane.add(btnOr);
		
		JLabel lblSelect_1 = new JLabel("Select");
		lblSelect_1.setForeground(Color.WHITE);
		lblSelect_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblSelect_1.setBounds(37, 194, 70, 15);
		contentPane.add(lblSelect_1);
		
		final JComboBox combo2 = new JComboBox(dataWrapping.keys);
		combo2.setBounds(100, 189, 157, 24);
		contentPane.add(combo2);
		
		JLabel label_2 = new JLabel("=");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_2.setBounds(275, 194, 31, 15);
		contentPane.add(label_2);
		
		textField2 = new JTextField();
		textField2.setText("ALL");
		textField2.setToolTipText("");
		textField2.setColumns(10);
		textField2.setBounds(306, 191, 114, 21);
		contentPane.add(textField2);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblFrom.setBounds(37, 274, 70, 15);
		contentPane.add(lblFrom);
		
		String datedd[]={null,"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String Mndd[]={null,"January","February","March","April","May","June","July","August","September","October","November","December"};
		String Yydd[] = {null,"1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014"};
		
		final JComboBox dateFrom = new JComboBox(datedd);
		dateFrom.setBounds(100, 269, 54, 24);
		contentPane.add(dateFrom);
		
		final JComboBox monthFrom = new JComboBox(Mndd);
		monthFrom.setBounds(170, 269, 114, 24);
		contentPane.add(monthFrom);
		
		final JComboBox yearFrom = new JComboBox(Yydd);
		yearFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String month = new String();
				String day = new String();
				//String s = cmbyy.getSelectedItem().toString() + (cmbMon.getSelectedIndex()+1) + lbldate.getSelectedItem().toString() + "000000";
				if((monthFrom.getSelectedIndex()) <= 9)
					month = "0" + (monthFrom.getSelectedIndex());
				else
					month = month + monthFrom.getSelectedIndex();
				
				if((dateFrom.getSelectedIndex()) <= 9)
					day = "0" + (dateFrom.getSelectedIndex());
				else
					day = dateFrom.getSelectedItem().toString();
				
				String s = yearFrom.getSelectedItem().toString() + month + day + "000000";
				
				timeFrom = s;
			}
		});
		yearFrom.setBounds(306, 269, 87, 24);
		contentPane.add(yearFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblTo.setBounds(37, 326, 70, 15);
		contentPane.add(lblTo);
		
		final JComboBox dateTo = new JComboBox(datedd);
		dateTo.setBounds(100, 317, 54, 24);
		contentPane.add(dateTo);
		
		final JComboBox monthTo = new JComboBox(Mndd);
		monthTo.setBounds(170, 317, 114, 24);
		contentPane.add(monthTo);
		
		final JComboBox yearTo = new JComboBox(Yydd);
		yearTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String month = new String();
				String day = new String();
				//String s = cmbyy1.getSelectedItem().toString(); //+ (cmbMon1.getSelectedIndex()+1) + lbldate1.getSelectedItem().toString() + "000000";
				if((monthTo.getSelectedIndex()) <= 9)
					month = "0" + (monthTo.getSelectedIndex());
				else
					month = month + (monthTo.getSelectedIndex());
				
				if((dateTo.getSelectedIndex()) <= 9)
					day = "0" + (dateTo.getSelectedIndex());
				else
					day = dateTo.getSelectedItem().toString();
				
				String s = yearTo.getSelectedItem().toString() + month + day + "999999";
						
				timeTo = s;
			}
		});
		yearTo.setBounds(306, 317, 87, 24);
		contentPane.add(yearTo);
		
		JLabel lblSearchLog = new JLabel("Search Log");
		lblSearchLog.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblSearchLog.setForeground(Color.WHITE);
		lblSearchLog.setBounds(251, 12, 121, 24);
		contentPane.add(lblSearchLog);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String select1,value1,select2,value2;
				select1 = combo1.getSelectedItem().toString();
				if(textField1.getText() != "ALL")
					value1 = textField1.getText();
				else
					value1 = null;
				select2 = combo2.getSelectedItem().toString();
				if(textField1.getText() != "ALL")
					value2 = textField2.getText();
				else
					value2 = null;
				
				logRetrieval = SearchRetrieveExtended.retrieval(select1, value1, select2, value2, operator, timeFrom, timeTo);
				
				//System.out.println(dataWrapping.numOfSearchRows);
				String [][]logData = new String[dataWrapping.numOfSearchRows][dataWrapping.numOfKeys+3];
				
				for(int i=0;i<dataWrapping.numOfSearchRows;i++) {
					for(int j=0;j<dataWrapping.numOfKeys+3;j++){
						logData[i][j] = logRetrieval[i][j];
					}
				}
				//logData = logRetrieval;
				
				 JFrame frame = new JFrame("SearchResultTable");
			        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			 
			        //Create and set up the content pane.
			        SearchResultTableExtended newContentPane = new SearchResultTableExtended(logData);
			        newContentPane.setOpaque(true); //content panes must be opaque
			        frame.setContentPane(newContentPane);
			        
			        //Display the window.
			        frame.pack();
			        frame.setVisible(true);
			        setVisible(false);
			}
		});
		Submit.setBackground(SystemColor.activeCaptionBorder);
		Submit.setBounds(445, 368, 117, 25);
		contentPane.add(Submit);
	}
}
