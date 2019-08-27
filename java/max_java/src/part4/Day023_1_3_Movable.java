package part4;
/*
 * 추상클래스보다 더 추상적이다.
 * 일반메소드를 가질 수 없다.
 * 생성자 가질 수 없다.
 * 
 */
public interface Day023_1_3_Movable {
	final int i=0;
	public abstract void back();
	public abstract void move(int x,int y);
	/*
	 * pubilc Movable() {} public void back() {
	 * 
	 * }
	 */
}
