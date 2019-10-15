package service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;

//ҵ���
@Service //Ĭ�ϵ�Bean ID��userService
public class UserService implements Serializable{
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
//	��¼ϵͳ����
	public User login(String name, String pwd) {
		try {
			User user = userDao.findByName(name);
			if(user.getPwd().equals(pwd)) {
				return user;
			}
			return null;
		}catch(Exception e) {
		e.printStackTrace();
		return null;
		}
	}
}
