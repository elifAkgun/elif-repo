package code.elif.service.impl;

import code.elif.model.TodoData;
import code.elif.model.TodoItem;
import code.elif.service.DemoService;
import code.elif.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoData todoData = new TodoData();

    private  final BackendAdapter backendAdapter;

    @Override
    public void addItem(@NonNull TodoItem todoItem) {
        String apiResponse = backendAdapter.getBackendResponse(todoItem.getTitle()
                , todoItem.getDetail());
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
