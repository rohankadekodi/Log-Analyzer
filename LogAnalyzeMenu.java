

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class LogAnalyzeMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogAnalyzeMenu frame = new LogAnalyzeMenu();
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

	
	JComboBox analyzeDate,fromDate,fromMonth,fromYear,toDate,toMonth,toYear;
	String startTime, endTime;
	
	public LogAnalyzeMenu() {
		setTitle("Analysis Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAggregation = new JLabel("Aggregation");
		lblAggregation.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblAggregation.setForeground(Color.WHITE);
		lblAggregation.setBounds(63, 110, 118, 15);
		contentPane.add(lblAggregation);
		
		String[] granularity = {"time wise","day wise"};
		String[] datedd = {null,"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] monthdd = {null,"January","February","March","April","May","June","July","August","September","October","November","December"};
		String[] yeardd = {null,"1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014"};
		
		
		final JComboBox analyzeDate = new JComboBox(granularity);
		analyzeDate.setBackground(SystemColor.activeCaptionBorder);

			JLabel lblFrom = new JLabel("From :");
			lblFrom.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			lblFrom.setForeground(Color.WHITE);
			lblFrom.setBounds(63, 184, 70, 15);
			contentPane.add(lblFrom);
					
			final JComboBox fromDate = new JComboBox(datedd);
			fromDate.setBackground(SystemColor.activeCaptionBorder);
			fromDate.setBounds(151, 179, 49, 24);
			contentPane.add(fromDate);
					
			final JComboBox fromMonth = new JComboBox(monthdd);
			fromMonth.setBackground(SystemColor.activeCaptionBorder);
			fromMonth.setBounds(212, 179, 138, 24);
			contentPane.add(fromMonth);
					
			final JComboBox fromYear = new JComboBox(yeardd);
			fromYear.setBackground(SystemColor.activeCaptionBorder);
			fromYear.setBounds(362, 179, 118, 24);
			contentPane.add(fromYear);
			fromYear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String month = new String();
					String day = new String();
					//String s = cmbyy.getSelectedItem().toString() + (cmbMon.getSelectedIndex()+1) + lbldate.getSelectedItem().toString() + "000000";
					if((fromMonth.getSelectedIndex()) <= 9)
						month = "0" + (fromMonth.getSelectedIndex());
					else
						month = month + fromMonth.getSelectedIndex();
					
					if((fromDate.getSelectedIndex()) <= 9)
						day = "0" + (fromDate.getSelectedIndex());
					else
						day = fromDate.getSelectedItem().toString();
					
					String s = fromYear.getSelectedItem().toString() + month + day + "000000";
					
					startTime = s;
					
				}
			});
					
			JLabel label = new JLabel("To :");
			label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			label.setForeground(Color.WHITE);
			label.setBounds(63, 248, 70, 15);
			contentPane.add(label);
					
			final JComboBox toDate = new JComboBox(datedd);
			toDate.setBackground(SystemColor.activeCaptionBorder);
			toDate.setBounds(151, 243, 49, 24);
			contentPane.add(toDate);
					
			final JComboBox toMonth = new JComboBox(monthdd);
			toMonth.setBackground(SystemColor.activeCaptionBorder);
			toMonth.setBounds(212, 243, 138, 24);
			contentPane.add(toMonth);
					
			final JComboBox toYear = new JComboBox(yeardd);
			toYear.setBackground(SystemColor.activeCaptionBorder);
			toYear.setBounds(362, 243, 118, 24);
			contentPane.add(toYear);
			toYear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String month = new String();
					String day = new String();
					//String s = cmbyy1.getSelectedItem().toString(); //+ (cmbMon1.getSelectedIndex()+1) + lbldate1.getSelectedItem().toString() + "000000";
					if((toMonth.getSelectedIndex()) <= 9)
						month = "0" + (toMonth.getSelectedIndex());
					else
						month = month + (toMonth.getSelectedIndex());
					
					if((toDate.getSelectedIndex()) <= 9)
						day = "0" + (toDate.getSelectedIndex());
					else
						day = toDate.getSelectedItem().toString();
					
					String s = toYear.getSelectedItem().toString() + month + day + "999999";
							
					endTime = s;
				}
			});

			analyzeDate.setBounds(220, 105, 140, 24);
			contentPane.add(analyzeDate);
			
		
			
			JLabel lblSelect = new JLabel("Select");
			lblSelect.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			lblSelect.setForeground(Color.WHITE);
			lblSelect.setBounds(63, 68, 70, 15);
			contentPane.add(lblSelect);
			
			final JComboBox select = new JComboBox(dataWrapping.keys);
			
			select.setBackground(SystemColor.activeCaptionBorder);
			select.setBounds(212, 63, 138, 24);
			contentPane.add(select);
			
			final JTextArea textArea = new JTextArea();
			textArea.setBackground(SystemColor.activeCaptionBorder);
			textArea.setBounds(362, 63, 108, 24);
			contentPane.add(textArea);
			
			JButton btnSubmit = new JButton("To table");
			btnSubmit.setBackground(SystemColor.activeCaptionBorder);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String key = select.getSelectedItem().toString();
					String value = textArea.getText();
					
					if(analyzeDate.getSelectedItem().toString() == "time wise")
					{
						//open table
						String[] listData = new String[4];
						String[] times = {"Morning","Afternoon","Evening","Night"};
						listData = MapReduction.mapreductiontime(startTime,endTime,key,value);
						
						JFrame frame = new JFrame("SearchResultTable");
				        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						AnalysisTable a = new AnalysisTable(listData,times);
						a.setOpaque(true); //content panes must be opaque
				        frame.setContentPane(a);
				 
				        //Display the window.
				        frame.pack();
				        frame.setVisible(true);
						//System.out.println(listData[3]);
						//GraphTime frame = new GraphTime(listData);
						//frame.setVisible(true);
						
					}
				
					if(analyzeDate.getSelectedItem().toString() == "day wise")
					{
						String[] listData = new String[7];
						String[] days = {"Friday","Monday","Saturday","Sunday","Thursday","Tuesday","Wednesay"};
						listData = MapReduction.mapreductionday(startTime,endTime,key,value);
						//System.out.println(startTime);
						//System.out.println(endTime);
						//MapReduction.mapreductionday(startTime,endTime);
						JFrame frame = new JFrame("SearchResultTable");
				        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						AnalysisTable a = new AnalysisTable(listData,days);
						a.setOpaque(true); //content panes must be opaque
				        frame.setContentPane(a);
				 
				        //Display the window.
				        frame.pack();
				        frame.setVisible(true);
						//open table
				        
				        //GraphDay frame = new GraphDay(listData);
				        //frame.setVisible(true);
					}
					
					if(analyzeDate.getSelectedItem().toString() == "month wise")
					{
						//open table
					}
					
					if(analyzeDate.getSelectedItem().toString() == "year wise")
					{
						//open table
					}
					
				}
			});
			btnSubmit.setBounds(151, 324, 118, 32);
			contentPane.add(btnSubmit);
			
			JLabel lblAnalysisOfLog = new JLabel("Analysis of Log");
			lblAnalysisOfLog.setFont(new Font("Dialog", Font.ITALIC, 18));
			lblAnalysisOfLog.setForeground(Color.WHITE);
			lblAnalysisOfLog.setBounds(210, 12, 178, 24);
			contentPane.add(lblAnalysisOfLog);
			
			JButton btnToGraph = new JButton("To graph");
			btnToGraph.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = select.getSelectedItem().toString();
					String value = textArea.getText();
					
					if(analyzeDate.getSelectedItem().toString() == "time wise")
					{
						//open table
						String[] listData = new String[4];
						String[] times = {"Morning","Afternoon","Evening","Night"};
						listData = MapReduction.mapreductiontime(startTime,endTime,key,value);
						//System.out.println(listData[3]);
						GraphTime frame = new GraphTime(listData);
						frame.setVisible(true);
						
					}
				
					if(analyzeDate.getSelectedItem().toString() == "day wise")
					{
						String[] listData = new String[7];
						String[] days = {"Friday","Monday","Saturday","Sunday","Thursday","Tuesday","Wednesay"};
						listData = MapReduction.mapreductionday(startTime,endTime,key,value);
			
				        GraphDay frame = new GraphDay(listData);
				        frame.setVisible(true);
					}
					
					
				}
			});
			btnToGraph.setBackground(Color.LIGHT_GRAY);
			btnToGraph.setBounds(362, 324, 118, 32);
			contentPane.add(btnToGraph);
		
		
	}
}
