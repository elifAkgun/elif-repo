package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MultiplicationTableReactiveServiceImplTest {

    @InjectMocks
    MultiplicationTableReactiveServiceImpl mathService;




    // JUnit test for
    @Test
    void givenNumber_whenMultiplicationTableCalled_thenReturnList() {
        // given- precondition or setup
        int number = 3;
        // when - action or the behaviour that we are going test
        Flux<MultiplicationTableOutput> multiplicationTable = mathService.getMultiplicationTable(number);

        // then - verify the output
        assertThat(Objects.requireNonNull(multiplicationTable.next().block()).getMultiplicationTableItem()).isEqualTo("3x1=3");
    }

}