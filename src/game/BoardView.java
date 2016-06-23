package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BoardView extends JFrame {
	
	private Mode mMode;
	
	private JPanel[][] p; // JPanel
	private JLabel[][] label;
	private JLabel score;
	private JComboBox<String> combo;
	
	public Mode getMode() {
		return mMode;
	}
	public JPanel[][] getP() {
		return p;
	}
	public JLabel[][] getLabel() {
		return label;
	}
	public JComboBox<String> getCombo() {
		return combo;
	}
	
	
	public BoardView(){
		
		mMode = new Mode();		
		
		setTitle("2048Game"); 
		setBounds(600,0, 600 ,850);
		setLayout(null);
		
		boardInit(); // 보드 생성		
		descriptionInit(); // 게임 설명  
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// board initialize
	public void boardInit()
	{
		p = new JPanel[mMode.getSize()][mMode.getSize()];
		label = new JLabel[mMode.getSize()][mMode.getSize()];
		
		Font font = new Font("SansSerif", Font.BOLD, 30);
		
		for(int i=0; i<mMode.getSize(); i++)
		{
			for(int j=0; j<mMode.getSize() ; j++)
			{
				p[i][j] = new JPanel();
				p[i][j].setBounds(
						(int)(mMode.getGap()*(j+1) + j*(560/mMode.getSize())), 
						(int)(mMode.getGap()*(i+1) + i*(560/mMode.getSize())), 
						(560/mMode.getSize()),
						(560/mMode.getSize()));
				p[i][j].setLayout(new BorderLayout());
				p[i][j].setBorder(new LineBorder(Color.black,1,true));
				label[i][j] = new JLabel("",JLabel.CENTER);
				label[i][j].setFont(font);
				p[i][j].setBackground(new NumColor(0).getColor());
				p[i][j].add(label[i][j], BorderLayout.CENTER);
				add(p[i][j]);					
			}			
		}		
		firstSetting();
	}
	
	// 보드에 초기 숫자 세팅
	public void firstSetting()
	{
		int n = (int)(Math.random()*(mMode.getSize()*mMode.getSize()));
		int m = (int)(Math.random()*(mMode.getSize()*mMode.getSize()));
		while(n==m)
			m = (int)(Math.random()*(mMode.getSize()*mMode.getSize()));
		
		int[] arr = {2,2,2,4};
		int a = arr[(int)(Math.random()*arr.length)];
		int b = arr[(int)(Math.random()*arr.length)];
		
		label[n/mMode.getSize()][n%mMode.getSize()].setText(String.valueOf(a));
		label[m/mMode.getSize()][m%mMode.getSize()].setText(String.valueOf(b));
		p[n/mMode.getSize()][n%mMode.getSize()].setBackground(new NumColor(a).getColor());
		p[m/mMode.getSize()][m%mMode.getSize()].setBackground(new NumColor(b).getColor());
	}
	
	// 게임 설명 뷰 세팅
	public void descriptionInit(){
		// Label
		JLabel sizeLabel = new JLabel("SIZE",JLabel.CENTER); 
		sizeLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		sizeLabel.setBounds(0,600 , 280,40);
		add(sizeLabel);
				
		// ComboBox
		String[] SIZEList = {"3x3", "4x4", "5x5", "6x6", "7x7", "8x8"};
		combo = new JComboBox<String>(SIZEList);
		combo.setSelectedIndex(1);
		combo.setFont(new Font("SansSerif", Font.BOLD, 30));
		combo.setBounds(300, 600 , 280, 40);
		combo.setEditable(false);
		combo.addItemListener(mMode);
		combo.setFocusable(false);
		add(combo);
		
		JLabel scoreLabel = new JLabel("SCORE : ",JLabel.CENTER); 
		scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		scoreLabel.setBounds(0,650 , 280,40);
		add(scoreLabel);
		
		score = new JLabel("0" ,JLabel.CENTER); 
		score.setFont(new Font("SansSerif", Font.BOLD, 30));
		score.setBounds(300,650 , 280,40);
		add(score);
		
		// TextArea
		TextArea text = new TextArea("W : 모든 숫자 위로\n"
									+"A  : 모든 숫자 왼쪽으로\n" 
									+"S  : 모든 숫자 아래로\n" 
									+"D  : 모든 숫자 오른쪽으로\n");
		text.setEditable(false);
		text.setEnabled(false);
		text.setBounds(0,700 , 580,100);		
		add(text);
	}
	
	public void setScore(int score){
		this.score.setText(score + "");
	}
	
	// 보드판 삭제 메소드
	public void removeBoard(int mode)
	{
		this.setVisible(false);
		this.setVisible(true);
		
		for(int i =0 ; i<mode ; i++)
		{
			 for(int j = 0 ; j < mode ; j++)
			 {
				 remove(p[i][j]);
				 remove(label[i][j]);
			 }
		}		
	}
	
	public JPanel getPanel(int y, int x)
	{
		return p[y][x];
	}
	
	public String getStr(int y, int x)
	{
		return label[y][x].getText();
	}
	
	public void setStr(int y, int x, String str)
	{
		label[y][x].setText(str);
	}	

}
