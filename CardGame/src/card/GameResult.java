package card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*public class GameResult {

	public static void main(String[] args) {
		ResultForm rf = new ResultForm();
		rf.display();
	}
}*/

class ResultForm extends JFrame implements ActionListener {
	// Container con;
	JPanel panel = new JPanel();
	JPanel MainPanel = new JPanel();
	JPanel rankPanel;
	JLabel title, p1score, p2score, p3score, p4score, p5score, winner, resultscore,resultscore2, resultText;
	ImageIcon[] resultimage;
	JButton[] resultButton;
	JButton rankButton, homeButton;
	JTextField winnerText;
	int Score;
	int Mode;
	String TimeBuffer = "";
	String card = "";
	
	public ResultForm(Container con, JPanel mainpanel, int score, int sec, int mode) {
		TimeBuffer = String.format("%02d:%02d", sec / 60 % 60, sec % 60);
		Score = score;
		Mode = mode;
		MainPanel = mainpanel;
		// con=getContentPane();
		con.setLayout(null);
		panel.setBounds(0, 0, 649, 666);
		panel.setLayout(null);
		panel.setBackground(new Color(242, 203, 97));
		con.add(panel);

		title = new JLabel("점수 랭킹");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		title.setBounds(250, 30, 195, 51);
		title.setForeground(Color.WHITE);

		p1score = new JLabel("1위 : ");
		p1score.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		p1score.setBounds(100, 100, 195, 51);
		p1score.setForeground(Color.WHITE);

		p2score = new JLabel("2위 : ");
		p2score.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		p2score.setBounds(100, 140, 195, 51);
		p2score.setForeground(Color.WHITE);

		p3score = new JLabel("3위 : ");
		p3score.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		p3score.setBounds(100, 180, 195, 51);
		p3score.setForeground(Color.WHITE);

		p4score = new JLabel("4위 : ");
		p4score.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		p4score.setBounds(100, 220, 195, 51);
		p4score.setForeground(Color.WHITE);

		p5score = new JLabel("5위 : ");
		p5score.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		p5score.setBounds(100, 260, 195, 51);
		p5score.setForeground(Color.WHITE);

		winner = new JLabel("이름 입력");
		winner.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		winner.setBounds(390, 100, 195, 51);
		winner.setForeground(Color.WHITE);

		winnerText = new JTextField();
		winnerText.setBounds(350, 160, 195, 51);
		winnerText.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		winnerText.setFocusable(true);
		winnerText.setHorizontalAlignment(JTextField.RIGHT);

		JPanel bp = new JPanel();
		bp.setBounds(80, 300, 500, 320);
		bp.setBackground(new Color(242, 203, 97));
		bp.setLayout(new GridLayout(3, 6, 5, 5));
		bp.setVisible(true);

		resultimage = new ImageIcon[18];
		resultButton = new JButton[18];
		for (int i = 0; i < 18; i++) {
			resultimage[i] = new ImageIcon("images/card" + (i + 1) + ".png");
			resultButton[i] = new JButton(resultimage[i]);
			bp.add(resultButton[i]);
		}

		rankPanel = new JPanel();
		rankPanel.setLayout(new GridLayout(0, 1));
		rankPanel.setBounds(100, 100, 195, 51);
		rankPanel.setSize(200, 180);
		rankPanel.setBackground(new Color(240, 185, 79));
		rankPanel.add(p1score);
		rankPanel.add(p2score);
		rankPanel.add(p3score);
		rankPanel.add(p4score);
		rankPanel.add(p5score);

		rankButton = new JButton("랭킹 등록");
		rankButton.setBounds(350, 230, 90, 50);
		rankButton.setBackground(Color.WHITE);

		homeButton = new JButton("메인으로");
		homeButton.setBounds(455, 230, 90, 50);
		homeButton.setBackground(Color.WHITE);

		resultText = new JLabel("기록");
		resultText.setBounds(560, 20, 90, 50);
		resultText.setForeground(Color.CYAN);
		resultText.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		resultscore = new JLabel();
		resultscore.setBounds(540, 75, 200, 50);
		resultscore.setForeground(Color.CYAN);
		resultscore.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		resultscore2 = new JLabel();
		resultscore2.setBounds(575, 75, 200, 50);
		resultscore2.setForeground(Color.CYAN);
		resultscore2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		if (Mode == 1) {
			resultscore.setText(TimeBuffer);
			resultscore.setVisible(true);
			resultscore2.setVisible(false);
			
		}
		if (Mode == 2) {
			resultscore2.setText("" + Score);
			resultscore2.setVisible(true);
			resultscore.setVisible(false);
		}
		panel.add(title);
		panel.add(winner);
		panel.add(bp);
		panel.add(rankPanel);
		panel.add(winnerText);
		panel.add(rankButton);
		panel.add(homeButton);
		panel.add(resultscore);
		panel.add(resultscore2);
		panel.add(resultText);

		homeButton.addActionListener(this);
		rankButton.addActionListener(this);
		winnerText.addActionListener(this);
		Select("select");
	}

