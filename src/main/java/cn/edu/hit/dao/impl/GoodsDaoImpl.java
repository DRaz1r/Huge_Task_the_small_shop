package cn.edu.hit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.dao.GoodsDao;
import cn.edu.hit.entity.Goods;
import cn.edu.hit.util.DBUtil;

public class GoodsDaoImpl implements GoodsDao {
	@Override
	public void add(Goods g) {
		String gid = g.getGid();
		String gname = g.getGname();
		String type = g.getType();
		int price = g.getPrice();
		String sql = "insert into goods values('" + gid + "','" + gname + "','" + type + "'," + price + ")";
		DBUtil db = new DBUtil();
		db.executeUpdate(sql);
	}
	@Override
	public void modify(Goods g) {
		String gid = g.getGid();
		String gname = g.getGname();
		String type = g.getType();
		int price = g.getPrice();
		int snum = g.getSnum();
		int pnum = g.getPnum();
		String sql = "update goods set gname = '" + gname + "', type = '" + type + "', price = " + price + ", snum = " + snum + ",pnum = " + pnum + " where gid = '"+ gid +"'";
		DBUtil db = new DBUtil();
		db.executeUpdate(sql);
	}
	@Override
	public void remove(String gid) {
		String sql = "delete from goods where gid = '" + gid + "'";
		DBUtil db = new DBUtil();
		db.executeUpdate(sql);
	}
	@Override
	public List<Goods> getAll(String sql) {
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		List <Goods> list = new ArrayList<>(); 
		try {
			String gid;
			String gname;
			int pnum;
			int snum;
			String type;
			int price;
			while(rs.next()) {
				gid = rs.getString("gid");
				gname = rs.getString("gname");
				pnum = rs.getInt("pnum");
				snum = rs.getInt("snum");
				type = rs.getString("type");
				price = rs.getInt("price");
				list.add(new Goods(gid, gname, pnum, snum, type, price));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public Goods getByGid(String gid) {
		String sql = "select * from goods where gid = '" + gid + "'";
		DBUtil db = new DBUtil();
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				String gname = rs.getString("gname");
				int pnum = rs.getInt("pnum");
				int snum = rs.getInt("snum");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				return new Goods(gid, gname, pnum, snum, type, price);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Goods> getbyKind(String type) {
		DBUtil db = new DBUtil();
		String sql = "select * from goods where type = '" + type + "'";
		ResultSet rs = db.executeQuery(sql);
		List <Goods> list = new ArrayList<>(); 
		String gid;
		String gname;
		int pnum;
		int snum;
		int price;
		try {
			while(rs.next()) {
				gid = rs.getString("gid");
				gname = rs.getString("gname");
				pnum = rs.getInt("pnum");
				snum = rs.getInt("snum");
				type = rs.getString("type");
				price = rs.getInt("preice");
				list.add(new Goods(gid, gname, pnum, snum, type, price));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
