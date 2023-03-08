package cn.edu.hit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hit.dao.loginDao;
import cn.edu.hit.util.DBUtil;

public class loginDaoImpl implements loginDao {

	@Override
	public boolean login(String adname, String adpwd) {
		String sql = "select count(*) from admin where adname = '" + adname +"' and adpwd = '" + adpwd + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		int count = 0;
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e){
			e.printStackTrace();
		}
		db.close();
		if(count == 1) return true;
		return false;
	}

}
