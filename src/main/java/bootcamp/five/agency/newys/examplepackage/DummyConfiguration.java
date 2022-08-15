package bootcamp.five.agency.newys.examplepackage;


import java.util.Properties;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
@Configuration
@ComponentScan(basePackages = {"bootcamp.five.agency.newys"})
@EnableTransactionManagement
public class DummyConfiguration {

  @Value("spring.datasource.username")
  private String username;
  @Value("spring.datasource.password")
  private String password;
  @Value("spring.datasource.driver-class-name")
  private String driver;
  @Value("spring.datasource.url")
  private String url;

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    jpaProperties.setProperty("hibernate.showSql", "false");

    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(getDataSource());
    em.setPersistenceUnitName("entityManagerFactory");
    em.setPackagesToScan("bootcamp.five.agency.newys");
    em.setJpaVendorAdapter(vendorAdapter);
    em.setJpaProperties(jpaProperties);
    em.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);

    return em;
  }
}*/

// OR, instead of all this - just configure spring.datasource.* properties and
// Spring Boot auto-configures everything else!
// We save those properties in DataSourceProperties