package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseTester {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void testConnection() {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            if (result != null && result == 1) {
                System.out.print("Successfully connected to PostgreSQL with Spring Boot!");
            } else {
                System.out.print("Connection test failed.");
            }
        } catch (Exception e) {
            System.err.print("Error testing connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

