package elif.code.model.simple.definition;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.ToString;

@ToString
public class SampleBeanWithSetter {

    private String str;

    @Autowired
    public void setStr(String str) {
        this.str = str;
    }

}
