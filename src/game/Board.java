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

public class Board extends JFrame
{
	public static int MODE = 3;
	public static float GAP = (float)20/MODE;
	public final static int GOAL = 256;
	
	int best = 0;
	int score = 0;
	
	public JPanel[][] p; // JPanel
	private JLabel[][] label;
	public JComboBox<String> combo;
	
	public Board()
	{
		setTitle("2048Game"); 
		setBounds(600,0, 600 ,850);
		setLayout(null);
				
		init();
		
		// Label
		JLabel lab = new JLabel("Mode",JLabel.CENTER); 
		lab.setFont(new Font("SansSerif", Font.BOLD, 30));
		lab.setBounds(0,600 , 280,40);
		add(lab);
				
		// ComboBox
		String[] list = {"3x3", "4x4", "5x5", "6x6", "7x7", "8x8"};
		combo = new JComboBox<String>(list);
		combo.setFont(new Font("SansSerif", Font.BOLD, 30));
		combo.setBounds(300, 600 , 280, 40);
		combo.setEditable(false);
		combo.addItemListener(new ModeChanged());
		combo.setFocusable(false);
		add(combo);
		
		// TextArea
		TextArea text = new TextArea("BEST : " + best 
									+"\nSCORE : " + score
									+"\n\nW : 모든 숫자 위로\n"
									+"A  : 모든 숫자 왼쪽으로\n" 
									+"S  : 모든 숫자 아래로\n" 
									+"D  : 모든 숫자 오른쪽으로\n");
		text.setEditable(false);
		text.setEnabled(false);
		text.setBounds(0,650 , 580,150);
		add(text);
		
		// Game 시작을 위한 첫  세팅
		first();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}	
	
	public void rem(int mode)
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
	
	public void init()
	{
		p = new JPanel[MODE][MODE];
		label = new JLabel[MODE][MODE];
		
		Font font = new Font("SansSerif", Font.BOLD, 30);
		
		for(int i=0; i<MODE; i++)
		{
			for(int j=0; j<MODE ; j++)
			{
				p[i][j] = new JPanel();
				p[i][j].setBounds((int)(GAP*(j+1) + j*(560/MODE)), (int)(GAP*(i+1) + i*(560/MODE)), (560/MODE),(560/MODE));
				p[i][j].setLayout(new BorderLayout());
				p[i][j].setBorder(new LineBorder(Color.black,1,true));
				label[i][j] = new JLabel("",JLabel.CENTER);
				label[i][j].setFont(font);
				p[i][j].setBackground(new HSBColor(0).getColor());
				p[i][j].add(label[i][j], BorderLayout.CENTER);
				add(p[i][j]);					
			}			
		}
	}
	
	public void first()
	{
		int n = (int)(Math.random()*(MODE*MODE));
		int m = (int)(Math.random()*(MODE*MODE));
		while(n==m)
			m = (int)(Math.random()*(MODE*MODE));
		
		int[] arr = {2,2,2,4};
		int a = arr[(int)(Math.random()*arr.length)];
		int b = arr[(int)(Math.random()*arr.length)];
		
		label[n/MODE][n%MODE].setText(String.valueOf(a));
		label[m/MODE][m%MODE].setText(String.valueOf(b));
		p[n/MODE][n%MODE].setBackground(new HSBColor(a).getColor());
		p[m/MODE][m%MODE].setBackground(new HSBColor(b).getColor());
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
