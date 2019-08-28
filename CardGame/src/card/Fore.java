package card;
import java.awt.Color;
import java.awt.Container;
/*
 * 클래스명 : GUI
 * 역활 : GUI관리
 */
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

public class Fore extends JFrame {
	GameReset Game;
	JPanel p4,Mainpanel;
	JLabel player1,player2,player1_score,player2_score,alertText;
	int gap,Mode;
	//Container con;
	//카드섞기,이미지 파일 불러오기,GUI 시작 
	public Fore(Container con,JPanel panel,int Level,int mode) {
		getContentPane().setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub
		if(Level == 1)
		gap=16;
		else if(Level==2)
		gap=32;
		this.Mode=mode;
		Mainpanel=panel;
		Game=new GameReset(gap);
		Game.randNumber();
		Game.imageFunction(gap);
		Start(con,gap);
		//this.con=con;
		
	}
	public void Start(Container con,int gap) {
		// TODO Auto-generated constructor stub
		//setLayout(null);
		//setVisible(true);

		con.setLayout(null);
		
		p4 = new JPanel();
		p4.setLayout(null);
		p4.setBounds(0, 0, 649, 666);
		p4.setBackground(new Color(242,203,97));	
		p4.setVisible(true);
		con.add(p4);
		
		JPanel bp=new JPanel();
		bp.setBounds(170, 87, 500, 320);
		
		bp.setBackground(new Color(242,203,97));
		bp.setLayout(new GridLayout(0,gap/4,5,5));
		if(gap==16)
		{			
			bp.setSize(320, 500);
		}
		if(gap==32)
		{
			setSize(1000,1000);
			bp.setSize(480, 650);
		}
		cardButton[] btn=new cardButton[gap];
		
		ActionButtonHandler action=new ActionButtonHandler(btn,this,con);
		for(int i=0;i<gap;i++)
		{
			btn[i]=new cardButton(Integer.toString(i),Game.GetArr(i),Game.GetImage(Game.GetArr(i)),Game.GetImage(0));
			
			btn[i].addActionListener(action);
			bp.add(btn[i]);
		}
		
		bp.setVisible(true);
		p4.add(bp);
		
	if(Mode==1)
	{
		alertText = new JLabel("카드를 누르면 게임이 시작됩니다!");
		alertText.setFont(new Font("HY견고딕", Font.BOLD, 20));
		alertText.setForeground(Color.WHITE);
		alertText.setBounds(165, 40, 350, 36);
		p4.add(alertText);
	}
	if(Mode==2)
	{
		player1 = new JLabel("1P 차례");
		player1.setFont(new Font("HY견고딕", Font.BOLD, 25));
		player1.setForeground(new Color(255, 0, 255));
		player1.setBounds(280, 31, 111, 36);
		p4.add(player1);
		
		player2 = new JLabel("2P 차례");
		player2.setFont(new Font("HY견고딕", Font.BOLD, 25));
		player2.setForeground(new Color(0, 255, 255));
		player2.setBounds(280, 31, 111, 36);
		player2.setVisible(false);
		p4.add(player2);
		
		JLabel player1_scoreText = new JLabel("1P 점수");
		player1_scoreText.setFont(new Font("HY견고딕", Font.BOLD, 15));
		player1_scoreText.setForeground(new Color(255, 0, 255));
		player1_scoreText.setBounds(45, 31, 111, 36);
		p4.add(player1_scoreText);
		
		player1_score = new JLabel("0");
		player1_score.setFont(new Font("HY견고딕", Font.BOLD, 25));
		player1_score.setForeground(Color.WHITE);
		player1_score.setBounds(60, 60, 111, 36);
		p4.add(player1_score);
		
		JLabel player2_scoreText = new JLabel("2P 점수");
		player2_scoreText.setFont(new Font("HY견고딕", Font.BOLD, 15));
		player2_scoreText.setForeground(new Color(0, 255, 255));
		player2_scoreText.setBounds(550, 31, 111, 36);
		p4.add(player2_scoreText);
		
		player2_score = new JLabel("0");
		player2_score.setFont(new Font("HY견고딕", Font.BOLD, 25));
		player2_score.setForeground(Color.WHITE);
		player2_score.setBounds(565, 60, 111, 36);
		p4.add(player2_score);
	}
		
	}
	public int showPapUp() {
		int result;
		result=JOptionPane.showConfirmDialog(null,
				"계속하시겠습니까?","축하힙니다.",JOptionPane.YES_NO_OPTION);
		return result;
		// 여기에  새 화면을 띄움 , panel 과 container 를 이용
	}
	public GameReset ReturnGame() {
		return Game;
		// 게임리셋을 위해 Game 
	}
}
