package dao;

import model.Employee;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    public void addEmployee(Employee emp) {
        System.out.println("***** DAO METHOD CALLED *****");
        Connection con = DBConnection.getConnection();
        String sql = "insert into employee values(?,?,?,?,?,?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getEmployeeId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.setInt(4, emp.getSalary());
            ps.setString(5, emp.getEmail());
            ps.setString(6, emp.getPhno());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee added successfully");
            } else {
                System.out.println("No employee added");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void displayEmployees() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from employee";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int employeeId = rs.getInt("employeeId");
                String name = rs.getString("name");
                String department = rs.getString("department");
                int salary = rs.getInt("salary");
                String email = rs.getString("email");
                String phno = rs.getString("phno");

                System.out.println(
                        employeeId + " " +
                                name + " " +
                                department + " " +
                                salary + " " +
                                email + " " +
                                phno);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchEmployee(int employeeId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from employee where employeeId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                employeeId = rs.getInt("employeeId");
                String name = rs.getString("name");
                String department = rs.getString("department");
                int salary = rs.getInt("salary");
                String email = rs.getString("email");
                String phno = rs.getString("phno");

                System.out.println(
                        employeeId + " " +
                                name + " " +
                                department + " " +
                                salary + " " +
                                email + " " +
                                phno);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee emp) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE employee SET name = ?, department =?, salary = ?, email = ?,phno = ? WHERE employeeId = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setInt(3, emp.getSalary());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getPhno());
            ps.setInt(6, emp.getEmployeeId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee updated successfully");
            } else {
                System.out.println("No employee found");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteEmployee(int employeeId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from employee where employeeId=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, employeeId);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("No employee found");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sortEmployee(String columnName) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM employee ORDER BY " + columnName;
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int employeeId = rs.getInt("employeeId");
                String name = rs.getString("name");
                String department = rs.getString("department");
                int salary = rs.getInt("salary");
                String email = rs.getString("email");
                String phno = rs.getString("phno");

                System.out.println(
                        employeeId + " " +
                                name + " " +
                                department + " " +
                                salary + " " +
                                email + " " +
                                phno);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void filterEmployee(String filterType, String value) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "";

            if (filterType.equals("department")) {
                sql = "SELECT * FROM employee WHERE department = ?";
            } else if (filterType.equals("salary>")) {
                sql = "SELECT * FROM employee WHERE salary > ?";
            } else if (filterType.equals("salary<")) {
                sql = "SELECT * FROM employee WHERE salary < ?";
            }

            PreparedStatement ps = con.prepareStatement(sql);

            if (filterType.equals("department")) {
                ps.setString(1, value);
            } else {
                ps.setInt(1, Integer.parseInt(value));
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int employeeId = rs.getInt("employeeId");
                String name = rs.getString("name");
                String department = rs.getString("department");
                int salary = rs.getInt("salary");
                String email = rs.getString("email");
                String phno = rs.getString("phno");

                System.out.println(
                        employeeId + " " +
                                name + " " +
                                department + " " +
                                salary + " " +
                                email + " " +
                                phno);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
