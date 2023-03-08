package cn.edu.hit.dao;

import java.util.List;

import cn.edu.hit.entity.Goods;

public interface GoodsDao {
	void add(Goods g);
	void modify(Goods g);
	void remove(String gid);
	List<Goods> getAll(String sql);
	List<Goods> getbyKind(String type);

	Goods getByGid(String gid);
}
