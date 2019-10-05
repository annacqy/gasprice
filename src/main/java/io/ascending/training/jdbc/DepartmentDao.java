package io.ascending.training.jdbc;

import io.ascending.training.model.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.1.7.25
public class DepartmentDao {
    //step1 database information
    static final String DB_URL ="jdbc:postgresql://localhost:5431/gas";
    static final String USER = "admin";
    static final String PASS = "password";


    public List<Department> getDepartments(){
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;
        List<Department> departments = new ArrayList();
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM department";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                departments.add(department);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return departments;
    }
    //get Department a primary ID
    public boolean save(Department dep){
        Connection conn = null;
        Statement stmt = null;
        try {
            logger.debug("Continue to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creqting Statement...");
            stmt = conn.createStatement();
            String sql = "insert into department (name, description) values" + "('" + dep.getName() + "','" + dep.getDescription() + "')";
            int i = stmt.executeUpdate(sql);
            if (i==1) {
                System.out.println("Created new record.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }  catch (SQLException se){
                se.printStackTrace();
            }
        }
        return false;
    }
}
