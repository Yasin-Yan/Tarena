package service;

import dao.UserDAO;
import entity.User;

public class UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
//	登录系统功能
	public User login(String name, String pwd) {
		try {
			User user = userDAO.findByName(name);
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
