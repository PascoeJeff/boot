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
	private UserRepository service;

	public UserJPAResource(UserRepository service) {
		this.service = service;
	}

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}



	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User saved = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id){
		Optional<User> user = service.findById(id);
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
	public void delteUser(@PathVariable Integer id){
		Optional<User> toDelete = service.findById(id);
		if(!toDelete.isPresent()){
			throw new UserNotFoundException("id-"+id);
		}
		service.delete(new User(id,null,null));


	}
}
