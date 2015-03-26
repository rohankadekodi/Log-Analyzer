
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class AnalysisTable extends JPanel {	
		
	JPanel contentPane;
	
	public AnalysisTable(final String[] listDataNum,String[] columnNames) {
		
		//System.out.println("Rohan");
		super(new GridLayout(1,0));
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
		//System.out.println("Rohan");
		String[][] listData = new String[1][listDataNum.length];
		for(int i=0;i<listDataNum.length;i++) {
			listData[0][i] = listDataNum[i];
		}
		final JTable table = new JTable(listData,columnNames);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		TableColumn column = null;
		for(int i=0;i<listDataNum.length;i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(50);
		}
		
	/*	JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create and set up the window.
		        //Display the window.
				GraphTime frame = new GraphTime(listDataNum);
				frame.setVisible(true);
				//SearchResultTable ans = new SearchResultTable(logRetrieval);
				//ans.setVisible(true);
			
			}
		});
		btnSubmit.setBounds(405, 165, 85, 25);
		contentPane.add(btnSubmit);*/

	}

}
