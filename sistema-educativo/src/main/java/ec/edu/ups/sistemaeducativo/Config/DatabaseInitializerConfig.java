package ec.edu.ups.sistemaeducativo.Config;

import javax.sql.DataSource;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

@Configuration
public class DatabaseInitializerConfig {

    @Bean
    public ServletContextInitializer initializer(DataSource dataSource) {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                try {
                    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
                    populator.addScript(new ClassPathResource("data.sql"));
                    populator.execute(dataSource);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
    }
}
