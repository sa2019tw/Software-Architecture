package usecase.testObject;

import com.google.inject.AbstractModule;
import usecase.courseCommandFactory.CourseCommandFactory;
import usecase.courseCommandFactory.CourseCommandFactoryImp;
import usecase.CourseDao;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CourseDao.class).to(InMemoryDatabase.class);
        bind(CourseCommandFactory.class).to(CourseCommandFactoryImp.class);
    }
}
