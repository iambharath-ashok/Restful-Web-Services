/**
 * 
 */
package com.guru.bharath.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guru.bharath.restfulwebservices.beans.PostBean;
import com.guru.bharath.restfulwebservices.beans.UserBean;
import com.guru.bharath.restfulwebservices.exception.UserNotFoundException;
import com.guru.bharath.restfulwebservices.exceptions.PostNotFoundException;
import com.guru.bharath.restfulwebservices.exceptions.UserPostException;
import com.guru.bharath.restfulwebservices.services.PostService;
import com.guru.bharath.restfulwebservices.services.UserService;

/**
 * @author AB40286
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postServcie;

	@GetMapping("/users")
	public List<UserBean> retriveUsers() {
		return userService.findAll();
	}

	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody UserBean userBean) {
		UserBean bean = userService.save(userBean);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(bean.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}")
	public UserBean retriveUserById(@PathVariable Long id) {
		UserBean userBean = userService.findOne(id);
		if (userBean == null)
			throw new UserNotFoundException("id- " + id);
		return userBean;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) throws Exception {
		UserBean user = userService.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("User Id- " + id+ " Not Found");
	}

	@GetMapping("/users/{userId}/posts")
	public List<PostBean> retriveAllUserPost(@PathVariable Long userId) {
		List<PostBean> posts = postServcie.findById(userId);
		if (posts == null || posts.isEmpty()) {
			throw new UserNotFoundException("User Id- " + userId.toString() + " Not Found");
		}
		return posts;
	}

	@GetMapping("/users/{userId}/posts/{postId}")
	public PostBean retriveAllUserPost(@PathVariable Long userId, @PathVariable Long postId) {
		PostBean postBean = postServcie.findById(userId, postId);
		if (postBean == null) {
			throw new PostNotFoundException("Post Id- " + postId.toString() + " Not Found");
		}
		return postBean;
	}
	
	@PostMapping("/users/{userId}/posts")
	public PostBean createUserPost(@PathVariable Long userId, @RequestBody PostBean post) {
		UserBean user = userService.findOne(userId);
		if(user == null) {
			throw new UserNotFoundException("User Id- "+ userId);
		}
		PostBean postBean = postServcie.save(user.getId(), post);
		if (postBean == null) {
			throw new UserPostException("Error in Posting "+post);
		}
		return postBean;
	}

}
