package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class Game implements KeyListener, Move
{
	public final static int GOAL = 2048;	
	int best = 0;
	int score = 0;
	
	private BoardView boardView;
	
	Mode.OnChangeModeListener mChangeModeListener = new Mode.OnChangeModeListener() {
		
		@Override
		public void onRemoveBoard(int preMode) {
			// TODO Auto-generated method stub
			restart(preMode);		
		}
	};
	
	public Game()
	{
		boardView = new BoardView();		
		boardView.addKeyListener(this);		
		boardView.getMode().setOnItemClickListener(mChangeModeListener);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		//System.out.println(key.getKeyChar());
		
		switch(key.getKeyCode())
		{
		case KeyEvent.VK_RIGHT :
			right();
			break;
		case KeyEvent.VK_LEFT :
			left();
			break;
		case KeyEvent.VK_UP :
			up();
			break;
		case KeyEvent.VK_DOWN :
			down();
			break;
		default :
			break;
		}		
		goal();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		boolean move = false;
		int size = boardView.getMode().getSize();
		
		for(int i=0; i<size; i++)
		{
			int count = size-1;
			
			for (int j=size-2 ; j>=0 ; j--)
			{
				int num;
				
				if (boardView.getStr(i, j).equals("")) continue;

				if (boardView.getStr(i, count).equals(boardView.getStr(i, j)))
				{
					num = Integer.parseInt(boardView.getStr(i, count))*2;
					
					changeBoard(i, count, i, j, num);					
					//score += num[i][count];
					score += Integer.parseInt(boardView.getStr(i,count));
					move = true;
					count--;
					continue;					
				}
				else if (boardView.getStr(i,count).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
					
					changeBoard(i, count, i, j, num);			
					move = true;
					continue;
				}
				else if (boardView.getStr(i, count-1).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
					
					changeBoard(i, count-1, i, j, num);			
					move = true;
					count--;
					continue;
				}
				
				count--;
			}
		}
		if (move){
			addNum();
			boardView.setScore(score);
		}
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		boolean move = false;
		int size = boardView.getMode().getSize();
		
		for(int i=0; i<size; i++)
		{
			int count = 0;
			
			for (int j=1 ; j<size ; j++)
			{
				int num;
				
				if (boardView.getStr(i, j).equals("")) continue;

				if (boardView.getStr(i, count).equals(boardView.getStr(i, j)))
				{
					num = Integer.parseInt(boardView.getStr(i, count))*2;
					
					changeBoard(i, count, i, j, num);
					
					//score += num[i][count];
					score += Integer.parseInt(boardView.getStr(i,count));
					move = true;
					count++;
					continue;					
				}
				else if (boardView.getStr(i,count).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
					
					changeBoard(i, count, i, j, num);
					move = true;
					continue;
				}
				else if (boardView.getStr(i, count+1).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
					
					changeBoard(i, count+1, i, j, num);
					move = true;
					count++;
					continue;
				}
				count++;
			}
		}
		if (move) {
			addNum();
			boardView.setScore(score);
		}
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		boolean move = false;
		int size =  boardView.getMode().getSize();
		
		for(int j=0; j<size; j++)
		{
			int count = 0;
			
			for (int i=1 ; i<size ; i++)
			{
				int num;
				
				if (boardView.getStr(i, j).equals("")) continue;

				if (boardView.getStr(count, j).equals(boardView.getStr(i, j)))
				{
					num = Integer.parseInt(boardView.getStr(count, j))*2;
					
					changeBoard(count, j, i, j, num);
					//score += num[i][count];
					score += Integer.parseInt(boardView.getStr(count,j));
					move = true;
					count++;
					continue;					
				}
				else if (boardView.getStr(count, j).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
					
					changeBoard(count, j, i, j, num);
					move = true;
					continue;
				}
				else if (boardView.getStr(count+1, j).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
					
					changeBoard(count+1, j, i, j, num);move = true;
					count++;
					continue;
				}
				count++;
			}
		}
		if (move){
			addNum();
			boardView.setScore(score);
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		boolean move = false;
		int size = boardView.getMode().getSize();		
		
		for(int j=0; j<size; j++)
		{
			int count = size-1;
			
			for (int i=size-2 ; i>=0 ; i--)
			{
				int num; 
				
				if (boardView.getStr(i, j).equals("")) continue;

				if (boardView.getStr(count, j).equals(boardView.getStr(i, j)))
				{	
					num = Integer.parseInt(boardView.getStr(count, j))*2;
					
					changeBoard(count, j, i, j, num);
					//score += num[i][count];
					score += Integer.parseInt(boardView.getStr(count,j));
					move = true;
					count--;
					continue;					
				}
				else if (boardView.getStr(count, j).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
							
					changeBoard(count, j, i, j, num);
					move = true;
					continue;
				}
				else if (boardView.getStr(count-1, j).equals(""))
				{
					num = Integer.parseInt(boardView.getStr(i,j));
					
					changeBoard(count-1, j, i, j, num);
					move = true;
					count--;
					continue;
				}
				count--;
			}
		}
		if (move){
			addNum();
			boardView.setScore(score);
		}
	}
	
	// 숫자 이동 후 새로운 숫자 생성 메소드
	public boolean addNum()
	{	
		int size = boardView.getMode().getSize();
		int[] empty = new int[size*size];
		int count = 0;
		
		for (int i = 0; i < size*size; i++)
		{
			if (boardView.getStr(i / size, i % size).equals(""))
				empty[count++] = i;		
		}
				
		int n = empty[(int)(Math.random()*count)];
		
		int[] arr = {2,2,2,4};
		int a = arr[(int)(Math.random()*4)];
		
		boardView.setStr(n/size, n%size, String.valueOf(a));
		boardView.getPanel(n/size, n%size).setBackground(new NumColor(a).getColor());		
		
		if (count == 1) //숫자로 꽉찬 경우 병합할 숫자가 있는지 확인
		{
			failCheck();
		}
		return true;
	}
	
	public void changeBoard(int i, int j, int i2, int j2, int num)
	{
		boardView.setStr(i, j, String.valueOf(num));
		boardView.setStr(i2,j2,"");
		boardView.getPanel(i, j).setBackground(new NumColor(num).getColor());
		boardView.getPanel(i2, j2).setBackground(new NumColor(0).getColor());
	}
	
	// board가 모두 채워졌을 경우 병합할 숫자가 있는지 체크하는 메소드
	public boolean failCheck()
	{
		int size = boardView.getMode().getSize();
		for (int i = 0; i < size-1; i++)
		{
			for (int j = 0; j < size-1; j++)
			{
				if (boardView.getStr(i, j).equals(boardView.getStr(i, j+1)))
					return true;			
				if (boardView.getStr(i, j).equals(boardView.getStr(i+1, j)))
					return true;
			}
		}
		for (int i = 0; i < size-1; i++)
		{
			if (boardView.getStr(i, size-1).equals(boardView.getStr(i+1, size-1)))
				return true;				
		}
		for (int j = 0; j < size-1; j++){
			if (boardView.getStr(size-1, j).equals(boardView.getStr(size-1, j+1)))
				return true;
		}
		JOptionPane.showMessageDialog(null, "FAIL!!!", "Notification", JOptionPane.INFORMATION_MESSAGE);
		restart(boardView.getMode().getSize()); // 게임 재시작 
		return false;
	}
	//Goal에 도달 했는지 확인 하는 메소드
	public void goal()
	{
		int size = boardView.getMode().getSize();
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				if(boardView.getStr(i, j).equals(String.valueOf(GOAL)))
				{
					JOptionPane.showMessageDialog(null, "GOAL!!!", "Notification", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	// 게임 재시작
	public void restart(int size){
		boardView.removeBoard(size);
		boardView.boardInit();
		score = 0;
		boardView.setScore(score);
	}
}
