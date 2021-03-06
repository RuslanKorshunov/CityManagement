package by.resliv.citymanagement.main;

import by.resliv.citymanagement.bot.CityGuideBot;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:persistence.properties")
@ComponentScan(basePackages = {"by.resliv.citymanagement.controller",
        "by.resliv.citymanagement.dao",
        "by.resliv.citymanagement.service",
        "by.resliv.citymanagement.validator"
})
public class Main {
    private static final String URL;
    private static final String USER;
    private static final String DRIVER;
    private static final String PASSWORD;
    private static final String HDM2DDL_AUTO;
    private static final String SHOW_SQL;
    private static final String DIALECT;
    private static final String TELEGRAM_NAME;
    private static final String TELEGRAM_TOKEN;
    private static final String ENTITY_PACKAGE;

    static {
        URL = "javax.persistence.jdbc.url";
        USER = "javax.persistence.jdbc.user";
        DRIVER = "javax.persistence.jdbc.driver";
        PASSWORD = "javax.persistence.jdbc.password";
        HDM2DDL_AUTO = "hibernate.hbm2ddl.auto";
        SHOW_SQL = "hibernate.show_sql";
        DIALECT = "hibernate.dialect";
        TELEGRAM_NAME = "telegram.name";
        TELEGRAM_TOKEN = "telegram.token";
        ENTITY_PACKAGE = "by.resliv.citymanagement.entity";
    }

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(environment.getProperty(URL));
        hikariDataSource.setUsername(environment.getProperty(USER));
        hikariDataSource.setPassword(environment.getProperty(PASSWORD));
        hikariDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return hikariDataSource;
    }

    @Bean
    public HibernateJpaVendorAdapter getHibernateJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(ENTITY_PACKAGE);
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setJpaProperties(getProperties());
        return factoryBean;
    }

    @Bean
    public EntityManager getEntityManager(LocalContainerEntityManagerFactoryBean factoryBean) {
        EntityManager entityManager = factoryBean.getNativeEntityManagerFactory().createEntityManager();
        entityManager.setFlushMode(FlushModeType.COMMIT);
        return entityManager;
    }

    @Bean
    public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public TelegramBotsApi getTelegramBotsApi() {
        return new TelegramBotsApi();
    }

    @Bean
    public CityGuideBot getCityGuideBot(TelegramBotsApi api) throws TelegramApiRequestException {
        String name = environment.getProperty(TELEGRAM_NAME);
        String token = environment.getProperty(TELEGRAM_TOKEN);
        CityGuideBot bot = new CityGuideBot(name, token);
        api.registerBot(bot);
        return bot;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put(HDM2DDL_AUTO, environment.getProperty(HDM2DDL_AUTO));
        properties.put(SHOW_SQL, environment.getProperty(SHOW_SQL));
        properties.put(DIALECT, environment.getProperty(DIALECT));
        return properties;
    }
}
