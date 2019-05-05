package journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author Evgeniy Ukhanov
 */


@SpringBootApplication
@EntityScan(basePackageClasses = {
        JournalApplication.class,

        // Регистрируем конвертер JPA 2.1, чтобы все поля даты / времени Java 8 в моделях домена автоматически
        // преобразовывались в типы SQL, когда мы их будем сохранять в базе данных.
        Jsr310JpaConverters.class
})
public class JournalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
		SpringApplication.run(applicationClass, args);
    }


    @PostConstruct
    void init() {
        // Установим часовой пояс по умолчанию для нашего приложения на UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
    }

	private static Class<JournalApplication> applicationClass = JournalApplication.class;

}