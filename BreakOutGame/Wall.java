import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Wall extends Sprite {
	public Wall (int x, int y, int width, int hight) {
		super(x, y, width, hight);
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.black);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

}
