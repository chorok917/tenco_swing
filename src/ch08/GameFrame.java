package ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	// field
	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel imagePanel;

	int playerX = 150;
	int playerY = 300;

	int enemyX = 250;
	int enemyY = 420;

	// Constructor
	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	/**
	 * 내부 클래스 시작
	 */

	// 클래스 안에 클래스 --> 중첩 클래스 -> 외부 클래스, 내부 클래스
	private class ImagePanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			g.drawImage(player1, playerX, playerY, 50, 50, null);
			g.drawImage(enemy1, enemyX, enemyY, 50, 50, null);

			// Todo 플레이어, 적군 그림 그려야 함
			// 쓰레드를 활용할 예정
		}

		@Override
		public void run() {
			// true : 왼쪽으로 가는 상황
			// false : 오른쪽으로 가는 상황
			boolean direction = true;

			while (true) {
				System.out.println("진행중");

				if (direction) {
					enemyX -= 10;
				} else {
					enemyX += 10;
				}

				// 방향 바꾸는 개념은 적군 x좌표값이
				if (enemyX <= 50) {
					// false --> 오른쪽으로
					direction = false;
				}

				if (enemyX >= 500) {
					// true --> 왼쪽으로
					direction = true;
				}

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		} // end of run()

	}

	/**
	 * 내부 클래스 끝
	 */

	// methods
	private void initData() {
		setTitle("Thread를 활용한 미니 예제");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			// 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerL.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		imagePanel = new ImagePanel();
		// 다른 작업자에게 일을 위임한다.
		Thread thread = new Thread(imagePanel);
		thread.start();

	} // initData()

	private void setInitLayout() {
		// 배치 관리자를 좌표 기반
		// setLayout(null);
		// setResizable(false); // 프레임 크기 조절 불가
		setVisible(true);
		add(imagePanel);
	}

	private void addEventListener() {
		// 이벤트 리스너 등록 방법 2가지 중 첫 번째
		// KeyListener 는 인터페이스이다.
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("여기가 동작합니다.");
				int code = e.getKeyCode();
				// 제어문
				if (code == KeyEvent.VK_LEFT) {
					playerX -= 10;
				} else if (code == KeyEvent.VK_UP) {
					playerY -= 10;
				} else if (code == KeyEvent.VK_RIGHT) {
					playerX += 10;
				} else if (code == KeyEvent.VK_DOWN) {
					playerY += 10;
				} else if (code == KeyEvent.VK_SPACE) {
					// 문제 1.스페이스를 눌렀을 때 적군을 멈출 수 있도록 코드 수정
					imagePanel.run();
				}

				// 문제 2. player가 적군과 만났다면 player 그림을 없애주세요.
				repaint();
			} // end of keyPressed
		});
	} // end of addEventListener()

} // end of class
