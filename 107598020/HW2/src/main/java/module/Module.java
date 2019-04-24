package module;

import com.google.inject.AbstractModule;
import database.SqlLiteAdapter;
import database.SqlLiteConfiguration;
import usecase.CourseDao;
import usecase.courseCommandFactory.CourseCommandFactory;
import usecase.courseCommandFactory.CourseCommandFactoryImp;

import java.util.Properties;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(Properties.class).toInstance(new SqlLiteConfiguration().getDatabaseProperties());
        bind(CourseDao.class).to(SqlLiteAdapter.class);
        bind(CourseCommandFactory.class).to(CourseCommandFactoryImp.class);
    }
}
