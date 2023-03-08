package cn.edu.hit.entity;

public class Goods {
	private String gid;
	private String gname;
	private int pnum;
	private int snum;
	private String type;
	private int price;
	public Goods() {
		super();
	}
	public Goods(String gid, String gname, int pnum, int snum, String type, int price) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.pnum = pnum;
		this.snum = snum;
		this.type = type;
		this.price = price;
	}

	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
