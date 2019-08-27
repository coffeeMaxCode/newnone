package mvc;
/* 표준 서블릿이 제공하는 메소드는 모두 리턴 타입이 void였다.
 * 내가 설계하는 클래스 에서는 리턴 타입을 따로 설계하여 추가 하고 싶다.
 * execute메소드의 리턴 타입을 ActionForward로 한다. 				*/
public class ActionForward {
	
	private String veiwName = null;
	private boolean isRedirect = false;
	
	public String getVeiwName() {
		return veiwName;
	}
	public void setVeiwName(String veiwName) {
		this.veiwName = veiwName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
