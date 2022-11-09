package code.elif.springBootUnitTestExamples;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringBootUnitTestExamples {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUnitTestExamples.class, args);
	}

	@Bean(name = "cambly")
	@Scope(value = "prototype")
	CamblyDTO cambly(){
		return new CamblyDTO();
	}


}
