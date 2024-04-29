package ch02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 내부 클래스를 활용해서 코드를 완성해주세요.
public class PaintFrame extends JFrame {

	// 멤버 - 내부 클래스 선언만.
	Paint paint;

	// 생성자 - 메서드 포함
	public PaintFrame() {
		initData();
		setInitLayout();
	}

	// initData method
	public void initData() {
		setTitle("언덕 위에 집");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 내부 클래스 객체 생성
		paint = new Paint();
	}

	// setInitLayout
	public void setInitLayout() {
		add(paint);
		setVisible(true);
	}

	// inner class 내부 클래스
	class Paint extends JPanel {

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(550, 550, 50, 50);
			g.drawRect(565, 560, 20, 20);
			g.drawLine(565, 570, 584, 570);
			g.drawLine(575, 560, 575, 580);
			int x[] = {540,575,610};
			int y[] = {550,530,550};
			g.drawPolygon(x, y, 3);
			g.drawRect(590, 520, 10, 20);
			g.drawOval(590, 500, 10, 10);
			g.drawOval(600, 480, 10, 10);
			g.drawOval(590, 460, 10, 10);
			g.drawOval(230, 600, 700, 450);
			g.drawString("⭐", 60, 200);
			g.drawString("⭐", 160, 120);
			g.drawString("⭐", 200, 100);
			g.drawString("⭐", 230, 118);
			
		}

	}
}
