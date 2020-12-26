package jdbcbasis;

/**
 * @version 1.0
 * @Description student class 重写toString
 * @Author mhw
 * @Date 2020/11/28 16:30
 */
public class Student {
    private String Sno;
    private String Sname;
    private String Ssex;
    private String Sdept;
    private int Sage;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    @Override
    public String toString() {
        return String.format("{Student: id=%s, name=%s, Sex=%s, age=%d, dept=%s}", this.Sno, this.Sname, this.Ssex, this.Sage, this.Sdept);
    }
}
