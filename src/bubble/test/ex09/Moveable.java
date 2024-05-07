package bubble.test.ex09;

public interface Moveable {

	// public abstract 생략 가능
	public abstract void left();

	public abstract void right();

	void up();

	// 인터페이스 추가 기능 default 사용해보기
	// 인터페이스에 모든 메서드는 추상 메서드이어야 한다.
	// 단 default 메서드를 제외하고
	default void down() {
	};
	// 마지막에 default는 세미콜론 추가하는게 통용되는 방식이지만 버전에 따라 추가하지 않아도 된다.
	
}
