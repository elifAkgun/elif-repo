package code.elif;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import code.elif.bean.City;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		//eğer bu kodun çalışmasını istiyorsak bunun için dosyanın ana dizin altında olması gerekir.
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans-challenge.xml");

		City city = (City) applicationContext.getBean("city");
		city.getCityName();

		((FileSystemXmlApplicationContext) applicationContext).close();

	}
}
