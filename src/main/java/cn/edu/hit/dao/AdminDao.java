package cn.edu.hit.dao;

import cn.edu.hit.entity.Admin;

public interface AdminDao {
	boolean modify(String oldadpwd, String adpwd);
	Admin getByAdpwd(String Adpwd);
	void getgoods(String gname, int pnum);
	public boolean modifyPwd(String adid, String oldpwd, String newpwd);
}
