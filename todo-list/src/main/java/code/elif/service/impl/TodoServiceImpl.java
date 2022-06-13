package code.elif.service.impl;

import code.elif.model.TodoData;
import code.elif.model.TodoItem;
import code.elif.service.TodoService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoData todoData = new TodoData();

    @Override
    public void addItem(@NonNull TodoItem todoItem) {
        todoData.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        todoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return todoData.getTodoItem(id);
    }

    @Override
    public void updateItem(@NonNull TodoItem toUpdateItem) {
        todoData.updateItem(toUpdateItem);
    }

    @Override
    public TodoData getData() {
        return todoData;
    }
}
