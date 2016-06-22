package game;

import java.util.Random;

public class Move {
	
	// 'd'키를 입력 했을 경우 호출
	public static void right(Board board)
	{
		boolean move = false;
				
		for(int i=0; i<Board.MODE; i++)
		{
			int count = Board.MODE-1;
			
			for (int j=Board.MODE-2 ; j>=0 ; j--)
			{
				int num;
				
				if (board.getStr(i, j).equals("")) continue;

				if (board.getStr(i, count).equals(board.getStr(i, j)))
				{
					num = Integer.parseInt(board.getStr(i, count))*2;
					
					boardSetting(board, i, count, i, j, num);					
					//score += num[i][count];
					move = true;
					count--;
					continue;					
				}
				else if (board.getStr(i,count).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
					
					boardSetting(board, i, count, i, j, num);			
					move = true;
					continue;
				}
				else if (board.getStr(i, count-1).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
					
					boardSetting(board, i, count-1, i, j, num);			
					move = true;
					count--;
					continue;
				}
				
				count--;
			}
		}
		if (move) addNum(board);		
	}

	// 'a'키를 입력 했을 경우 호출
	public static void left(Board board)
	{
		boolean move = false;
		
		for(int i=0; i<Board.MODE; i++)
		{
			int count = 0;
			
			for (int j=1 ; j<Board.MODE ; j++)
			{
				int num;
				
				if (board.getStr(i, j).equals("")) continue;

				if (board.getStr(i, count).equals(board.getStr(i, j)))
				{
					num = Integer.parseInt(board.getStr(i, count))*2;
					
					boardSetting(board, i, count, i, j, num);
					
					//score += num[i][count];
					move = true;
					count++;
					continue;					
				}
				else if (board.getStr(i,count).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
					
					boardSetting(board, i, count, i, j, num);
					move = true;
					continue;
				}
				else if (board.getStr(i, count+1).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
					
					boardSetting(board, i, count+1, i, j, num);
					move = true;
					count++;
					continue;
				}
				count++;
			}
		}
		if (move) addNum(board);
	}

	// 'w'키를 입력 했을 경우 호출
	public static void up(Board board)
	{
		boolean move = false;
		
		for(int j=0; j<Board.MODE; j++)
		{
			int count = 0;
			
			for (int i=1 ; i<Board.MODE ; i++)
			{
				int num;
				
				if (board.getStr(i, j).equals("")) continue;

				if (board.getStr(count, j).equals(board.getStr(i, j)))
				{
					num = Integer.parseInt(board.getStr(count, j))*2;
					
					boardSetting(board, count, j, i, j, num);
					//score += num[i][count];
					move = true;
					count++;
					continue;					
				}
				else if (board.getStr(count, j).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
					
					boardSetting(board, count, j, i, j, num);
					move = true;
					continue;
				}
				else if (board.getStr(count+1, j).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
					
					boardSetting(board, count+1, j, i, j, num);move = true;
					count++;
					continue;
				}
				count++;
			}
		}
		if (move) addNum(board);
	}
	
	// 's'키를 입력 했을 경우 호출
	public static void down(Board board)
	{
		boolean move = false;
		
		for(int j=0; j<Board.MODE; j++)
		{
			int count = Board.MODE-1;
			
			for (int i=Board.MODE-2 ; i>=0 ; i--)
			{
				int num; 
				
				if (board.getStr(i, j).equals("")) continue;

				if (board.getStr(count, j).equals(board.getStr(i, j)))
				{	
					num = Integer.parseInt(board.getStr(count, j))*2;
					
					boardSetting(board, count, j, i, j, num);
					//score += num[i][count];
					move = true;
					count--;
					continue;					
				}
				else if (board.getStr(count, j).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
							
					boardSetting(board, count, j, i, j, num);
					move = true;
					continue;
				}
				else if (board.getStr(count-1, j).equals(""))
				{
					num = Integer.parseInt(board.getStr(i,j));
					
					boardSetting(board, count-1, j, i, j, num);
					move = true;
					count--;
					continue;
				}
				count--;
			}
		}
		if (move) addNum(board);
	}
	
	// 숫자 이동 후 새로운 숫자 생성 메소드
	public static boolean addNum(Board board)
	{		
		int[] empty = new int[Board.MODE*Board.MODE];
		int count = 0;
		
		for (int i = 0; i < Board.MODE*Board.MODE; i++)
		{
			if (board.getStr(i / Board.MODE, i % Board.MODE).equals(""))
				empty[count++] = i;		
		}
				
		int n = empty[(int)(Math.random()*count)];
		
		int[] arr = {2,2,2,4};
		int a = arr[(int)(Math.random()*4)];
		
		board.setStr(n/Board.MODE, n%Board.MODE, String.valueOf(a));
		board.getPanel(n/Board.MODE, n%Board.MODE).setBackground(new HSBColor(a).getColor());		
		
		if (count == 1) //숫자로 꽉찬 경우 병합할 숫자가 있는지 확인
		{
			failCheck(board);
		}
		return true;
	}
	
	public static void boardSetting(Board board, int i, int j, int i2, int j2, int num)
	{
		board.setStr(i, j, String.valueOf(num));
		board.setStr(i2,j2,"");
		board.getPanel(i, j).setBackground(new HSBColor(num).getColor());
		board.getPanel(i2, j2).setBackground(new HSBColor(0).getColor());
	}
	
	// board가 모두 채워졌을 경우 병합할 숫자가 있는지 체크하는 메소드
	public static boolean failCheck(Board board)
	{
		for (int i = 0; i < Board.MODE-1; i++)
		{
			for (int j = 0; j < Board.MODE-1; j++)
			{
				if (board.getStr(i, j).equals(board.getStr(i, j+1)))
					return true;			
				if (board.getStr(i, j).equals(board.getStr(i+1, j)))
					return true;
			}
		}
		for (int i = 0; i < Board.MODE-1; i++)
		{
			if (board.getStr(i, Board.MODE-1).equals(board.getStr(i+1, Board.MODE-1)))
				return true;				
		}
		for (int j = 0; j < Board.MODE-1; j++){
			if (board.getStr(Board.MODE-1, j).equals(board.getStr(Board.MODE-1, j+1)))
				return true;
		}
		
		System.out.println("FAIL");
		return false;
	}

	//Goal에 도달 했는지 확인 하는 메소드
	public static void goal(Board board)
	{
		for(int i=0 ; i<Board.MODE ; i++)
		{
			for(int j=0 ; j<Board.MODE ; j++)
			{
				if(board.getStr(i, j).equals(String.valueOf(Board.GOAL)))
				{
					
					
				}
			}
		}
	}	
}
