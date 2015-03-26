import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;


public class GraphTime extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphTime frame = new GraphTime();
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
	public GraphTime(String[] time) {
		setTitle("Graph Time");
		
		//System.out.println("ROhan");
		long[] timeNum = new long[4];
		for(int i=0;i<4;i++) {
			int j=0;
			String timeString = "";
			char[] timeArr = time[i].toCharArray();
			while(timeArr[j] != '.') {
				timeString = timeString + timeArr[j];
				j++;
			}
			
			timeNum[i] = Long.parseLong(timeString);
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(26, 12, 525, 307);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(timeNum[0], "", "Morning");
		dataset.setValue(timeNum[1], "", "Afternoon");
		dataset.setValue(timeNum[2], "", "Evening");
		dataset.setValue(timeNum[3], "", "Night");
		
		JFreeChart chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.HORIZONTAL, false, false, false);
		CategoryPlot catPlot = chart.getCategoryPlot();
		catPlot.setRangeGridlinePaint(Color.BLACK);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		
		panel.removeAll();
		panel.add(chartPanel,BorderLayout.CENTER);
		panel.validate();
	}
}
