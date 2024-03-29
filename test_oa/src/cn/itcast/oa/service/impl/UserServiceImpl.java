package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IUserDao;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IUserService;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
     @Resource
	private IUserDao userDao;
     /**
 	 * 查询所有用户列表
 	 */
	public List<User> findAll() {
		return userDao.findAll();
	}
	/**
	 * 根据id删除用户
	 */
	public void delete(User model) {
		userDao.delete(model.getId());
	}
    /**
     * 添加
     */
	public void save(User model) {
		userDao.save(model);
	}
	/**
	 * 根据id查询用户
	 */
	public User getByid(Long id) {
		return userDao.getByid(id);
	}
	/**
	 * 根据id修改用户
	 */
	public void update(User user) {
		userDao.update(user);		
	}
	/**
	 * 根据登录名查询
	 */
	public int findByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}
	/**
	 * 用户登录
	 */
	public User login(User model) {
		return userDao.login(model);
	}


	
}
