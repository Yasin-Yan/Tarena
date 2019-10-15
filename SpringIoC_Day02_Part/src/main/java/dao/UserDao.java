package dao;

import entity.User;

//�û����ݷ��ʶ���ӿ�
public interface UserDao {
//	����Ψһ�û�����ѯϵͳ�û������û���ҵ��û���Ϣ����null
	public User findByName(String name);
//	�����ǿ�����չ�Ĺ���
	public User add(String name, String pwd, String phone);
	public User find(int id);
	public User delete(int id);
	public void update(User user);
}
