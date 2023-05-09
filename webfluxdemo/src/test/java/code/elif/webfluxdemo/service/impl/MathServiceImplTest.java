package code.elif.webfluxdemo.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MathServiceImplTest {

    @InjectMocks
    MathServiceImpl mathService;


    @Test
    public void givenNumber_whenSquareCalled_thenReturnCorrectNumber() {
        // given- precondition or setup
        Integer expected = 25;
        // when - action or the behaviour that we are going test
        Integer actual = mathService.square(5);

        // then - verify the output
        assertThat(actual)
                .isEqualTo(expected);

    }

    // JUnit test for
    @Test
    public void givenNumber_whenMultiplicationTableCalled_thenReturnList() {
        // given- precondition or setup
        int number = 3;
        // when - action or the behaviour that we are going test
        List<String> list = mathService.getMultiplicationTable(number);

        // then - verify the output
        assertThat(list)
                .contains("3x1=3");
    }

}