package code.elif;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import code.elif.bean.City;

/**
 * Hello world!
 *
 */
public class App2 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-challenge.xml");

		City city = (City) applicationContext.getBean("city");
		city.getMyInfo();

		((ClassPathXmlApplicationContext) applicationContext).close();

	}
}
