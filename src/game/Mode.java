package game;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Mode implements ItemListener {
	
	public int size = 4; // Board Size
	private float gap = (float)20/size; // size에 따른 간격
	
	public int getSize() {
		return size;
	}
	public float getGap() {
		return gap;
	}


	public interface OnChangeModeListener {
          public void onRemoveBoard(int preMode);
    }
    OnChangeModeListener mListener;
    public void setOnItemClickListener(OnChangeModeListener listener) {
        mListener = listener;
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int preSize = size;
		switch((String)e.getItem())
		{
		case "3x3":
			size = 3;
			break;
		case "4x4":
			size = 4;
			break;
		case "5x5":
			size = 5;
			break;
		case "6x6":
			size = 6;
			break;
		case "7x7":
			size = 7;
			break;
		case "8x8":
			size = 8;
			break;
		default:
			break;
		}
		gap = (float)20/size;
		mListener.onRemoveBoard(preSize);
	}

}
