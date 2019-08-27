package seontalk.vo;

public class MemberVO {
	//회원테이블 정보
	private String mem_id;
	private String mem_name;
	private String nick;
	private String pw;
	private String hp;
	private String birth;
	private String profile_msg;
	private String mentoring;
	private String interest1;
	private String interest2;
	private String reg_date;
	private int rank_pt;
	private int activation;
	//설정테이블 정보
	private String font;
	private String theme;
	private String alarm;
	private int font_size;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getProfile_msg() {
		return profile_msg;
	}
	public void setProfile_msg(String profile_msg) {
		this.profile_msg = profile_msg;
	}
	public String getMentoring() {
		return mentoring;
	}
	public void setMentoring(String mentoring) {
		this.mentoring = mentoring;
	}
	public String getInterest1() {
		return interest1;
	}
	public void setInterest1(String interest1) {
		this.interest1 = interest1;
	}
	public String getInterest2() {
		return interest2;
	}
	public void setInterest2(String interest2) {
		this.interest2 = interest2;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getRank_pt() {
		return rank_pt;
	}
	public void setRank_pt(int rank_pt) {
		this.rank_pt = rank_pt;
	}
	public int getActivation() {
		return activation;
	}
	public void setActivation(int activation) {
		this.activation = activation;
	}
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getAlarm() {
		return alarm;
	}
	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}
	public int getFont_size() {
		return font_size;
	}
	public void setFont_size(int font_size) {
		this.font_size = font_size;
	}
	
	
}
