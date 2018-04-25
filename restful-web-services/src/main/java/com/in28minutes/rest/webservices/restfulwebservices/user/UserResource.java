package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
	  	return service.findAll();
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable Integer id){
		return service.findAll(id);
	}

	@GetMapping(path = "/users/{id}/posts/{postId}")
	public Post retrieveOnePosts(@PathVariable Integer id, @PathVariable Integer postId){
		return service.findOne(id, postId);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User saved = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id){
		User user = service.findOne(id);
		if(user == null){
			throw new UserNotFoundException("id-"+id);
		}

		// "all-users", SERVER_PATH + "/users"
		Resource<User> resoure = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resoure.add(linkTo.withRel("all-users"));
		return resoure;
	}
	@DeleteMapping(path = "/users/{id}")
	public void delteUser(@PathVariable Integer id){
		User user = service.delete(id);
		if(user == null){
			throw new UserNotFoundException("id-"+id);
		}

	}


}
