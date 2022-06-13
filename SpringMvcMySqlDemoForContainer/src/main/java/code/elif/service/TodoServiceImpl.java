package code.elif.service;

import code.elif.controller.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Override
    public List<Todo> getAllTodos() {
        return  Arrays.asList(new Todo("Temizlik", "Temizlik yapılacak", LocalDate.now()));
    }
}
