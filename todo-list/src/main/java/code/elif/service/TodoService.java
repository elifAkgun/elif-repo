package code.elif.service;

import code.elif.model.TodoData;
import code.elif.model.TodoItem;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public interface TodoService {

    public void addItem(@NonNull TodoItem todoItem);

    public void removeItem(int id);

    public TodoItem getItem(int id);

    public void updateItem(@NonNull TodoItem toUpdateItem);

    public TodoData getData();

}
