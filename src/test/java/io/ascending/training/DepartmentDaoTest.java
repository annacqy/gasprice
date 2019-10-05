package io.ascending.training;

import io.ascending.training.jdbc.DepartmentDao;
import io.ascending.training.model.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DepartmentDaoTest {
    private DepartmentDao departmentDao;
    private Department testRecord;

//every execution will insert a new data
    @Before
    public void init() {
        departmentDao = new DepartmentDao();
        Department testRecord = new Department();
        testRecord.setName("ascending");
        testRecord.setDescription("offline bootcamp");
        departmentDao.save(testRecord);
    }

    @After
    public void tearDown() {
        departmentDao.delete(testRecord);
    }

    @Test
    public void getDepartmentsTest() {
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumofDept = 1;

//        Assert.assertTrue(1>2);
        Assert.assertEquals(expectedNumofDept,departments.size());
    }
}
