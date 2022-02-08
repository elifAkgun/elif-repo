package code.elif.app.ws.mobileappws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2);

    }


    public static void main(String[] args) {
        Runnable r = ()-> {
            for (int i =0; i<10;i++){
                System.out.println(i + " child thread");
            }
        };
        Thread t = new Thread(r);
        t.start();

        for (int i =0; i<10;i++){
            System.out.println(i + " main thread");
        }
    }
}
