package card;

import java.util.Random;

import javax.swing.ImageIcon;

public class GameReset {
	ImageIcon[] image;
	int [] arr;
	int gap;
	public GameReset(int gap) {
		// TODO Auto-generated constructor stub
		/*if(gap==16)
		{
		image=new ImageIcon[8];
		arr=new int[16];
		}
		else
		{
			image=new ImageIcon[16];
			arr=new int[32];
		}*/
		this.gap=gap;
		image=new ImageIcon[(gap/2)+1];
		arr=new int[gap];
	}
	public void imageFunction(int gap) { 
		image[0]=new ImageIcon("images/cardImg2.png");
		for(int i=1;i<(gap/2+1);i++)
		{
		image[i]=new ImageIcon("images/card"+i+".png");
		
		}
	}
	public void randNumber()
	{
		int check=0;
		Random rand=new Random();
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=rand.nextInt((gap/2))+1;
			for(int x=0;x<i;x++)
			{
				if(arr[i]==arr[x])
					check++;
			}
			if(check==2)
			{
				check=0;
				i--;
				continue;
			}
			
			check=0;
		}
	}
	public int GetArr(int i) {
		return arr[i];
	}
	public ImageIcon GetImage(int i) {
		return image[i];
	}
}
