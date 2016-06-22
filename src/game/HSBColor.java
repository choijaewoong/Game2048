package game;

import java.awt.Color;

public class HSBColor {

	HSBColorData color;
	int num;
	
	public HSBColor(int num)
	{
		this.num = num;
		
		setColor(num);
		/*color[0]= HSBColorData.N0;
		color[1]= HSBColorData.N1;
		color[2]= HSBColorData.N2;
		color[3]= HSBColorData.N3;
		color[4]= HSBColorData.N4;
		color[5]= HSBColorData.N5;
		color[6]= HSBColorData.N6;
		color[7]= HSBColorData.N7;
		color[8]= HSBColorData.N8;
		color[9]= HSBColorData.N9;
		color[10]= HSBColorData.N10;
		color[11]= HSBColorData.N11;
		color[12]= HSBColorData.N12;
		color[13]= HSBColorData.N13;
		color[14]= HSBColorData.N14;*/
	}
	public void setColor(int num)
	{
		switch(num)
		{
		case 0: 
			color = HSBColorData.N0;
			break;
		case 2: 
			color = HSBColorData.N1;
			break;
		case 4: 
			color = HSBColorData.N2;
			break;
		case 8: 
			color = HSBColorData.N3;
			break;
		case 16: 
			color = HSBColorData.N4;
			break;
		case 32: 
			color = HSBColorData.N5;
			break;
		case 64: 
			color = HSBColorData.N6;
			break;
		case 128: 
			color = HSBColorData.N7;
			break;
		case 256: 
			color = HSBColorData.N8;
			break;
		case 512: 
			color = HSBColorData.N9;
			break;
		case 1024: 
			color = HSBColorData.N10;
			break;
		case 2048: 
			color = HSBColorData.N11;
			break;
		case 4096: 
			color = HSBColorData.N12;
			break;
		case 8192: 
			color = HSBColorData.N13;
			break;
		case 16384: 
			color = HSBColorData.N14;
			break;			
		default:
			color = HSBColorData.N15;
			break;
		}		
	}
	
	public int getNum()
	{
		return num;
	}
	
	public void setNum(int num)
	{
		this.num = num;
	}
	
	public Color getColor()
	{
		return color.getColor();
	}
	
	public enum HSBColorData {

		N0(Color.getHSBColor((float)46/360,(float)21/100,(float)93/100)),
		N1(Color.getHSBColor((float)18/360,(float)34/100,(float)95/100)), // 2
		N2(Color.getHSBColor((float)106/360,(float)12/100,(float)79/100)), // 4
		N3(Color.getHSBColor((float)18/360,(float)18/100,(float)77/100)), // 8
		N4(Color.getHSBColor((float)9/360,(float)53/100,(float)95/100)), // 16
		N5(Color.getHSBColor((float)44/360,(float)26/100,(float)73/100)), // 32
		N6(Color.getHSBColor((float)56/360,(float)51/100,(float)93/100)), //64
		N7(Color.getHSBColor((float)149/360,(float)36/100,(float)74/100)), // 128
		N8(Color.getHSBColor((float)14/360,(float)72/100,(float)92/100)), // 256
		N9(Color.getHSBColor((float)355/360,(float)75/100,(float)80/100)), // 512
		N10(Color.getHSBColor((float)185/360,(float)100/100,(float)69/100)), // 1024
		N11(Color.getHSBColor((float)175/360,(float)48/100,(float)47/100)), // 2048
		N12(Color.getHSBColor((float)18/360,(float)43/100,(float)42/100)), // 4096
		N13(Color.getHSBColor((float)22/360,(float)60/100,(float)84/100)), // 8192
		N14(Color.getHSBColor(332,1,(float)57/100)),
		N15(Color.getHSBColor(336,1,(float)50/100));
		
		Color color;
		
		private HSBColorData(Color color)
		{
			this.color = color;
		}
		
		public Color getColor()
		{
			return color;
		}
	}
}
