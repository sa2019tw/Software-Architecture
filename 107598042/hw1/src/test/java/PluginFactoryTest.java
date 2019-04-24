import Domain.CourseBase;
import Gateway.InMemoryCourseBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class PluginFactoryTest {

    @Test
    public void getPlugin() {
        CourseBase courseBase = (CourseBase)PluginFactory.getPlugin(CourseBase.class);
        assertTrue(courseBase instanceof InMemoryCourseBase);
    }

}