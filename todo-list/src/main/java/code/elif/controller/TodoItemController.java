package code.elif.controller;

import code.elif.model.TodoData;
import code.elif.model.TodoItem;
import code.elif.service.TodoService;
import code.elif.util.AttributeNames;
import code.elif.util.Mappings;
import code.elif.util.Views;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private final TodoService todoService;

    @Autowired
    public TodoItemController(TodoService todoService) {
        this.todoService = todoService;
    }

    @ModelAttribute
    public TodoData todoData() {
        return todoService.getData();
    }

    @GetMapping(Mappings.ITEMS)
    public String items() {
        return Views.ITEMS_LIST;
    }

    @GetMapping(Mappings.ITEM)
    public String getItem(@RequestParam int id, Model model) {
        TodoItem todoItem = todoService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return Views.VIEW_ITEM;
    }


    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false,
            defaultValue = "-1") int id, Model model) {
        log.info("editing id : {}", id);
        TodoItem todoItem = todoService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return Views.ADD_ITEMS;

    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(name = AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form : {}", todoItem);
        if (todoItem.getId() == 0) {
            todoService.addItem(todoItem);
        } else {
            todoService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        todoService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
