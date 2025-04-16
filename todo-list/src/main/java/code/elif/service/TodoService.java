package code.elif.service;

import code.elif.model.TodoData;
import code.elif.model.TodoItem;
import lombok.NonNull;

public interface TodoService {

    public void addItem(@NonNull TodoItem todoItem);

    public void removeItem(int id);

    public TodoItem getItem(int id);

    public void updateItem(@NonNull TodoItem toUpdateItem);

    public TodoData getData();

}
