import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Sprite{
	private int lifes;
	private int dx;
	private int dy;
	Rectangle ball_rect;
	Rectangle bat_rect;
	Ball ball;
	Color color;


	
	public Ball(int x, int y, int width, int height, int dx, int dy, Color color, int lifes) {
		super(x,y,width, height);
		this.color = color;
		this.dx = dx;
		this.dy = dy;
		this.lifes = lifes; 
	}
	
	public void setDx(int dx) {
		this.dx = dx; 
	}
	public void setDy(int dy) {
		this.dy = dy; 
	}
	
	public int getDx() { 
		return this.dx; 
	}
	public int getDy() { 
		return this.dy; 
	}
	
	public void setLifes(int lifes) { 
		this.lifes = lifes;
	}
	public int getLifes() { 
		return this.lifes; 
	}

	
	public void update(Keyboard keyboard){
		setX(getX()+dx);
		setY(getY()+dy);
		
		if(getX() <= Const.BALL_SLOPE || getX()>=Const.BOARD_SIZE_X-this.getWidth() || getX() == Const.BALL_SLOPE ) {
			dx = -dx;
		}
		
		else if(getY() <= Const.BALL_SLOPE) {
			dy = -dy;
		}

	}
	


	public void move(Bat bat) {
		ball_rect  = new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
		bat_rect  = new Rectangle(bat.getX(),bat.getY(),bat.getWidth(),bat.getHeight());
		if(ball_rect.intersects(bat_rect)) {
			this.setDy(-1*this.getDy());
		}
		
		
	}
	
			
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}
}


/*
 * 
 */

