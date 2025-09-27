import java.awt.*;

import java.util.*;

import javax.swing.JOptionPane;
public class Game {
	SquareCollection collection;
	Wall left_wall;
	Wall right_wall;
	Wall top_wall;
	Wall bottom_wall;
	Ball ball;
	Ball show_ball;
	Bat bat;
	Show game_over;
	Show score;
	Show ball_lifes;
	HighScore highscore;
	LatestRun latestrun;
	String user_input;
	GameState gameState;
	
	public Game(GameBoard board,HighScore highscore, LatestRun latestrun) {
		 this.highscore = highscore;
		 this.latestrun = latestrun;

		 user_input = JOptionPane.showInputDialog("Enter your name without spaces");
		 while(user_input.isEmpty()|| user_input.length() > Const.MAX_BOKSTAVER) {
			 user_input = JOptionPane.showInputDialog("Enter your name without spaces");
		 }
		 left_wall = new Wall(Const.WALL_LEFT_X,Const.WALL_LEFT_Y,Const.WALL_LEFT_WIDTH,Const.WALL_LEFT_HEIGHT);
		 right_wall = new Wall(Const.WALL_RIGHT_X,Const.WALL_RIGHT_Y,Const.WALL_RIGHT_WIDTH,Const.WALL_RIGHT_HEIGHT);
		 top_wall = new Wall(Const.WALL_TOP_X,Const.WALL_TOP_Y,Const.WALL_TOP_WIDTH,Const.WALL_TOP_HEIGHT);
		 bottom_wall = new Wall(Const.WALL_BOTTOM_X,Const.WALL_BOTTOM_Y,Const.WALL_BOTTOM_WIDTH,Const.WALL_BOTTOM_HEIGHT);
		 ball = new Ball(Const.BALL_X, Const.BALL_Y, Const.BALL_WIDTH, Const.BALL_HEIGTH,Const.BALL_DX,Const.BALL_DY, Color.red,Const.BALL_LIFES); 
		 bat = new Bat(Const.BAT_X, Const.BAT_Y, Const.BAT_WIDTH, Const.BAT_HEIGHT);	 
		 game_over = new Show(Const.GAME_OVER_WIN_X, Const.GAME_OVER_WIN_Y, Const.GAME_OVER_WIN_WIDTH,Const.GAME_OVER_WIN_HEIGHT, "Game over", Color.yellow);
		 score = new Show(Const.SCORE_WIN_X, Const.SCORE_WIN_Y, Const.SCORE_WIN_WIDTH,Const.SCORE_WIN_HEIGHT, "Score: ", Color.red);
		 ball_lifes= new Show(Const.BALL_LIFES_X, Const.BALL_LIFES_Y, Const.BALL_LIFES_WIDTH,Const.BALL_LIFES_HEIGHT,  ": x" +(ball.getLifes()), Color.magenta);
		 show_ball = new Ball(Const.SHOW_BALL_X, Const.SHOW_BALL_Y, Const.SHOW_BALL_WIDTH,Const.SHOW_BALL_HEIGHT,Const.SHOW_BALL_DX,Const.SHOW_BALL_DY,Color.magenta,Const.BALL_LIFES);
		 collection = new SquareCollection();
		 gameState = GameState.RUNNING;
	}

	private void StartNewGame() {
		 user_input = JOptionPane.showInputDialog("Enter your name without spaces");
		 while(user_input.isEmpty()|| user_input.length() > Const.MAX_BOKSTAVER) {
			 user_input = JOptionPane.showInputDialog("Enter your name without spaces");
		 }
		 ball = new Ball(Const.BALL_X, Const.BALL_Y, Const.BALL_WIDTH, Const.BALL_HEIGTH,Const.BALL_DX,Const.BALL_DY, Color.red,Const.BALL_LIFES); 
		 bat = new Bat(Const.BAT_X, Const.BAT_Y, Const.BAT_WIDTH, Const.BAT_HEIGHT);	
		 score = new Show(Const.SCORE_WIN_X, Const.SCORE_WIN_Y, Const.SCORE_WIN_WIDTH,Const.SCORE_WIN_HEIGHT, "Score: ", Color.red);
		 ball_lifes= new Show(Const.BALL_LIFES_X, Const.BALL_LIFES_Y, Const.BALL_LIFES_WIDTH,Const.BALL_LIFES_HEIGHT, ": x" +(ball.getLifes()), Color.magenta);
		 collection = new SquareCollection();
		 gameState = GameState.RUNNING;
	}

	public void update(Keyboard keyboard) {
		ball.update(keyboard);
		bat.update(keyboard);
		ball.move(bat);
		collection.brick(keyboard,ball,bat);
		gameState = GameState.RUNNING;
		if(collection.gameState == GameState.WON||collection.gameState == GameState.GAMEOVER) {
			collection.hi_points(highscore,user_input);
			collection.lr_points(latestrun);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			StartNewGame();			
		}

	}

	public void draw(Graphics2D graphics) {

				collection.draw(graphics);
				ball.draw(graphics);
				left_wall.draw(graphics);
				right_wall.draw(graphics);
				top_wall.draw(graphics);
				bottom_wall.draw(graphics);	
				bat.draw(graphics);	
				if(ball.getY()>=Const.BOARD_SIZE_Y-ball.getWidth()) {
					if(ball.getLifes() > Const.SHOW_BALL_LIFES) {
						System.out.println("----\n"+ball.getLifes()+"\n---");
						ball = new Ball(Const.BALL_X, Const.BALL_Y, Const.BALL_WIDTH, Const.BALL_HEIGTH,Const.BALL_DX,Const.BALL_DY, Color.red, ball.getLifes()-1);
						ball_lifes= new Show(Const.BALL_LIFES_X, Const.BALL_LIFES_Y, Const.BALL_LIFES_WIDTH,Const.BALL_LIFES_HEIGHT, ": x" + (ball.getLifes()), Color.magenta);
						bat = new Bat(Const.BAT_X, Const.BAT_Y, Const.BAT_WIDTH, Const.BAT_HEIGHT);
					}
				
					else{
						game_over.draw(graphics);
						ball.setDx(Const.LOSE_SETDX);
						ball.setDy(Const.LOSE_SETDY);
					}
							
				}
				
				show_ball.draw(graphics);
				ball_lifes.draw(graphics);
				score.draw(graphics);
				gameState = GameState.RUNNING;

		}
		
		}
