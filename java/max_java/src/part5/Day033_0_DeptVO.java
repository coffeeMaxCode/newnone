package part5;

public class Day033_0_DeptVO {
	   private int    deptno = 0;//
	   private String  dname = "";//NullPointerException 예상
	   private String  loc = "";//
	   private Day033_0_EmpVO empVO = null;
	   public int getDeptno() {
	      return deptno;
	   }
	   public void setDeptno(int deptno) {
	      this.deptno = deptno;
	   }
	   public String getDname() {
	      return dname;
	   }
	   public void setDname(String dname) {
	      this.dname = dname;
	   }
	   public String getLoc() {
	      return loc;
	   }
	   public void setLoc(String loc) {
	      this.loc = loc;
	   }
	   public Day033_0_EmpVO getEmpVO() {
	      return empVO;
	   }
	   public void setEmpVO(Day033_0_EmpVO empVO) {
	      this.empVO = empVO;
	   }

	}