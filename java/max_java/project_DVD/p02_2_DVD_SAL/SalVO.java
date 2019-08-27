package p02_2_DVD_SAL;

public class SalVO {

	private String StartDay      	=null;
	private String MovieTitle       =null;
	private String ReturnDay        =null;
	private String LateFee          =null;
	private String TotalSal         =null;
	private String Id         		=null;

	//테이블에는 없지만 업무 구분을 위한 변수 선언
	private String command			= null; // select detail insert update delete

	//오라클 서버에서 반환되는 값을 담을 변수 - 1 성공 0 실패
	private int status				= -1;
	
	//검색조건 변수
	private String What				=null;
	//검색한 값 변수
	private String Input			=null;
	

	public String getStartDay() {
		return StartDay;
	}
	public void setStartDay(String startDay) {
		StartDay = startDay;
	}
	public String getMovieTitle() {
		return MovieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		MovieTitle = movieTitle;
	}
	public String getReturnDay() {
		return ReturnDay;
	}
	public void setReturnDay(String returnDay) {
		ReturnDay = returnDay;
	}
	public String getLateFee() {
		return LateFee;
	}
	public void setLateFee(String lateFee) {
		LateFee = lateFee;
	}
	public String getTotalSal() {
		return TotalSal;
	}
	public void setTotalSal(String totalSal) {
		TotalSal = totalSal;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getWhat() {
		return What;
	}
	public void setWhat(String what) {
		What = what;
	}
	public String getInput() {
		return Input;
	}
	public void setInput(String input) {
		Input = input;
	}

}
