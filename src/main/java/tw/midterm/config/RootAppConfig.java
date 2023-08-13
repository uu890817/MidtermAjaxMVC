package tw.midterm.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "tw.midterm")
@EnableTransactionManagement
public class RootAppConfig {

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=Midterm;encrypt=true;trustServerCertificate=true");
		dataSource.setUsername("user");
		dataSource.setPassword("1234");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("tw.midterm");
		factory.setHibernateProperties(addtionalProperties());
		return factory;
	}

	private Properties addtionalProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
		// props.put("hibernate.dialect", org.hibernate.dialect.MySQLDialect.class);
		props.put("hibernate.allow_update_outside_transaction", Boolean.TRUE);
		props.put("hibernate.show_sql", Boolean.TRUE);
		props.put("hibernate.format_sql", Boolean.TRUE);
		return props;
	}

	@Bean
	public HibernateTransactionManager transactionManager() throws IllegalArgumentException, NamingException {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionFactory().getObject());
		return txMgr;
	}

}
