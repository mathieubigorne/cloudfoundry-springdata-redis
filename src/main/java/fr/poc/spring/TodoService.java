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
	
	@Inject
	private RedisTemplate<String, Todo> template;
	
	
	public List<Todo> getTodos() {
		List<Todo> todos = new ArrayList<Todo>();
		
		UUID uid = UUID.randomUUID();
		Date now = new Date();
		
		Todo newTodo = new Todo("Nouveau todo " + uid + " " + now.toString());
		
		
		template.opsForHash().put("redis", uid, newTodo);
		
		logger.info("Taille liste redis : " + template.opsForHash().size("redis"));
		
		for (Object o : template.opsForHash().values("redis")) {
			todos.add((Todo) o);
		}
		
		return Lists.reverse(todos);
	}
}
