/**
 * 
 */
package com.guru.bharath.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.guru.bharath.restfulwebservices.beans.PostBean;

/**
 * @author AB40286
 *
 */
@Service
public class PostService {

	private static final List<PostBean> posts = new ArrayList<>();

	static {
		posts.add(new PostBean(1l, 1l, "Post 1", new Date()));
		posts.add(new PostBean(2l, 1l, "Post 2", new Date()));
		posts.add(new PostBean(3l, 1l, "Post 3", new Date()));
		posts.add(new PostBean(4l, 2l, "Post 1", new Date()));
		posts.add(new PostBean(5l, 2l, "Post 2", new Date()));
		posts.add(new PostBean(6l, 2l, "Post 3", new Date()));
		posts.add(new PostBean(7l, 3l, "Post 1", new Date()));
		posts.add(new PostBean(8l, 3l, "Post 2", new Date()));
		posts.add(new PostBean(9l, 4l, "Post 1", new Date()));
		posts.add(new PostBean(10l, 4l, "Post 2", new Date()));
		posts.add(new PostBean(11l, 4l, "Post 3", new Date()));
		posts.add(new PostBean(12l, 5l, "Post 1", new Date()));
	}

	public List<PostBean> findById(Long userId) {
		return posts.stream().filter(post -> post.getUserId().equals(userId)).collect(Collectors.toList());
	}

	public PostBean findById(Long userId, Long postId) {
		PostBean postBean = posts.stream().filter(posts -> posts.getUserId().equals(userId))
		.filter(post -> post.getPostId().equals(postId)).findFirst().orElse(null);
		 return postBean;
	}

	public PostBean save(Long userId, PostBean post) {
		Integer postsCount = posts.size();
		post.setUserId(userId);
		post.setPostId((++postsCount).longValue());
		posts.add(post);
		return post;
	}

}
