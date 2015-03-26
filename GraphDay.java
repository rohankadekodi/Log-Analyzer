import java.awt.BorderLayout;
import java.awt.Color;
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



public class GraphDay extends JFrame {

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
	public GraphDay(String[] day) {
		setTitle("Graph Day");
		
		//System.out.println("ROhan");
		long[] dayNum = new long[7];
		for(int i=0;i<7;i++) {
			dayNum[i] = Long.parseLong(day[i]);
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
		dataset.setValue(dayNum[0], "", "Friday");
		dataset.setValue(dayNum[1], "", "Monday");
		dataset.setValue(dayNum[2], "", "Saturday");
		dataset.setValue(dayNum[3], "", "Sunday");
		dataset.setValue(dayNum[4], "", "Thursday");
		dataset.setValue(dayNum[5], "", "Tuesday");
		dataset.setValue(dayNum[6], "", "Wednesday");
		
		JFreeChart chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.HORIZONTAL, false, false, false);
		CategoryPlot catPlot = chart.getCategoryPlot();
		catPlot.setRangeGridlinePaint(Color.BLACK);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		
		panel.removeAll();
		panel.add(chartPanel,BorderLayout.CENTER);
		panel.validate();
	}
}
