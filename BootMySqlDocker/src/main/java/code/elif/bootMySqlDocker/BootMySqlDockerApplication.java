package code.elif.bootMySqlDocker;

import code.elif.bootMySqlDocker.model.Cambly;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BootMySqlDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMySqlDockerApplication.class, args);
	}

	@Bean(name = "cambly")
	@Scope(value = "prototype")
	Cambly cambly(){
		return new Cambly();
	}

}
