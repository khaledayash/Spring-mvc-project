/**
 * 
 */
/**
 * @author khale
 *
 */
package com.khaled.todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.khaled.model.Todo;
import com.khaled.todo.service.TodoService;

@Controller
@SessionAttributes("name")

public class TodoController {

	@Autowired
	private TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodosList(ModelMap model, String name) {
		String user = (String) model.get("name");
		model.addAttribute("todos", service.retrieveTodos(user));
		return "list-todos";
	}
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, "khaled", "hello World!", null, false));
		return "todo";
	}
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult  result) {
		if(result.hasErrors()) 	return "todo";
		String user = (String) model.get("name");
		service.addTodo(user, todo.getDesc(), new Date(), false);
		model.clear();
		return "redirect:/list-todos";
	}
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo( @RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
}