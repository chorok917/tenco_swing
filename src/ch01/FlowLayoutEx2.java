package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing에서 제공하는 배치 관리자 중 FlowLayout
// 컴포넌트들을 (버튼,라벨) 등을 수평, 수직으로 배치를 해주는 클래스이다.
public class FlowLayoutEx2 extends JFrame {

	// 배열 활용해서 코드 리팩토링하기
	private JButton[] button = new JButton[6];

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능하다.
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화하는 기능(=값을 넣다)
	public void initData() {

		// 배열은 --> 반복문과 함께 쓰인다.
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton("button" + (i + 1));
			super.add(button[i]);
		}
	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치 관리자가 기본으로 활용된다.
//		FlowLayout flowLayout = new FlowLayout();
//		super.setLayout(flowLayout); // 배치관리자 --> FlowLayout
//		super.setLayout(new FlowLayout()); // 배치관리자 --> FlowLayout

		// 배치관리자 생성 및 JFrame 셋팅
//		super.setLayout(new FlowLayout(1, 2, 20));
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50));

		// 컴포넌트들을 붙이다.
		// 배열은 --> 반복문과 함께 쓰인다.
//		for (int i = 1; i < button.length; i++) {
//			super.add(button[i]);
//		}

	}

	// 코드 테스트
	public static void main(String[] args) {
		new FlowLayoutEx2(); // <-- 주소값(참조 변수)가 없다. 그래서 익명 클래스라고 부를 수 있다.
		// 다시 접근해서 사용할 일이 없으면 new라고 선언만 해도 된다.
	} // end of main

}
