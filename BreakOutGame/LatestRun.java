import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class LatestRun extends JPanel{
	private DefaultListModel data;
	private JList LastRuns;
	public LatestRun(){
		setLayout(new GridLayout(1, 1));
		

		data = new DefaultListModel();
		LastRuns = new JList(data);
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green),("Last runs"));
		border.setTitleColor(Color.green);
		LastRuns.setBorder(border);
		LastRuns.setBackground(Color.black);
		LastRuns.setForeground(Color.green);
		LastRuns.setFocusable(false);
		add(LastRuns);
		LastRuns.setPreferredSize(new Dimension(150,10));
	}
	
	public void scoretraker(int points) {
			int pos = 0;
			data.add(pos,points);
			if(data.getSize()==4) {
				data.removeElementAt(data.getSize()-1);
				
			}		

	}
	
	

}
