package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TryColorChange extends JFrame implements ActionListener {

	// field
	private JPanel panel;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;

	// Constructor
	public TryColorChange() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// methods
	private void initData() {
		setTitle("버튼으로 색깔 전환 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel2 = new JPanel();
		panel.setBackground(Color.yellow);
		panel2.setBackground(Color.yellow);

		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
	}

	private void setInitLayout() {
		setVisible(true);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		add(panel, BorderLayout.SOUTH);
		add(panel2);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	// 콜백 메서드이다.
	// 오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton selectedButton = (JButton) e.getSource();
		if (selectedButton == this.button1) {
			panel.setBackground(Color.BLACK);
			panel2.setBackground(Color.BLACK);
		} else if (selectedButton == this.button2) {
			panel.setBackground(Color.BLUE);
			panel2.setBackground(Color.BLUE);
		} else {
			panel.setBackground(Color.GRAY);
			panel2.setBackground(Color.GRAY);
		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		new TryColorChange();
	} // end of main

} // end of class
