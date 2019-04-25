package springConfig;

import core.boundary.require.ICourseRepository;
import infrastructure.repository.RepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"delivery", "application", "core"})
public class AppConfig {
    @Bean
    public ICourseRepository courseRepository() {
        return new RepositoryFactory().createCourseRepository();
    }

//    @Bean
//    public ICourseRepository InMemoryRepository() {
//        return new InMemoryCourseRepository();
//    }
}
