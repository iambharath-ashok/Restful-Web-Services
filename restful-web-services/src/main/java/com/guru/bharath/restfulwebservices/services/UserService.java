/**
 * 
 */
package com.guru.bharath.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.guru.bharath.restfulwebservices.beans.UserBean;

/**
 * @author AB40286
 *
 */
@Service
public class UserService {

	private static List<UserBean> usersList = new ArrayList<>();
	private static Long usersCount = 3l;

	static {
		usersList.add(new UserBean(1l, "AAAA", new Date()));
		usersList.add(new UserBean(2l, "BBB", new Date()));
		usersList.add(new UserBean(3l, "CCC", new Date()));
	}

	public List<UserBean> findAll() {
		return usersList;
	}

	public UserBean save(UserBean userBean) {
		if (userBean.getId() == null) {
			userBean.setId(++ usersCount);
		}
		usersList.add(userBean);
		return userBean;
	}

	public UserBean findOne(Long id) {
		if (id == null) {
			return null;
		}
		return usersList.stream().filter(user -> id.equals(user.getId())).findAny().orElse(null);

	}

	public UserBean deleteById(int id) {
		Iterator<UserBean> iterator = usersList.iterator();
		while (iterator.hasNext()) {
			UserBean user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
