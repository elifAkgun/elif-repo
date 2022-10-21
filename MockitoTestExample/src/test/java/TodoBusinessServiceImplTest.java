import code.elif.TodoBusinessImpl;
import code.elif.TodoService;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class TodoBusinessServiceImplTest {


    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void testDeleteTodosNotRelatedToSpring_argumentCapture_single() {

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        Mockito.when(todoService.retrieveTodos("Dummy"))
                .thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Learn to Dance"));
    }

}
