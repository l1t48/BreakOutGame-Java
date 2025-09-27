import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import java.util.Random;
public class SquareCollection{
	ArrayList<ColoredBox> collection;
	Rectangle ball_rect;
	Rectangle collection_rect;
	private int win;
	Random random_val = new Random();
	Color color;
	public int score;
	GameState gameState;
	public SquareCollection() {
		collection = new ArrayList<ColoredBox>();
		int[] Block_y = {Const.BLOCK_ROW_1_Y, Const.BLOCK_ROW_2_Y, Const.BLOCK_ROW_3_Y,Const.BLOCK_ROW_4_Y, Const.BLOCK_ROW_5_Y, Const.BLOCK_ROW_6_Y, Const.BLOCK_ROW_7_Y};
		for (int i = 0; i < Block_y.length; i++) {
		    int y = Block_y[i]; 
		    for (int j = 0; j < Const.BLOCK_FOR_EACH_ROW; j++) {
		        int val = random_val.nextInt(Const.RANDOM_NUM_ROOF) + Const.RANDOM_NUM_FLOOR;
		        switch(val){
		        	case Const.CHO_1:
		        		color = Color.magenta;
		        		break;
		        	case Const.CHO_2:
		        		color = Color.yellow;
		        		break;
		        	case Const.CHO_3: 
		        		color = Color.red;
		        		break;
		        }
		        collection.add(new ColoredBox((j * Const.BLOCK_X), y, Const.BLOCK_WIDTH, Const.BLOCK_HEIGHT, color, Const.BRICK_LIFES));
		    }
		        
		}

		
	}
	
	public void setPoints(int score) {
		this.score = score; 
	}
	
	public int getPoints() { 
		return this.score; 
	}
	
	
	
	public void brick(Keyboard keyboard,Ball ball, Bat bat) {
		ball_rect  = new Rectangle(ball.getX(),ball.getY(),ball.getWidth(),ball.getHeight());
		for (int i= 0; i <collection.size(); i++) {
			ColoredBox box = collection.get(i);
			collection_rect = new Rectangle(box.getX(),box.getY(),box.getWidth(),box.getHeight());
			if(ball_rect.intersects(collection_rect)) {
				ball.setDy(-1*ball.getDy());
			}
			

			
			if(collection.size() == Const.COLLECTION_SIZE_EMPTY) { //50
				ball.setDy(Const.BALL_SETDY_DEFULT);
				ball.setDx(Const.BALL_SETDX_DEFULT);
				ball.setX(Const.BALL_SETX_DEFULT);
				ball.setY(Const.BALL_SETY_DEFULT);
				bat.setX(Const.BAT_SETX_DEFULT);	
			}
			

			if(ball_rect.intersects(collection_rect)&& box.getColor()==Color.red) {
				score = score +1;
				collection.remove(i);
				score++;
			}
			
			if(ball_rect.intersects(collection_rect)&& box.getColor()==Color.magenta) {
				collection.remove(i);
				score++;
			}
			
				
			if(ball_rect.intersects(collection_rect)&& box.getColor()==Color.yellow) {
				if(box.getBrick_lifes() == Const.BLOCK_LIFES) {
					box.setColor(Color.green);
					box.setBrick_lifes(box.getBrick_lifes()-1);
					System.out.println("lifes: "+ box.getBrick_lifes());
					score++;
			
				}
					
			}
				
			else if(ball_rect.intersects(collection_rect)&&box.getColor()==Color.green) {
				if(box.getBrick_lifes() == Const.BLOCK_LIFES-1) {
					box.setColor(Color.blue);
					box.setBrick_lifes(box.getBrick_lifes()-1);
					System.out.println("lifes: "+box.getBrick_lifes());
					score++;
				}
			}
				
			else if(ball_rect.intersects(collection_rect) &&box.getColor()==Color.blue) {
				collection.remove(i);
				System.out.println("lifes: "+box.getBrick_lifes());
				score++;
			}
			
			if(ball.getLifes() == 0) {
				gameState = GameState.GAMEOVER;
			}
		}
		

		if(collection.size()==Const.COLLECTION_SIZE_EMPTY) { 
			ball.setDx(Const.BALL_SETDX_DEFULT);
			ball.setDy(Const.BALL_SETDY_DEFULT);
			bat.setX(Const.BAT_SETX_DEFULT);
			
		}
			
	}
		

	public void hi_points(HighScore hi, String name) { 
			hi.scoretraker(getPoints(),name);
	}
	
	public void lr_points(LatestRun lr) {
			lr.scoretraker(getPoints());
	}

	


		public void draw(Graphics2D graphics) {
			Show scor = new Show(Const.SCORE_WIN_NUM_X, Const.SCORE_WIN_NUM_Y, Const.SCORE_WIN_NUM_WIDTH,Const.SCORE_WIN_NUM_HEIGHT, " "+score,Color.red);
			scor.draw(graphics);
			if(collection.size()==Const.COLLECTION_SIZE_EMPTY) { 
				win = score;
				Show win_points = new Show(Const.SCORE_WIN_WIN_POINTS_X, Const.SCORE_WIN_WIN_POINTS_Y, Const.SCORE_WIN_WIN_POINTS_WIDTH,Const.SCORE_WIN_WIN_POINTS_HEIGHT, "You Won! The point amount is: "+win,Color.pink);
				win_points.draw(graphics);		
				gameState = GameState.WON;
			}
		
			
			for(ColoredBox c : collection) {
					c.draw(graphics);
			}
		
		}




	}