	void display() {
		setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 649) / 2, (screenSize.height - 666) / 2);

		// setSize(649,666);
		setResizable(false);
		// setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("게임 결과");
	}
	boolean RankCheck=false;
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==winnerText && !RankCheck)
		{
			Select("Insert");
			rankButton.setVisible(false);
			rankButton.setEnabled(false);
			RankCheck=true;
		}
		
		if (e.getSource() == homeButton) {
			panel.setVisible(false);
			panel.setEnabled(false);
			MainPanel.setVisible(true);
			MainPanel.setEnabled(true);
			rankButton.setVisible(true);
			rankButton.setEnabled(true);
			resultscore.setVisible(true);
			resultscore2.setVisible(true);
			RankCheck=false;
		}
		if (e.getSource() == rankButton) {
			Select("Insert");
			rankButton.setVisible(false);
			rankButton.setEnabled(false);
			RankCheck=true;
			
		}

	}

	public void Select(String sql) {
		Connection con = null;
		if (sql.equals("select")) {
			if (Mode == 1)
				card = "select * from single order by timer asc , name asc";
			else
				card = "select * from multi order by score desc , name asc";
		} else if (sql.equals("Insert")) {
			if (Mode == 1) {
				card = "INSERT INTO single VALUE('" + TimeBuffer + "' , '" + winnerText.getText() + "')";
			} else
				card = "INSERT INTO multi VALUE(" + Score + " , '" + winnerText.getText() + "')";
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버연결
			String url = "jdbc:mysql://localhost:3306/card?serverTimezone=Asia/Seoul"; // DB연결
			con = DriverManager.getConnection(url, "root", "1234");
			// statement 문장수행
			Statement stmt = con.createStatement();
			System.out.println(card);
			if (sql.equals("Insert")) { // Insert 일때 쿼리실행
				stmt.executeUpdate(card);
				Select("select");
			} else if (sql.equals("select")) { // select 일때 ResultSet에 쿼리결과값 대입
				ResultSet rs = stmt.executeQuery(card);

				int i = 0;
				String id[] = new String[5];
				String[] name = new String[5];
				while (rs.next()) { // 다음레코드로 이동
					if(Mode==1)
					id[i] = rs.getString("timer");// 필드값을 가져온다
					else if(Mode==2)
					id[i] = rs.getString("score");
					
					name[i] = rs.getString("name");// 필드값을 가져온다
					i++;
				}
				p1score.setText("1위 " + id[0] + " " + name[0]);
				p2score.setText("2위 " + id[1] + " " + name[1]);
				p3score.setText("3위 " + id[2] + " " + name[2]);
				p4score.setText("4위 " + id[3] + " " + name[3]);
				p5score.setText("5위 " + id[4] + " " + name[4]);
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("연결에 실패하였습니다.");
		}
	}
}
