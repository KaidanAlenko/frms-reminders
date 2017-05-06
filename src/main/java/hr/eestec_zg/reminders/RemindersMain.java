package hr.eestec_zg.reminders;

import hr.eestec_zg.frmscore.config.CoreConfig;
import hr.eestec_zg.frmscore.domain.models.TaskStatus;
import hr.eestec_zg.frmscore.services.CompanyService;
import hr.eestec_zg.frmscore.services.EventService;
import hr.eestec_zg.frmscore.services.TaskService;
import hr.eestec_zg.frmscore.services.UserService;
import hr.eestec_zg.reminders.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RemindersMain {
    private static final Logger logger = LoggerFactory.getLogger(RemindersMain.class);

    public static void main(String[] args) {
        logger.info("Starting...");

        if (System.getProperty("spring.profiles.active") == null) {
            System.setProperty("spring.profiles.active", "production");
        }

        // Starting Spring Application context
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                AppConfig.class, CoreConfig.class);

        UserService userService = ctx.getBean(UserService.class); // the way of getting object instances from Spring
        userService
                .getAllUsers()
                .forEach(System.out::println);

        TaskService taskService = ctx.getBean(TaskService.class);
        taskService.getTaskByStatus(TaskStatus.ACCEPTED);

        CompanyService companyService = ctx.getBean(CompanyService.class);
        companyService.getCompanies()
                .forEach(System.out::println);

        EventService eventService = ctx.getBean(EventService.class);
        eventService.getEvents()
                .forEach(System.out::println);

        ctx.close(); // you should always close context in the end

        logger.info("Finishing...");
    }

}
