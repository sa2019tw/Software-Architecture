package infrastructure.repository;

import com.mysql.cj.jdbc.MysqlDataSource;
import core.entity.Course;
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

public class MysqlCourseRepositoryTest {
    private static MysqlDataSource dataSource;
    private static IDatabaseConnection dbConn;
    private MysqlCourseRepository courseRepository;
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
        courseRepository = new MysqlCourseRepository(dataSource);
    }

    private IDataSet getXmlDataSet(String filename) throws DataSetException, IOException {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        return builder.build(new FileInputStream(new File(RESOURCE_PATH + filename)));
    }

    private Course mapSpecificRowToObject(ITable table, int row) throws DataSetException{
        return new Course.Builder((String) table.getValue(row, "title"))
                .id(((BigInteger) table.getValue(row, "id")).intValue())
                .description((String) table.getValue(row, "description"))
                .suitablePeople((String) table.getValue(row, "suitable_people"))
                .price((Integer) table.getValue(row, "price"))
                .announcement((String) table.getValue(row, "announcement"))
                .remark((String) table.getValue(row, "remark"))
                .build();
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
        Course newCourse = new Course.Builder("ooad")
                .description("ooad description")
                .suitablePeople("ooad suitable people")
                .price(10000)
                .announcement("ooad announcement")
                .remark("ooad remark")
                .build();

        int id = courseRepository.addCourse(newCourse);
        assertTrue(id > DEFAULT_NUMBER_OF_DATA);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        assertEquals(DEFAULT_NUMBER_OF_DATA + 1, actualTable.getRowCount());

        Course actualCourse = mapSpecificRowToObject(actualTable, actualTable.getRowCount() - 1);
        assertEquals(newCourse, actualCourse);
    }

    @Test
    public void addCourseWithPartialNullAttribute() throws SQLException, DataSetException {
        Course newCourse = new Course.Builder("ooad").build();
        int id = courseRepository.addCourse(newCourse);

        assertTrue(id > DEFAULT_NUMBER_OF_DATA);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        assertEquals(DEFAULT_NUMBER_OF_DATA + 1, actualTable.getRowCount());

        Course actualCourse = mapSpecificRowToObject(actualTable, actualTable.getRowCount() - 1);
        assertEquals(newCourse, actualCourse);
    }

    @Test
    public void deleteExistingCourse() throws SQLException, DataSetException {
        courseRepository.deleteCourse(new Course.Builder("").id(1).build());

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
        courseRepository.deleteCourse(new Course.Builder("").id(10000).build());

        assertTableNotChanged();
    }

    @Test
    public void updateExistingCourse() throws SQLException, DataSetException {
        Course editCourse = new Course.Builder("ooad")
                .id(1)
                .description("ooad description")
                .suitablePeople("ooad suitable people")
                .price(10000)
                .announcement("ooad announcement")
                .remark("ooad remark")
                .build();
        courseRepository.updateCourse(editCourse);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        assertEquals(DEFAULT_NUMBER_OF_DATA, actualTable.getRowCount());

        Course actualCourse = mapSpecificRowToObject(actualTable, 0);
        assertEquals(editCourse, actualCourse);
    }

    @Test
    public void updateNotExistingCourse() {
        Course editCourse = new Course.Builder("ooad")
                .id(100000)
                .description("ooad description")
                .suitablePeople("ooad suitable people")
                .price(10000)
                .announcement("ooad announcement")
                .remark("ooad remark")
                .build();
        courseRepository.updateCourse(editCourse);

        assertTableNotChanged();
    }

    @Test
    public void updateExistCourseWithNullOnNullableAttributes() throws SQLException, DataSetException {
        Course editCourse = new Course.Builder("ooad").id(1).build();
        courseRepository.updateCourse(editCourse);

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        Course actualCourse = mapSpecificRowToObject(actualTable, 0);
        assertEquals(editCourse, actualCourse);
    }

    @Test
    public void getAllCourses() throws SQLException, DataSetException {
        List<Course> result = courseRepository.getAllCourse();

        assertEquals(DEFAULT_NUMBER_OF_DATA, result.size());

        ITable actualTable = getSpecificTable(TARGET_TABLE_NAME);
        List<Course> expected = mapTableToList(actualTable);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void getCourseByExistId() {
        Optional<Course> result = courseRepository.getCourseById(1);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId().intValue());
    }

    @Test
    public void getCourseByNotExistId() {
        Optional<Course> result = courseRepository.getCourseById(100);
        Assert.assertFalse(result.isPresent());
    }
}
