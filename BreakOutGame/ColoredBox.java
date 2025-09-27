import java.awt.Graphics2D;
import java.awt.Color;
import java.util.*;


public class ColoredBox extends Sprite{
	private Color color;
	private int brick_lifes;
	public ColoredBox(int x, int y, int width, int height, Color color, int brick_lifes) {
		super(x, y, width, height);
		this.color = color;
		this.brick_lifes = brick_lifes;

	}
	
	
	public void setBrick_lifes(int brick_lifes) {
		this.brick_lifes = brick_lifes; 
	}
	
	public int getBrick_lifes() { 
		return this.brick_lifes; 
	}
	
	public void setColor(Color color) {
		this.color = color; 
	}
	
	public Color getColor() { 
		return this.color; 
	}
	
	
	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}
	
	
}
