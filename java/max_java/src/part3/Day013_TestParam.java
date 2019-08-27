package part3;
class Param{
	int ival = 0;
}
public class Day013_TestParam {
	public void effectParam(Param p) {
		//p=new Param();
		p.ival = 500;
		//insert here - sub ival=?
	}
	public static void main(String[] args) {
		Day013_TestParam tp = new Day013_TestParam();
		Param p = new Param();
		p.ival = 100;
		tp.effectParam(p);
		//insert here = main ival =?
	}

}