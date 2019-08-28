package card;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonHandler implements ActionListener, Runnable {
	int i;
	cardButton[] btn;
	int[] arr;
	int check;
	int[] iArr;
	int score = 0;
	Fore main;
	int turn = 1;
	int ScoreP1 = 0;
	int ScoreP2 = 0;
	int WinnerScore;
	int Mode;
	cardButton block;
	Container conn = new Container();
	String timeBuffer;
	int oldTime;
	boolean TimeCheck = false;
	boolean chk = true;
	int a =0;
	public ActionButtonHandler(cardButton[] button, Fore main, Container con) {
		// TODO Auto-generated constructor stub
		btn = button;
		arr = new int[2];
		check = 0;
		iArr = new int[2];
		this.main = main;
		// Random random = new Random();
		// turn=random.nextInt(2);
		conn = con;
		this.Mode = main.Mode;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ������ 1�� ���� - ���������� ���� �ְ� ��ư�� �̹����� ����
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				i = Integer.parseInt(e.getActionCommand());
				iArr[check] = i;
				arr[check] = btn[i].clickButton();

			}
		});

		// ������ 2�� ���� - ���������� ���� ������ ó��
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
			if(Mode==1) {
				main.alertText.setFont(new Font("HY�߰��", Font.BOLD, 25));
				main.alertText.setForeground(Color.GRAY);
				//main.alertText.setVisible(false);
			}
				if (check == 1) {
					if (arr[0] != arr[1]) { // ��������
						if (Mode == 2) {
							if (turn == 1) // ��
							{
								turn = 0;
								main.player2.setVisible(true);
								main.player1.setVisible(false);
							} else {
								turn = 1;
								main.player2.setVisible(false);
								main.player1.setVisible(true);
							}
						}


						try {
							Thread t3 = new Thread();
							t3.sleep(400);
							btn[iArr[0]].returnImage();
							btn[iArr[1]].returnImage();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else { // ����

						//System.out.println("����");
						if (btn[iArr[0]].getIcon() == btn[iArr[0]].getIcon()) { // ���ھ�

							if (Mode == 2) {
								if (turn == 1) {
									ScoreP1++;
									main.player1_score.setText("" + ScoreP1);
								} else {
									ScoreP2++;
									main.player2_score.setText("" + ScoreP2);
								}
							}
						}
						score++;
						if (score == (main.gap / 2)) {
							if (Mode == 1) {
								// TimeCheck=false;
								// Timer(TimeCheck);

								ResultForm rf = new ResultForm(conn, main.Mainpanel, WinnerScore, a, Mode);
								rf.display();
								main.p4.setVisible(false);
								main.p4.setEnabled(false);
							}
							if (Mode == 2) {
								WinnerScore = (ScoreP1 > ScoreP2 ? ScoreP1 : ScoreP2);

								ResultForm rf = new ResultForm(conn, main.Mainpanel, WinnerScore, a, Mode);

								rf.display();
								main.p4.setVisible(false);
								main.p4.setEnabled(false);

								/*
								 * int result=main.showPapUp(); if(result==JOptionPane.YES_OPTION) { score=0;
								 * check=0; main.ReturnGame().randNumber(); for(int i=0;i<main.gap;i++) // ����
								 * ������ ���� Ŭ������ ��ü�� �Ű������� ���� ���� / ������ġ�� �̹�����ġ {
								 * btn[i].ChangeImage(main.ReturnGame().GetImage(main.ReturnGame().GetArr(i))
								 * ,main.ReturnGame().GetArr(i)); btn[i].returnImage(); } ScoreP1=0; ScoreP2=0;
								 * main.player1_score.setText(""+ScoreP1);
								 * main.player2_score.setText(""+ScoreP2); } else System.exit(0);
								 */
							}
						}
					}

					check = 0;
					return;

				}
				check++;
			}
		});
		
		if(chk && Mode==1) {
			
			new Thread(new Runnable() {
				//int a =0;

				@Override
				public void run() {
					int min, sec;
					chk = false;
					while(true) {
						sec = a % 60;
						min = a / 60 % 60;
						// hour = secs / 3600;
						timeBuffer = String.format("%02d:%02d", min, sec);
						try {
							
							main.alertText.setText(timeBuffer);
							Thread.sleep(1000);
							a++;
							
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					}
					
					
				}
			}).start();
			
		}
			



		try {
			// 1�� ������ ����
			t1.start();
			// 1�� ������ ����ñ��� ���
			// t1.join();
			// 2�� ������ ����
			t2.start();
			//time.start();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	@Override
	public void run() {

	}
}
