package core.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {
    @Test
    public void buildNormalCourse() {
        Course course = new Course.Builder("title")
                .id(1)
                .description("description")
                .suitablePeople("suitable people")
                .price(10000)
                .announcement("announcement")
                .remark("remark")
                .build();
        assertEquals("title", course.getTitle());
        assertEquals(1, course.getId().intValue());
        assertEquals("description", course.getDescription());
        assertEquals("suitable people", course.getSuitablePeople());
        assertEquals(10000, course.getPrice().intValue());
        assertEquals("announcement", course.getAnnouncement());
        assertEquals("remark", course.getRemark());
    }

    @Test (expected = NullPointerException.class)
    public void buildWithNullTitle() {
        new Course.Builder(null);
    }
}