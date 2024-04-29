package ch02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyComponents extends JFrame {

	// 독립적인 생명주기를 가진다고 해서 컴포넌트
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox checkBox;

	public MyComponents() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("컴포넌트 확인");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("JButton");
		label = new JLabel("글자를 띄우는 컴포넌트");
		textField = new JTextField("아이디 입력", 20);
		passwordField = new JPasswordField("비번입력", 20);
		checkBox = new JCheckBox("동의");
	}

	private void setInitLayout() {

		setLayout(new FlowLayout());
		setVisible(true);

		add(button);
		add(label);
		add(textField);
		add(passwordField);
		add(checkBox);

	}

	public static void main(String[] args) {
		//new MyComponents(); //객체 주소값을 알고 있어야 여기에 들어갈 수 있다.
		MyComponents components = new MyComponents();
		components.textField.setText("반가워");
	}
	
}
