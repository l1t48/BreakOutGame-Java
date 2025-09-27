import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Show extends Sprite {
	private String information;
	private Color color;
	public Show (int x, int y, int width, int hight, String info, Color color) {
		super(x, y, width, hight);
		this.color = color;
		information = info;
	}
	

	
	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		Font font = new Font("Verdena", Font.BOLD,getWidth());
		graphics.setFont(font);
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		graphics.drawString(information,getX(),getY());
	}
}
