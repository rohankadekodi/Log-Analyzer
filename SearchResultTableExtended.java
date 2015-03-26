import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


public class SearchResultTableExtended extends JPanel {
JPanel contentPane;
	
	public SearchResultTableExtended(String[][] listData) {
		
		super(new GridLayout(1,0));
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
		
		String[] columnNames = new String[dataWrapping.numOfKeys+3];
		
		columnNames[0] = "Date";
		columnNames[1] = "Day";
		columnNames[2] = "Time";
		
		for(int i=0;i<dataWrapping.numOfKeys;i++) {
			columnNames[i+3] = dataWrapping.keys[i];
		}
		
		final JTable table = new JTable(listData,columnNames);
		
		table.setPreferredScrollableViewportSize(new Dimension(1000, 500));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		TableColumn column = null;
		for(int i=0;i<dataWrapping.numOfKeys+3;i++) {
			column = table.getColumnModel().getColumn(i);
			if(i==4) {
				column.setPreferredWidth(100);
			} else {
				column.setPreferredWidth(50);
			}
		}
		
	}


}
