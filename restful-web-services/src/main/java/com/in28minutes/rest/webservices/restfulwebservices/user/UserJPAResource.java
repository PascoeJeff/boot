package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
@RestController
public class UserJPAResource {
	private UserRepository userRepository;
	private PostRepository postRepository;


	public UserJPAResource(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}



	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User saved = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()){
			throw new UserNotFoundException("id-"+id);
		}

		// "all-users", SERVER_PATH + "/users"
		Resource<User> resoure = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resoure.add(linkTo.withRel("all-users"));
		return resoure;
	}
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		Optional<User> toDelete = userRepository.findById(id);
		if(!toDelete.isPresent()){
			throw new UserNotFoundException("id-"+id);
		}
		userRepository.delete(new User(id,null,null));


	}

	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		return user.map(u -> u.getPosts()).orElseThrow(() -> new UserNotFoundException("id-"+id));
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createUser(@PathVariable int id, @RequestBody Post post){
		Optional<User> userOptional = userRepository.findById(id);

		if(!userOptional.isPresent()){
			throw new UserNotFoundException("id-"+id);
		}
		User user = userOptional.get();
		post.setUser(user);
		Post saved = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
