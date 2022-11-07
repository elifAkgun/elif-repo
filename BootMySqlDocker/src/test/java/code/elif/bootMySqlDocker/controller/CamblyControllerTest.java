package code.elif.bootMySqlDocker.controller;

import code.elif.bootMySqlDocker.model.Cambly;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CamblyControllerTest {

    @Value("${application.name}")
    String appName;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    void init() {
        System.out.println(appName + " test is started..");
    }

    @Test
    @DisplayName("Cambly beans are prototype")
    void verifyCamblyBeansArePrototype() {
        Cambly cambly = context.getBean("cambly", Cambly.class);
        Cambly cambly2 = context.getBean("cambly", Cambly.class);
        assertNotEquals(cambly, cambly2);
    }
}