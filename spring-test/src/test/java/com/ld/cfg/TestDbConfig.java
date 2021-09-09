package com.ld.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db/test-datasource.properties")
public class TestDbConfig {

    //    @Autowired
    //    Environment environment;
    //
    //    @Bean
    //    public DataSource dataSource() {
    //        DriverManagerDataSource ds = new DriverManagerDataSource();
    //        ds.setDriverClassName(environment.getProperty("db.driverClassName"));
    //        ds.setUrl(environment.getProperty("db.url"));
    //        ds.setUsername(environment.getProperty("db.username"));
    //        ds.setPassword(environment.getProperty("db.password"));
    //        DatabasePopulatorUtils.execute(databasePopulator(), ds);
    //        return ds;
    //    }
    //
    //    @Value("classpath:db/schema.sql")
    //    private Resource schemaScript;
    //
    //    @Value("classpath:db/test-data.sql")
    //    private Resource dataScript;
    //
    //    private DatabasePopulator databasePopulator() {
    //        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    //        populator.addScript(schemaScript);
    //        populator.addScript(dataScript);
    //        return populator;
    //    }


    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:db/schema.sql")
                .addScript("classpath:db/test-data.sql").build();
    }

}
