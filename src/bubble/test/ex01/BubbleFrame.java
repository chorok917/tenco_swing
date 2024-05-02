package bubble.test.ex01;

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
	}

	/**
	 * Methods
	 */
	private void initData() {
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
					// 구현
					player.left();
					break;
				case KeyEvent.VK_RIGHT:
					// 구현
					player.right();
					break;
				case KeyEvent.VK_UP:
					// 구현
					player.up();
					break;
				}

			} // end of keyPressed(KeyEvent e)

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