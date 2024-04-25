package ch01;

// ctrl + shift + o --> 안 쓰는 import 제거
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 ---> ctrl + shift + s, f, o
public class BorderLayoutEx1 extends JFrame {

	final int WIDTH = 600;
	final int HEIGHT = 600;
	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.CENTER };

	// 생성자
	public BorderLayoutEx1() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[directions.length];
	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout은 컴포넌트들을 동서남북 가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		// 반복문을 활용해서 코드를 완성하세요.
		for (int i = 0; i < buttons.length; i++) {
			super.add(new JButton(directions[i]), directions[i]);
		}
	}

	public static void main(String[] args) {
		new BorderLayoutEx1();
	}// end of main

}
