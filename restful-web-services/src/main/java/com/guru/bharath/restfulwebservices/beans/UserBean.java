/**
 * 
 */
package com.guru.bharath.restfulwebservices.beans;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author AB40286
 *
 */
public class UserBean {

	private Long id;

	public UserBean() {
		super();
	}

	public UserBean(Long id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public UserBean(Long id, String name, Date birthDate, List<PostBean> userPosts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.userPosts = userPosts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	private String name;
	private Date birthDate;
	//@JsonIgnore
	private List<PostBean> userPosts;

	public List<PostBean> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(List<PostBean> userPosts) {
		this.userPosts = userPosts;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", userPosts=" + userPosts + "]";
	}
	

}
