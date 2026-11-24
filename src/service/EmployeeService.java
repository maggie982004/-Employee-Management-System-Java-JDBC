package service;

import model.Employee;
import dao.EmployeeDAO;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();

    public void addEmployee(Employee employee) {
        dao.addEmployee(employee);

    }

    public void displayEmployees() {
        dao.displayEmployees();
    }

    public void searchEmployeeId(int employeeId) {
        dao.searchEmployee(employeeId);

    }

    public void updateEmployee(Employee emp) {
        dao.updateEmployee(emp);
    }

    public void deleteEmployee(int employeeId) {
        dao.deleteEmployee(employeeId);

    }

    public void sortEmployee(String columnName) {
        dao.sortEmployee(columnName);
    }

    public void filterEmployee(String filterType, String value) {
        dao.filterEmployee(filterType, value);
    }
}

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Comparator;
// import java.util.Collections;
// import java.util.ArrayList;
// ArrayList<Employee> employees = new ArrayList<>();

// employees.add(employee);
// saveEmployees();

// if (employees.isEmpty()) {
// System.out.println("No employees found.");
// } else {
// for (Employee emp : employees) {
// System.out.println(emp);
// }
// }

// }

// boolean found = false;
// for (Employee emp : employees) {

// if (emp.getEmployeeId() == employeeId) {
// found = true;
// System.out.println(emp);
// System.out.println("found Employee");
// break;
// }
// }
// if (!found) {
// System.out.println("Not found");
// }

// boolean found = false;
// for (Employee emp : employees) {
// if (emp.getEmployeeId() == employeeId) {
// emp.setName(name);
// emp.setDepartment(department);
// emp.setEmail(email);
// emp.setSalary(salary);
// emp.setPhno(phno);
// found = true;
// saveEmployees();
// break;

// }
// }
// if (!found) {
// System.out.println("Not found");
// }

// boolean found = false;
// for (Employee emp : employees) {
// if (emp.getEmployeeId() == employeeId) {
// employees.remove(emp);
// found = true;
// saveEmployees();

// break;
// }
// }
// if (!found) {
// System.out.println("Not found");
// }
// }

// public void sortBySalary() { SORTING USING ARRAYLIST
// Collections.sort(employees, new Comparator<Employee>() {
// @Override
// public int compare(Employee e1, Employee e2) {
// return e1.getSalary() - e2.getSalary();
// }
// });
// displayEmployees();
// }

// public void sortById() {
// dao.sortEmployeeById();
// // Collections.sort(employees, new Comparator<Employee>() {
// // @Override
// // public int compare(Employee e1, Employee e2) {
// // return e1.getEmployeeId() - e2.getEmployeeId();
// // }

// // });
// // displayEmployees();

// }

// public void sortByName() {
// Collections.sort(employees, new Comparator<Employee>() {
// @Override
// public int compare(Employee e1, Employee e2) {
// return e1.getName().compareTo(e2.getName());
// }

// });
// displayEmployees();

// }
// public void saveEmployees() { ALL THESE ARE USED FOR ARRAYLIST BEFORE JDBC
// try {
// BufferedWriter bw = new BufferedWriter(new FileWriter("employee.txt"));
// for (Employee emp : employees) {
// String data = emp.getEmployeeId() + "," + emp.getName() + "," +
// emp.getDepartment() + ","
// + emp.getEmail() + "," + emp.getSalary() + "," + emp.getPhno();
// bw.write(data);
// bw.newLine();

// }
// bw.close();
// } catch (IOException e) {
// System.out.println("Error saving employees: " + e.getMessage());
// }
// }

// public void loadEmployees() {
// try {
// BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
// String line;

// while ((line = br.readLine()) != null) {
// String[] parts = line.split(",");
// Employee emp = new Employee(Integer.parseInt(parts[0]), parts[1], parts[2],
// parts[3],
// Integer.parseInt(parts[4]), parts[5]);
// employees.add(emp);
// }

// br.close();

// } catch (IOException e) {
// System.out.println("Error loading employees.");
// }
// }

// public void filterByDepartment(String department) {
// boolean found = false;
// for (Employee emp : employees) {
// if (emp.getDepartment().equalsIgnoreCase(department)) {
// System.out.println(emp);
// found = true;
// }

// }
// if (!found) {
// System.out.println("No match");
// }

// }

// public void filterBysalary(int salary) {
// boolean found = false;
// for (Employee emp : employees) {
// if (emp.getSalary() >= salary) {
// System.out.println(emp);
// found = true;
// }

// }
// if (!found) {
// System.out.println("No match");
// }

// }
