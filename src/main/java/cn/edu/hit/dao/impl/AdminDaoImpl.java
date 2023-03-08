package cn.edu.hit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hit.dao.AdminDao;
import cn.edu.hit.entity.Admin;
import cn.edu.hit.util.DBUtil;

public class AdminDaoImpl implements AdminDao{
	public boolean modify(String oldadpwd, String adpwd) {
		Admin a = getByAdpwd(oldadpwd);
		if(a != null)
		{
			String adid = a.getAdid();
			String adname = a.getAdname();
			String sql = "update admin set adid = '" + adid + "', adname = '" + adname + "', adpwd = '" + adpwd + "' where adid = '"+ adid +"'";
			DBUtil db = new DBUtil();
			db.executeUpdate(sql);
			return true;
		}
		else {
			return false;
		}
	}
	public  Admin getByAdpwd(String Adpwd) {
		String sql = "select * from admin where adpwd = '" + Adpwd + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				String adid = rs.getString("adid");
				String adname = rs.getString("adname");
				return new Admin(adid, adname, Adpwd);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void getgoods(String gname, int pnum) {
		String sql = "select * from goods where gname = '" + gname + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				String gid = rs.getString("gid");
				pnum += rs.getInt("pnum");
				String type = rs.getString("type");
				int price = rs.getInt("preice");
				sql = "update goods set gname = '" + gname + "', pnum = " + pnum + ", type = '" + type + "', price = " + price + " where gid = '"+ gid +"'";
				db.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean modifyPwd(String adname, String oldpwd, String newpwd) {
		String pwd = null;
		String sql = "select * from admin where adname = '" + adname + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			rs.next();
			pwd = rs.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(pwd.equals(oldpwd)) {
			sql = "update admin set adpwd='" + newpwd + "' where adname='" + adname + "'";
			db.executeUpdate(sql);
			return true;
		}
		else return false;
	}

}
