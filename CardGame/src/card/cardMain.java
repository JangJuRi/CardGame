package card;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class cardMain {

	public static void main(String[] args) {
		MainForm mf = new MainForm();
		
		
		mf.display();
	}
}

class MainForm extends JFrame implements ActionListener
{
	Container con;
	ImageIcon image;
	JLabel imgLabel,selectLabel;
	JPanel panel_Start;
	JPanel panel = new JPanel();
	JLabel title,selectNotice;
	JButton p1_4Button,p1_6Button,p2_4Button,p2_6Button,p1selectButton,p2selectButton;
	
	MainForm()
	{
		con=getContentPane();
		con.setLayout(null);
		//con.setBackground(new Color(242,203,97));
		panel.setBounds(0, 0, 649, 666);
		panel.setLayout(null);
		panel.setBackground(new Color(242,203,97));
		con.add(panel);
		
		
		image = new ImageIcon("images/cardImg2_main.png");
		imgLabel = new JLabel(image);
		imgLabel.setBounds(100, 250, image.getIconWidth(), image.getIconHeight());
		
		title = new JLabel("∞∞¿∫ ±◊∏≤ √£±‚");
		title.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 50));
		title.setBounds(160, 60, 350, 70);
		title.setForeground(Color.WHITE);
		
		panel_Start = new JPanel();
		panel_Start.setBackground(new Color(240,185,79));
		panel_Start.setBounds(342, 250, 248, 253);
		con.add(panel_Start);
		panel_Start.setLayout(null);
		
		p1selectButton = new JButton("1P");
		p1selectButton.setBackground(Color.WHITE);
		p1selectButton.setBounds(27, 80, 80, 40);
		panel_Start.add(p1selectButton);
		
		p2selectButton = new JButton("2P");
		p2selectButton.setBackground(Color.BLACK);
		p2selectButton.setForeground(Color.WHITE);
		p2selectButton.setBounds(138, 80, 80, 40);
		panel_Start.add(p2selectButton);
				
		p1_4Button = new JButton("Ω√¿€");
		p1_4Button.setBackground(Color.WHITE);
		p1_4Button.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 26));
		p1_4Button.setBounds(27, 160, 192, 60);
		panel_Start.add(p1_4Button);
		
		p1_6Button = new JButton("6 X 6");
		p1_6Button.setBackground(Color.WHITE);
		p1_6Button.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 26));
		p1_6Button.setBounds(27, 230, 192, 60);
		//panel_Start.add(p1_6Button);
		
		p2_4Button = new JButton("Ω√¿€");
		p2_4Button.setBackground(Color.BLACK);
		p2_4Button.setForeground(Color.WHITE);
		p2_4Button.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 26));
		p2_4Button.setBounds(27, 160, 192, 60);
		panel_Start.add(p2_4Button);
		
		p2_6Button = new JButton("6 X 6");
		p2_6Button.setBackground(Color.BLACK);
		p2_6Button.setForeground(Color.WHITE);
		p2_6Button.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 26));
		p2_6Button.setBounds(27, 230, 192, 60);
		//panel_Start.add(p2_6Button);
		
		selectLabel = new JLabel("1P/2P º±≈√");
		selectLabel.setForeground(Color.WHITE);
		selectLabel.setBounds(53, 10, 143, 35);
		selectLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 25));
		panel_Start.add(selectLabel);
		
		
		panel.add(title);
		panel.add(panel_Start);
		panel.add(imgLabel);
//		panel.add(p1selectButton);
//		panel.add(p2selectButton);
		
		p1selectButton.addActionListener(this);
		p2selectButton.addActionListener(this);
		p2_4Button.addActionListener(this);
		p2_6Button.addActionListener(this);
		
		p1_4Button.addActionListener(this);
		p1_6Button.addActionListener(this);
	}
	
	void display()
	{
		setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 649)/ 2, (screenSize.height - 666) / 2); 

		setSize(649,666);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ƒ´µÂ ∞‘¿”");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int level=0;
		int Mode=0;
		if(e.getSource()==p1_4Button)
		{
			panel.setVisible(false);
			panel.setEnabled(false);
			level = 1;
			Mode=1;
			Fore fore = new Fore(con,panel,level,Mode);
		}
		if(e.getSource()==p1_6Button)
		{
			panel.setVisible(false);
			panel.setEnabled(false);
			level = 2;
			Mode=1;
			Fore fore = new Fore(con,panel,level,Mode);
		}
		if(e.getSource()==p2_4Button)
		{
			panel.setVisible(false);
			panel.setEnabled(false);
			level = 1;
			Mode=2;
			Fore fore = new Fore(con,panel,level,Mode);
		}
		if(e.getSource()==p2_6Button)
		{
			panel.setVisible(false);
			panel.setEnabled(false);
			level=2;
			Mode=2;
			Fore fore = new Fore(con,panel,level,Mode);
		}
		
		if(e.getSource()==p1selectButton)
		{
			p1_4Button.setVisible(true);
			p1_4Button.setEnabled(true);
			p1_6Button.setVisible(true);
			p1_6Button.setEnabled(true);
			
			p2_4Button.setVisible(false);
			p2_4Button.setEnabled(false);
			p2_6Button.setVisible(false);
			p2_6Button.setEnabled(false);
		}
		
		if(e.getSource()==p2selectButton)
		{
			p2_4Button.setVisible(true);
			p2_4Button.setEnabled(true);
			p2_6Button.setVisible(true);
			p2_6Button.setEnabled(true);
			
			p1_4Button.setVisible(false);
			p1_4Button.setEnabled(false);
			p1_6Button.setVisible(false);
			p1_6Button.setEnabled(false);
		}
		
	}
}