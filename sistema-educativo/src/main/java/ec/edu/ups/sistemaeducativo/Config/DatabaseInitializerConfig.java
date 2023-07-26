package ec.edu.ups.sistemaeducativo.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseInitializerConfig {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initializer() {
        try {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("data.sql"));
            populator.execute(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}