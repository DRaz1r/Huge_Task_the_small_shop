package cn.edu.hit.dao;

import java.util.List;

import cn.edu.hit.entity.OrderForm;
import cn.edu.hit.entity.Sysuser;

public interface SysuserDao {
	public String register(String uname, String pwd);
	public boolean login(String uid, String pwd);
	public boolean modifyPwd(String uid, String oldpwd, String newpwd);
	public String buyGoods(String gid, String uid, int num);
	public OrderForm getOrderFormByOid(String oid);
	public void add(Sysuser s);
	public void modify(Sysuser s);
	public void remove(String uid);
	public List<Sysuser> getAll(String sql); 
	public Sysuser getByUid(String uid);
	public Sysuser getByUname(String uname);
	public List<OrderForm> getAllOrder(String sql);
	public int getPageCount();
}
