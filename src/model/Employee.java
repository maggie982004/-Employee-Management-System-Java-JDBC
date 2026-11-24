package model;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private int salary;
    private String phno;

    public Employee() {

    }

    public Employee(int employeeId, String name, String department, String email, int salary, String phno) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
        this.salary = salary;
        this.phno = phno;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", phone='" + phno + '\'' +
                '}';
    }
}