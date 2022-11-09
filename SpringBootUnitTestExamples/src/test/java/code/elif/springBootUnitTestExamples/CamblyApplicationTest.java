package code.elif.springBootUnitTestExamples;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CamblyApplicationTest {

    @Value("${application.name}")
    String appName;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    void init() {
        System.out.println(appName + " test is started..");
    }

    @Test
    @DisplayName("CamblyDTO beans are prototype")
    void verifyCamblyBeansArePrototype() {
        CamblyDTO camblyDTO = context.getBean("cambly", CamblyDTO.class);
        CamblyDTO camblyDTO2 = context.getBean("cambly", CamblyDTO.class);
        assertNotEquals(camblyDTO, camblyDTO2);
    }
}