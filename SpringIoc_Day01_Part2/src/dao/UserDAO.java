package dao;

import entity.User;

/**
 * 用户数据访问对象接口
 * @author W1579
 *
 */
public interface UserDAO {
	/**
	 * 根据唯一用户名查询系统用户，如果没有找到用户信息返回null
	 */
	public User findByName(String name);
}
