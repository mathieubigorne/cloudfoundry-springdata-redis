package fr.poc.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class TodoService {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static final String REDIS_KEY = "todos";
	
	@Inject
	private RedisTemplate<String, Todo> template;
	
	public void createTodo(String name) {
		UUID uid = UUID.randomUUID();
		Date now = new Date();
		
		Todo newTodo = new Todo(name + " " + uid + " " + now.toString());
		template.opsForHash().put(REDIS_KEY, uid, newTodo);
	}
	
	public List<Todo> getTodos() {
		List<Todo> todos = new ArrayList<Todo>();		
		logger.info("List size : " + template.opsForHash().size(REDIS_KEY));
		
		for (Object o : template.opsForHash().values(REDIS_KEY)) {
			todos.add((Todo) o);
		}
		
		return Lists.reverse(todos);
	}
}
