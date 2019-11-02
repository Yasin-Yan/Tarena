package entity;

public class Dept1 {
	private Integer no;
	private String name;
	private String loc;
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept1 [no=" + no + ", name=" + name + ", loc=" + loc + "]";
	}
	
}
