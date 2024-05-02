package bubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	// field - 내 위치 설정, 화면에 보여질 이미지
	private int x;
	private int y;
	private ImageIcon playerR, playerL; // 데이터 타입을 쉼표로 축약할 수 있으나 잘 사용하지 않는다.

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
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	/**
	 * end of Methods
	 */

	/**
	 * implements Moveable Override
	 */
	@Override
	public void left() {
		// 왼쪽 방향키 이벤트 발생 시 이미지를 왼쪽으로 보는 이미지로 세팅해야 한다.
		x = x - 10;
		setLocation(x, y);
		setIcon(playerL);
	}

	@Override
	public void right() {
		x = x + 10;
		setLocation(x, y);
		setIcon(playerR);
	}

	@Override
	public void up() {
		y = y - 120;
		setLocation(x, y);
	}

	@Override
	public void down() {

	}

	/**
	 * end of implements Moveable Override
	 */

} // end of class
