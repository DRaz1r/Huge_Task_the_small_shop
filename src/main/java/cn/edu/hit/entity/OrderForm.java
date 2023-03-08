package cn.edu.hit.entity;

public class OrderForm {
	private String oid;
	private String gid;
	private int num;
	private String uid;
	private String time;
	public OrderForm() {
		super();
	}
	public OrderForm(String oid, String gid, String uid, int num, String time) {
		super();
		this.oid = oid;
		this.gid = gid;
		this.num = num;
		this.time = time;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid){
		this.uid = uid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time){
		this.time = time;
	}
}
