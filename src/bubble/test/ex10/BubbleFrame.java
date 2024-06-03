package bubble.test.ex10;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	// 컨텍스트를 생성하는 방법 (셀프참조 , 내 데이터 타입을 참조한다.)
//	BubbleFrame bubbleFrame = this;
	BubbleFrame mContext = this;

	private JLabel backgroundMap;
	private Player player; // 포함관계
	private Enemy enemy1;

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
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root Panel
		setContentPane(backgroundMap); // add처리
		setSize(1000, 640);

//		mContext --> 참조 타입() --> 주소값 크기는 몇 바이트일까? 
//		주소값 크기는 기본 4byte이다.
		player = new Player(mContext);
		enemy1 = new Enemy(mContext);
	}

	private void setInitLayout() {
		setLayout(null); // 좌표 값으로 배치
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // JFrame을 모니터 가운데 자동 배치(JFrame에 있는 메소드이다.)
		setVisible(true);

		add(player);
		add(enemy1);
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
					// add(new Bubble(player)); // 다른 곳에 안 쓸거라면 익명클래스 써도 된다.
					// 프레임에 컴포넌트를 add 동작은 누구? JFrame --> add() 메서드이다.
					// 버블 실행시에 끊김 현상이 발생하는 이유는 왜 일까?
					player.attack();
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

	// getter
	public Player getPlayer() {
		return player;
	}

	public Enemy getEnemy() {
		return enemy1;
	}
	
	/**
	 * Methods
	 */

	// 코드 테스트
	public static void main(String[] args) {
		// main 함수를 가지고 있는 클래스는 하위에 생성된 모든 객체의
		// 주소값을 알고 있다!!!!!!!!!!!!!!!!!!!!!!!!!
		// 이런걸 context라고 부른다!!!!!!!!!!!!!!!!!!
		new BubbleFrame();
	} // end of main

} // end of class