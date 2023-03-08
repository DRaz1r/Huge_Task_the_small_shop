package cn.edu.hit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.dao.SysuserDao;
import cn.edu.hit.entity.Goods;
import cn.edu.hit.entity.OrderForm;
import cn.edu.hit.entity.Sysuser;
import cn.edu.hit.util.DBUtil;

public class SysuserDaoImpl implements SysuserDao{
	@Override
	public String register(String uname, String pwd) {
		int tot = 0;
		String uid;
		String sql = "select count(*) from sysuser";
		DBUtil db = new DBUtil();
		ResultSet rs ;
		rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				tot = rs.getInt(1);
			}
			else tot = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tot != 0) {
			sql = "select * from sysuser limit " + Integer.toString(tot-1) + ",1";
			rs = db.executeQuery(sql);
			try {
				if(rs.next()) {
					tot = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			uid = Integer.toString(tot+1);
		}
		else uid = "1";
		sql = "insert into sysuser values('" + uid + "','" + uname + "','" + pwd + "')";
		db.executeUpdate(sql);
		return uid;
	}
	@Override
	public boolean login(String uname, String pwd) {
		String sql = "select count(*) from sysuser where uname = '" + uname +"' and pwd = '" + pwd + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		int count = 0;
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e){
			e.printStackTrace();
		}
		if(count == 1) return true;
		return false;
	}
	@Override
	public boolean modifyPwd(String uname, String oldpwd, String newpwd) {
		String pwd = null;
		String sql = "select * from sysuser where uname = '" + uname + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			rs.next();
			pwd = rs.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(pwd.equals(oldpwd)) {
			sql = "update sysuser set pwd='" + newpwd + "' where uname='" + uname + "'";
			db.executeUpdate(sql);
			return true;
		}
		else return false;
	}
	@Override
	public String buyGoods(String gid, String uid, int num) {
		int tot = 0;
		String oid;
		String sql = "select count(*) from orderform";
		DBUtil db = new DBUtil();
		ResultSet rs ;
		rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				tot = rs.getInt(1);
			}
			else tot = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tot != 0) {
			sql = "select * from orderform limit " + Integer.toString(tot-1) + ",1";
			rs = db.executeQuery(sql);
			try {
				if(rs.next()) {
					tot = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			oid = Integer.toString(tot+1);
		}
		else oid = "1";
		sql = "insert into orderform values('" + oid + "','" + gid + "'," + num + ",CURRENT_TIMESTAMP)";
		db.executeUpdate(sql);
		return oid;
	}
	@Override
	public OrderForm getOrderFormByOid(String oid) {
		String gid = null;
		String uid = null;
		int num = 0;
		String time = null;
		String sql = "select * from orderform where oid='" + oid + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			rs.next();
			gid = rs.getString(2);
			uid = rs.getString(3);
			num = rs.getInt(4);
			time = rs.getString(5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new OrderForm(oid, gid, uid, num, time);
	}
	@Override
	public List<OrderForm> getAllOrder(String sql) {
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		List <OrderForm> list = new ArrayList<>(); 
		try {
			String oid;
			String gid;
			String uid;
			int num;
			String time;
			while(rs.next()) {
				oid = rs.getString("oid");
				gid = rs.getString("gid");
				uid = rs.getString("uid");
				num= rs.getInt("num");
				time = rs.getString("time");
				list.add(new OrderForm(oid,gid,uid,num,time));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void add(Sysuser s) {
		String uid = s.getUid();
		String uname = s.getUname();
		String pwd = s.getPwd();
		String sql = "insert into sysuser values('" + uid + "','" + uname + "','"  + pwd + "')";
		DBUtil db = new DBUtil();
		db.executeUpdate(sql);
	}

	@Override
	public void modify(Sysuser s) {
		String uid = s.getUid();
		String uname = s.getUname();
		String pwd = s.getPwd();
		String sql = "update sysuser set uname = '" + uname + "', pwd = '" + pwd + "' where uid = '"+ uid +"'";
		DBUtil db = new DBUtil();
		db.executeUpdate(sql);
	}

	@Override
	public void remove(String uid) {
		String sql = "delete from sysuser where uid = '" + uid + "'";
		DBUtil db = new DBUtil();
		db.executeUpdate(sql);
	}

	@Override
	public List<Sysuser> getAll(String sql) {
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		List <Sysuser> list = new ArrayList<>(); 
		try {
			String uid;
			String uname;
			String pwd;
			while(rs.next()) {
				uid = rs.getString("uid");
				uname = rs.getString("uname");
				pwd = rs.getString("pwd");
				list.add(new Sysuser(uid, uname, pwd));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Sysuser getByUid(String uid) {
		String sql = "select * from Sysuser where uid = '" + uid + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				String uname = rs.getString("uname");
				String pwd = rs.getString("pwd");
				return new Sysuser(uid, uname, pwd);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override 
	public Sysuser getByUname(String uname) {
		String sql = "select * from Sysuser where uname = '" + uname + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				String uid = rs.getString("uid");
				String pwd = rs.getString("pwd");
				return new Sysuser(uid, uname, pwd);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int getPageCount() {
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery("select count(*) from orderform");
		int PAGE_SIZE = 5;
		try {
			rs.next();
			int rowCount = rs.getInt(1);
			int pageCount = ( rowCount + PAGE_SIZE - 1)/ rowCount;
			return pageCount+1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
