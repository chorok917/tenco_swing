package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame1 extends JFrame {

	// field
	private JLabel jPlayer;
	private JLabel backgroundMap;
	private int jPlayerX = 100; // 변수는 변하는 수이기도 하다.
	private int jPlayerY = 580;
	private final int MOVED_DISTANCE = 60;
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 680;
	private final String PLAYER_NAEM = "공룡";
	private final int PLAYER_WIDTH = 50;
	private final int PLAYER_HEIGHT = 50;

	// Constructor
	public MiniGame1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// methods
	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Icon charR = new ImageIcon("images/playerR.png");
		Icon charL = new ImageIcon("images/playerL.png");
		jPlayer = new JLabel(charR);
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);

		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		backgroundMap.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		backgroundMap.setLocation(0, 0);
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(null); // 좌표기반으로 배치관리자 변경 setSize, setLocation값 필수!!
		add(jPlayer);
		add(backgroundMap);
		jPlayer.setLocation(jPlayerX, jPlayerY);
	}

	private void addEventListener() {
		// jPlayer(JLabel)객체한테만 keyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyListener 인터페이스를 재정의할 수 있다.
//		jPlayer.addKeyListener(this);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jPlayerY -= MOVED_DISTANCE * 2;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVED_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVED_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVED_DISTANCE * 2;
				}
				jPlayer.setLocation(jPlayerX, jPlayerY);
			} // end of keyPressed
		});

	} // end of addEventListener

	// end of methods

	// code test
	public static void main(String[] args) {
		new MiniGame1();
	} // end of main

} // end of class
