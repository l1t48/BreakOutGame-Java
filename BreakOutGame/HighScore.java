import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class HighScore extends JPanel {
	private DefaultListModel<String> data;
	private JList<String> HighScore;
	
	public HighScore(){
		setLayout(new GridLayout (1,1)); 
		
		data = new DefaultListModel<>();
		HighScore = new JList<>(data);
		HighScore.setBackground(Color.black);
		HighScore.setForeground(Color.green);
		HighScore.setFocusable(false);
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green),("High score"));
		border.setTitleColor(Color.green);
		HighScore.setBorder(border);
		HighScore.setBackground(Color.black);
		HighScore.setForeground(Color.green);
		add(HighScore);
		HighScore.setPreferredSize(new Dimension(150,10));
		
	}
	
	public void scoretraker(int points, String name) {

			int pos = 0;
			data.add(pos, name + " " + points);
			List<String> list = Collections.list(data.elements());
			Collections.sort(list, new PsComparator());
			Collections.reverse(list);
			data.clear();
			for(String score: list) {
				data.addElement(score);

			}
			if(data.getSize()==11) {
				data.removeElementAt(data.getSize()-1);
			}	
	}


	

}
