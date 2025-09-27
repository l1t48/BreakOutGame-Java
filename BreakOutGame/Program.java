import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	private HighScore highscore;
	private LatestRun latestrun;
	public Program() {
		setLayout(new BorderLayout());
		latestrun = new LatestRun();
		highscore = new HighScore();

		board = new GameBoard(highscore, latestrun); 
		add(board, BorderLayout.CENTER);
		add(highscore, BorderLayout.EAST);
		add(latestrun, BorderLayout.WEST);
		setResizable(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

}
