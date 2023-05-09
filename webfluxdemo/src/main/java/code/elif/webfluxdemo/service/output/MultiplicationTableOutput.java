package code.elif.webfluxdemo.service.output;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class MultiplicationTableOutput extends BaseOutput {
    private String multiplicationTableItem;


}
