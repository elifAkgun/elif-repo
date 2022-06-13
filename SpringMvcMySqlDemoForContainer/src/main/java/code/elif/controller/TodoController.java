package code.elif.controller;

import code.elif.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list")
    public String listTodo(Model theModel) {
        List<Todo> todos = todoService.getAllTodos();
        theModel.addAttribute("todoList", todos);
        return "list-todos";
    }


}
