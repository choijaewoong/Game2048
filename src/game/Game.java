package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener
{
	private static Board board;
		
	public Game()
	{
		board = new Board();
		
		board.addKeyListener(this);	
	}
	
	public static void selectedMode(int mode)
	{
		board.rem(mode);
		
		board.init();
		board.first();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		//System.out.println(key.getKeyChar());
		
		switch(key.getKeyChar())
		{
		case 'd' :
			Move.right(board);
			break;
		case 'a' :
			Move.left(board);
			break;
		case 'w' :
			Move.up(board);
			break;
		case 's' :
			Move.down(board);
			break;
		default :
			break;
		}
		
		Move.goal(board);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
