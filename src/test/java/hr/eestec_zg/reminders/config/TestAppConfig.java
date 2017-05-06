package hr.eestec_zg.reminders.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
@Import(value = {AppConfig.class})
public class TestAppConfig {
}
