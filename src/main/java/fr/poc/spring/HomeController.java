package fr.poc.spring;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Inject
	private TodoService todoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		todoService.createTodo("New item");
        ModelAndView mav = new ModelAndView();

		mav.addObject("todos", todoService.getTodos());
		mav.setViewName("home");
		return mav;
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public @ResponseBody List<Todo> getTodoInJSON() {
		return todoService.getTodos();
	}

}
