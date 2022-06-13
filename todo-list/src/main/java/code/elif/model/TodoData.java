package code.elif.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {

    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    public TodoData(){
        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
        addItem(new TodoItem("fourth", "fourth details", LocalDate.now()));

    }

    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem todoItem){
        todoItem.setId(idValue);
        items.add(todoItem);
        idValue++;
    }

    public void removeItem(int id){
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()){
            TodoItem todoItem = itemListIterator.next();

            if (todoItem.getId() == id){
                itemListIterator.remove();
                break;
            }
        }
    }
    
    public TodoItem getTodoItem(int id){
        for (TodoItem item:items) {
            if(item.getId()== id){
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdateItem){
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()){
            TodoItem todoItem = itemListIterator.next();

            if (todoItem.equals(toUpdateItem)){
                itemListIterator.set(toUpdateItem);
                break;
            }
        }
    }
}
