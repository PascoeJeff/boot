package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	private static List<Post> posts = new ArrayList<>();

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));

		posts.add(new Post(users.get(0),1, "Adam Post 1"));
		posts.add(new Post(users.get(0),2, "Adam Post 2"));
		posts.add(new Post(users.get(0),3, "Adam Post 3"));

		posts.add(new Post(users.get(1),4, "Eve Post 1"));
		posts.add(new Post(users.get(1),5, "Eve Post 2"));
		posts.add(new Post(users.get(1),6, "Eve Post 3"));

		posts.add(new Post(users.get(2),7, "Jack Post 1"));
		posts.add(new Post(users.get(2),8, "Jack Post 2"));
		posts.add(new Post(users.get(2),9, "Jack Post 3"));
	}

	private static int userCount = 3;

	public List<User> findAll(){
		return users;
	}

	public User findOne(Integer id){
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
	}

	public User save(User user){
		if(user.getId() == null){
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	public User delete(int id){
		Iterator<User> it = users.iterator();
		while(it.hasNext()){
			User user = it.next();
			if(user.getId() == id){
				it.remove();
				return user;
			}
		}
		return null;
	}

	public List<Post> findAll(Integer userId){
		return getAllPosts(userId);
	}
	public Post findOne(Integer userId, Integer postId){
		return getAllPosts(userId).stream().filter(p -> p.getId().equals(postId)).findFirst().get();
	}

	private List<Post> getAllPosts(Integer userId) {
		if(userId == 1){
			return posts.subList(0,2);
		}else if (userId == 2){
			return posts.subList(3,6);
		}else if (userId == 3){
			return posts.subList(6,8);
		}
		return null;
	}
}
