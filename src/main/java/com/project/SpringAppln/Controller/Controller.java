package com.project.SpringAppln.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.project.SpringAppln.Model.Todo;
import com.project.SpringAppln.Services.TodoServices;


@RestController
public class Controller {

	@GetMapping("/api/testing.html")
	public String testing() {
		return "testing";
	}
	
	
	@Autowired
	private TodoServices todoService;
	
	
	@GetMapping("/todoList/viewAllTodoLists")
	public List<Todo> viewAllTodoLists(Model model, @ModelAttribute("message") String message) {
//		model.addAttribute("list", todoService.getAllTodo());
//		model.addAttribute("message", message);
//				
//		return new ModelAndView("ViewTodo"); 
		List<Todo> list = new ArrayList<>();
		list = todoService.getAllTodo();
		return list;
	}
	
	@GetMapping("/todoList/updateTodoItem/{id}")
	public String updateTodoItem(@PathVariable Long id) {
		if(todoService.updateTodo(id)) {
			//redirectAttribute.addFlashAttribute("message","Update Successfull");
			return "Details Updated Successfully!!!";
			}
		//redirectAttribute.addFlashAttribute("message","Update Failure");
		return "Details Updated Error!!!";
		}
	
	
	@PostMapping("/todoList/saveTodoItem")
	public String saveTodoItem(@RequestBody Todo todo) throws ParseException {
		if(todoService.saveTodo(todo)) {
			return "TodoList Added Successfully!!!";
		}
		return "TodoList Added Error!!!";

	}
	
	@GetMapping("/todoList/deleteTodoItem/{id}")
	public String deleteTodoItem(@PathVariable Long id) {
		if(todoService.deleteTodo(id)) {
			return "Delete Operation Successfully";
		}
		return "Delete Operation Failed!!!";
		
	}
	
}
