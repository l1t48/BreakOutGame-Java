import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JComponent;

public class GameBoard extends JComponent {
	private final int FPS = Const.FPS_NUM; 
	private Game game;
	private Keyboard keyboard;
	public GameBoard(HighScore highscore, LatestRun latestrun) {
		keyboard = new Keyboard();
		game = new Game(this, highscore, latestrun);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Const.BOARD_SIZE_X, Const.BOARD_SIZE_Y);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		game.draw(graphics);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(true) {
			game.update(keyboard);
			try {
				Thread.sleep(Const.THR_SLEEP / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
