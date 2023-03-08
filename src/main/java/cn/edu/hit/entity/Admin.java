package cn.edu.hit.entity;

public class Admin {
	private String adid;
	private String adname;
	private String adpwd;
	public Admin() {
		super();
	}
	public Admin(String adid, String adname, String adpwd) {
		super();
		this.adid = adid;
		this.adname = adname;
		this.adpwd = adpwd;
	}
	public String getAdid() {
		return adid;
	}
	public void setAdid(String adid) {
		this.adid = adid;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getAdpwd() {
		return adpwd;
	}
	public void setAdpwd(String adpwd) {
		this.adpwd = adpwd;
	}
	
}
