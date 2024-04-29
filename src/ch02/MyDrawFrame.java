package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 패널에 그림을 그리는 방법 자바 문법 - 중첩 클래스(클래스 안에 클래스를 만드는 것을 말한다.) 외부 클래스 또는 내부 클래스라고 부를
 * 수 있다. 같은 말로 outer class, inner class
 */
public class MyDrawFrame extends JFrame {

	// 내부 클래스를 외부 클래스에 사용하려면
	// 멤버로 가지고 있어야 한다.
	MyDrawPanel myDrawPanel;

	public MyDrawFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("내부 클래스를 활용한 그림 그리는 연습");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myDrawPanel = new MyDrawPanel();
	}

	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);
	}

	// 내부 클래스 만들어 보기
	// paint --> 좌표값으로 x = 0, y = 0
	// JPanel에 있는 기능을 확장해보자.
	class MyDrawPanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(100, 100, 50, 100);
			g.drawRect(200, 200, 150, 150);
			g.drawLine(250, 300, 300, 300);
			g.drawOval(100, 150, 300, 300);
			g.drawString("반가워", 400, 400);
			g.drawString("⭐⭐⭐⭐⭐", 500, 500);
		}

	}// end of inner class

}
