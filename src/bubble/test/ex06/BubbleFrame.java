package bubble.test.ex06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player; // 포함관계

	// Constructor
	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
		// Player 백그라운드 서비스 시작
		new Thread(new BackgroundPlayerService(player)).start();
	}

	/**
	 * Methods
	 */
	private void initData() {
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root Panel
		setContentPane(backgroundMap); // add처리
		setSize(1000, 640);

		player = new Player();
	}

	private void setInitLayout() {
		setLayout(null); // 좌표 값으로 배치
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // JFrame을 모니터 가운데 자동 배치(JFrame에 있는 메소드이다.)
		setVisible(true);

		add(player);
	}

	private void addEventListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 방향키 누르고 있다면
					// key 이벤트가 계속 <- <- <-
					// 왼쪽 상태가 아니라면
					// 왼쪽 벽에 충돌한게 아니라면
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;

				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;

				case KeyEvent.VK_UP:
					player.up();
					break;

				case KeyEvent.VK_SPACE:
					add(new Bubble(player)); // 다른 곳에 안 쓸거라면 익명클래스 써도 된다.
					break;

				default:
					break;
				}

			} // end of keyPressed(KeyEvent e)

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가는 상태 멈춤
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가는 상태 멈춤
					player.setRight(false);
					break;

				default:
					break;
				}

			} // end of keyReleased(KeyEvent e)

		});

	} // end of addEventListener()

	/**
	 * Methods
	 */

	// 코드 테스트
	public static void main(String[] args) {
		new BubbleFrame();
	} // end of main

} // end of class