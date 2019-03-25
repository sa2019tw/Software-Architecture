package entity.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import entity.Course;
import org.dbunit.Assertion;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.*;
import org.dbunit.dataset.filter.IRowFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CourseDaoTest {
    private static MysqlDataSource dataSource;
    private static IDatabaseConnection dbConn;
    private CourseDao dao;
    private final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources/";
    private final String DATASET = "dataset.xml";
    private final int DEFAULT_NUMBER_OF_DATA = 3;
    private final String TARGET_TABLE_NAME = "course";

    @BeforeClass
    public static void setUpClass() throws Exception {
        dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_course_system");
        dataSource.setUser("admin");
        dataSource.setPassword("admin");
        dbConn = new MySqlConnection(dataSource.getConnection(), "test_course_system");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (dbConn != null)
            dbConn.close();
    }

    @Before
    public void setUp() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getXmlDataSet(DATASET));
        dao = new CourseDao(dataSource);
    }

    private IDataSet getXmlDataSet(String filename) throws DataSetException, IOException {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        return builder.build(new FileInputStream(new File(RESOURCE_PATH + filename)));
    }

    private Course mapSpecificRowToObject(ITable table, int row) throws DataSetException{
        Course course = new Course();
        course.setId(((BigInteger) table.getValue(row, "id")).intValue());
        course.setTitle((String) table.getValue(row, "title"));
        course.setDescription((String) table.getValue(row, "description"));
        course.setSuitablePeople((String) table.getValue(row, "suitable_people"));
        course.setPrice((Integer) table.getValue(row, "price"));
        course.setAnnouncement((String) table.getValue(row, "announcement"));
        course.setRemark((String) table.getValue(row, "remark"));
        return course;
    }

    private List<Course> mapTableToList(ITable table) throws DataSetException{
        List<Course> courses = new ArrayList<>();
        int rows = table.getRowCount();
        for (int i = 0; i < rows; i++)
            courses.add(mapSpecificRowToObject(table, i));
        return courses;
    }

    private ITable getSpecificTable(String tableName) throws SQLException, DataSetException{
        IDataSet dataSet = dbConn.createDataSet(new String[] {tableName});
        return dataSet.getTable(tableName);
    }

    private void assertTableNotChanged() {
        try {
            ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);

            IDataSet expectedDataSet = getXmlDataSet(DATASET);
            ITable expectedTable = expectedDataSet.getTable(TARGET_TABLE_NAME);

            Assertion.assertEquals(expectedTable, actualTable);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void dbUnitSelfTest() throws Exception {
        assertTableNotChanged();
    }

    @Test
    public void addCourseWithFullFormat() throws Exception {
        Course newCourse = new Course();
        newCourse.setTitle("ooad");
        newCourse.setDescription("ooad description");
        newCourse.setSuitablePeople("ooad suitable people");
        newCourse.setPrice(10000);
        newCourse.setAnnouncement("ooad announcement");
        newCourse.setRemark("ooad remark");
        dao.addCourse(newCourse);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        assertEquals(DEFAULT_NUMBER_OF_DATA + 1, actualTable.getRowCount());

        Course actualCourse = mapSpecificRowToObject(actualTable, actualTable.getRowCount() - 1);
        assertEquals(newCourse, actualCourse);
    }

    @Test
    public void addCourseWithPartialNullAttribute() throws SQLException, DataSetException {
        Course newCourse = new Course();
        newCourse.setTitle("ooad");
        dao.addCourse(newCourse);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        assertEquals(DEFAULT_NUMBER_OF_DATA + 1, actualTable.getRowCount());

        Course actualCourse = mapSpecificRowToObject(actualTable, actualTable.getRowCount() - 1);
        assertEquals(newCourse, actualCourse);
    }

    @Test
    public void addCourseWithNullForNotNullAttribute() {
        Course newCourse = new Course();
        newCourse.setDescription("ooad description");
        newCourse.setSuitablePeople("ooad suitable people");
        newCourse.setPrice(10000);
        newCourse.setAnnouncement("ooad announcement");
        newCourse.setRemark("ooad remark");
        dao.addCourse(newCourse);

        assertTableNotChanged();
    }

    @Test
    public void deleteExistingCourse() throws SQLException, DataSetException {
        dao.deleteCourse(1);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);

        IRowFilter rowFilter = new IRowFilter() {
            @Override
            public boolean accept(IRowValueProvider rowValueProvider) {
                Object columnValue = null;
                try {
                    columnValue = rowValueProvider.getColumnValue("id");
                } catch (DataSetException e) {
                    e.printStackTrace();
                }
                return columnValue != null && ((BigInteger) columnValue).intValue() == 1;
            }
        };
        RowFilterTable rowFilterTable = new RowFilterTable(actualTable, rowFilter);
        assertEquals(0, rowFilterTable.getRowCount());
    }

    @Test
    public void deleteNotExistingCourse() throws SQLException, DataSetException {
        dao.deleteCourse(100);

        assertTableNotChanged();
    }

    @Test
    public void updateExistingCourse() throws SQLException, DataSetException {
        Course editCourse = new Course();
        editCourse.setId(1);
        editCourse.setTitle("ooad");
        editCourse.setDescription("ooad description");
        editCourse.setSuitablePeople("ooad suitable people");
        editCourse.setPrice(10000);
        editCourse.setAnnouncement("ooad announcement");
        editCourse.setRemark("ooad remark");
        dao.updateCourse(editCourse);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        assertEquals(DEFAULT_NUMBER_OF_DATA, actualTable.getRowCount());

        Course actualCourse = mapSpecificRowToObject(actualTable, 0);
        assertEquals(editCourse, actualCourse);
    }

    @Test
    public void updateNotExistingCourse() {
        Course editCourse = new Course();
        editCourse.setId(100);
        editCourse.setTitle("ooad");
        editCourse.setDescription("ooad description");
        editCourse.setSuitablePeople("ooad suitable people");
        editCourse.setPrice(10000);
        editCourse.setAnnouncement("ooad announcement");
        editCourse.setRemark("ooad remark");
        dao.updateCourse(editCourse);

        assertTableNotChanged();
    }

    @Test
    public void updateExistCourseWithNullOnNullableAttributes() throws SQLException, DataSetException {
        Course editCourse = new Course();
        editCourse.setId(1);
        editCourse.setTitle("ooad");
        dao.updateCourse(editCourse);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        Course actualCourse = mapSpecificRowToObject(actualTable, 0);
        assertEquals(editCourse, actualCourse);
    }

    @Test
    public void updateExistCourseWithNullOnNotNullAttribute() {
        Course editCourse = new Course();
        editCourse.setId(100);
        editCourse.setDescription("ooad description");
        editCourse.setSuitablePeople("ooad suitable people");
        editCourse.setPrice(10000);
        editCourse.setAnnouncement("ooad announcement");
        editCourse.setRemark("ooad remark");
        dao.updateCourse(editCourse);

        assertTableNotChanged();
    }

    @Test
    public void getAllCourses() throws SQLException, DataSetException {
        List<Course> result = dao.getAllCourses();

        assertEquals(DEFAULT_NUMBER_OF_DATA, result.size());

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        List<Course> expected = mapTableToList(actualTable);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void getCourseByExistId() throws IOException, DataSetException {
        Optional<Course> result = dao.getCourseById(1);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId().intValue());
    }

    @Test
    public void getCourseByNotExistId() throws IOException, DataSetException {
        Optional<Course> result = dao.getCourseById(100);
        Assert.assertFalse(result.isPresent());
    }
}
