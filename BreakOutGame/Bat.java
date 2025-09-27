import java.awt.*;

public class Bat extends Sprite{
	public Bat(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
			if(getX()<(Const.BOARD_SIZE_X-Const.DEF_BETWEEN_BOARD_BORDER) - getWidth()) {
				if(keyboard.isKeyDown(Key.Right)) {
					setX(getX()+Const.BAT_DX);
				}
			}

			if(getX()> (Const.WIN_X_START+ Const.DEF_BETWEEN_BOARD_BORDER)) {
				if(keyboard.isKeyDown(Key.Left)) {
					setX(getX()-Const.BAT_DX);
				}
			}

	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.red);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
}


