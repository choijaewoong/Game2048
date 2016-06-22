package game;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ModeChanged implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int preMode = Board.MODE; 
		
		switch((String)e.getItem())
		{
		case "3x3":
			Board.MODE = 3;
			break;
		case "4x4":
			Board.MODE = 4;
			break;
		case "5x5":
			Board.MODE = 5;
			break;
		case "6x6":
			Board.MODE = 6;
			break;
		case "7x7":
			Board.MODE = 7;
			break;
		case "8x8":
			Board.MODE = 8;
			break;
		default:
			break;
		}
		
		Board.GAP = (float)20/Board.MODE;
		Game.selectedMode(preMode);			
	}

}
