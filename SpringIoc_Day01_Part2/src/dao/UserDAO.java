package dao;

import entity.User;

/**
 * �û����ݷ��ʶ���ӿ�
 * @author W1579
 *
 */
public interface UserDAO {
	/**
	 * ����Ψһ�û�����ѯϵͳ�û������û���ҵ��û���Ϣ����null
	 */
	public User findByName(String name);
}
