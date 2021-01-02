package elif.code.model.simple.definition;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.ToString;

@ToString
public class SampleBeanWithConstructor {

    private String str;

    @Autowired
    public SampleBeanWithConstructor(String str) {
        this.str = str;
    }
}
