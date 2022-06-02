package code.elif.controller.config;

import lombok.ToString;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:organization.properties")
@ToString
public class DataSourceConfig {

    @Value( "${jdbc.url}" )
    private String jdbcUrl;

    @Value( "${jdbc.username}" )
    private String username;

    @Value( "${jdbc.password}" )
    private String password;

    @Value( "${jdbc.classname}" )
    private String classname;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {

        System.out.println(this.toString());

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(classname);
        return dataSource;
    }
}
