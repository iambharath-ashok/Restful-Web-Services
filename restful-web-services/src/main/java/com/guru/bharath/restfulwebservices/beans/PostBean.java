/**
 * 
 */
package com.guru.bharath.restfulwebservices.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author AB40286
 *
 */

public class PostBean {
	
	//@JsonIgnore
	private Long userId;
	private Long postId;
	private String postMessage;
	private Date postDate;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public PostBean() {
		super();
	}

	public PostBean(Long postId, Long userId, String postMessage, Date postDate) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.postMessage = postMessage;
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "PostBean [userId=" + userId + ", postId=" + postId + ", postMessage=" + postMessage + ", postDate="
				+ postDate + "]";
	}

}
