package bubble.test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.xml.stream.util.EventReaderDelegate;

public class Player extends JLabel implements Moveable {

	// field - 내 위치 설정, 화면에 보여질 이미지
	private int x;
	private int y;
	private ImageIcon playerR, playerL; // 데이터 타입을 쉼표로 축약할 수 있으나 잘 사용하지 않는다.

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// setter
	public void setLeft(boolean left) {
		this.left = left;
	};

	public void setRight(boolean right) {
		this.right = right;
	}

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 1;

	// Constructor
	public Player() {
		initData();
		setInitLayout();
	}

	/**
	 * Methods
	 */
	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 실행시 초기 값 세팅
		x = 55;
		y = 535;

		// 플레이어가 가만히 멈춘 상태
		left = false;
		right = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;
	}

	private void setInitLayout() {
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	/**
	 * end of Methods
	 */

	/**
	 * implements Moveable Override
	 */
	@Override
	public void left() {
		left = true;
		setIcon(playerL);

		// <-<-<- 계속 왼쪽으로 가는 행동을 반복하고 싶다.
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void right() {
		right = true;
		setIcon(playerR);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	} // end of right()

	@Override
	public void up() {
		up = true;

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 130; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);

					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // end of for()

				up = false;
				down();

			} // end of run()
		}).start();

	}

	@Override
	public void down() {
		down = true;

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y + JUMPSPEED;
					setLocation(x, y);

					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		down = false;
	}

	/**
	 * end of implements Moveable Override
	 */

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

} // end of class
