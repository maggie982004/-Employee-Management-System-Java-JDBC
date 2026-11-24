package main;

import model.Employee;
import service.EmployeeService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        int choice = 0;
        while (choice != 8) {
            try {
                System.out.println(" ========== Employee Management System ==========");

                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3.Search Employee");
                System.out.println("4. Update Employee");
                System.out.println("5. Delete Employee");
                System.out.println("6.sort employee");
                System.out.println("7.filter employee");
                System.out.println("8. Exit");
                System.out.println("Enter your choice:");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.println("Enter employeeId:+");
                        int employeeId = sc.nextInt();
                        if (employeeId <= 0) {
                            System.out.println("id should greater than 0");
                            continue;
                        }
                        sc.nextLine();

                        System.out.println("Enter name:+");
                        String name = sc.nextLine();
                        if (name.trim().isEmpty()) {
                            System.out.println("Enter name properly");
                            continue;
                        }

                        System.out.println("Enter department+:");
                        String department = sc.nextLine();
                        if (department.trim().isEmpty()) {
                            System.out.println("Enter correct department");
                            continue;
                        }

                        System.out.println("Enter salary:");
                        int salary = sc.nextInt();
                        if (salary <= 0) {
                            System.out.println("salary should not be negative");
                            continue;
                        }
                        sc.nextLine();

                        System.out.println("Enter email:");
                        String email = sc.nextLine();
                        if ((email.trim().isEmpty()) || (!email.contains("@")) || (!email.contains("."))) {
                            System.out.println("Invalid email, please make this charactercs contain");
                            continue;
                        }

                        System.out.println("Enter phone:");
                        String phno = sc.nextLine();
                        if ((phno.trim().isEmpty()) || (phno.length() != 10) || (!phno.matches("[0-9]{10}"))) {
                            System.out.println("Invalid phone no");
                            continue;
                        }
                        Employee emp = new Employee(employeeId, name, department, email, salary, phno);

                        service.addEmployee(emp);

                        break;

                    }
                    case 2:
                        service.displayEmployees();
                        break;
                    case 3: {
                        System.out.println("Enter employeeId:");
                        int employeeId = sc.nextInt();
                        if (employeeId <= 0) {
                            System.out.println("Employee ID must be greater than 0.");
                            continue;
                        }

                        service.searchEmployeeId(employeeId);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter Employee ID:");
                        int employeeId = sc.nextInt();
                        if (employeeId <= 0) {
                            System.out.println("Employee ID must be greater than 0.");
                            continue;
                        }
                        sc.nextLine();

                        System.out.println("Enter New Name:");
                        String name = sc.nextLine();
                        if (name.trim().isEmpty()) {
                            System.out.println("Enter name properly");
                            continue;
                        }

                        System.out.println("Enter New Department:");
                        String department = sc.nextLine();
                        if (department.trim().isEmpty()) {
                            System.out.println("Enter correct department");
                            continue;
                        }

                        System.out.println("Enter New Salary:");
                        int salary = sc.nextInt();
                        if (salary <= 0) {
                            System.out.println("salary should not be negative");
                            continue;
                        }
                        sc.nextLine();

                        System.out.println("Enter New Email:");
                        String email = sc.nextLine();
                        if ((email.trim().isEmpty()) || (!email.contains("@")) || (!email.contains("."))) {
                            System.out.println("Invalid email, please make this charactercs contain");
                            continue;
                        }

                        System.out.println("Enter New Phone:");
                        String phno = sc.nextLine();
                        if ((phno.trim().isEmpty()) || (phno.length() != 10) || (!phno.matches("[0-9]{10}"))) {
                            System.out.println("Invalid phone no");
                            continue;
                        }

                        Employee emp = new Employee(employeeId, name, department, email, salary, phno);
                        service.updateEmployee(emp);
                        break;
                    }
                    case 5: {
                        System.out.println("Enter employeeId:");
                        int employeeId = sc.nextInt();
                        if (employeeId <= 0) {
                            System.out.println("Employee ID must be greater than 0.");
                            continue;
                        }
                        service.deleteEmployee(employeeId);
                        break;
                    }
                    case 6:
                        int sortChoice = 0;
                        while (sortChoice != 4) {
                            System.out.println("-------Sort Menu-------");
                            System.out.println("1.sort by salary");
                            System.out.println("2.sort by id");
                            System.out.println("3..sort by name");
                            System.out.println("4.back");
                            sortChoice = sc.nextInt();
                            sc.nextLine();

                            switch (sortChoice) {
                                case 1:
                                    service.sortEmployee("salary");
                                    break;
                                case 2:
                                    service.sortEmployee("employeeId");
                                    break;
                                case 3:
                                    service.sortEmployee("name");
                                    break;
                                case 4:
                                    System.out.println("Return to main menu");
                                    break;
                                default:
                                    System.out.println("You have enterd wrong choice");
                            }

                        }
                        break;
                    case 7:
                        int filterChoice = 0;

                        while (filterChoice != 4) {
                            System.out.println("------- Filter Menu -------");
                            System.out.println("1. Filter by Department");
                            System.out.println("2. Salary Greater Than");
                            System.out.println("3. Salary Less Than");
                            System.out.println("4. Back");

                            filterChoice = sc.nextInt();
                            sc.nextLine();

                            switch (filterChoice) {

                                case 1:
                                    System.out.print("Enter Department: ");
                                    String department = sc.nextLine();
                                    service.filterEmployee("department", department);
                                    break;

                                case 2:
                                    System.out.print("Enter Salary: ");
                                    int salary = sc.nextInt();
                                    service.filterEmployee("salary>", String.valueOf(salary));
                                    break;

                                case 3:
                                    System.out.print("Enter Salary: ");
                                    salary = sc.nextInt();
                                    service.filterEmployee("salary<", String.valueOf(salary));
                                    break;

                                case 4:
                                    System.out.println("Returning to Main Menu");
                                    break;

                                default:
                                    System.out.println("Invalid Choice");
                            }
                        }
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("You have entered wrong choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();

            }
        }

    }

}// service.loadEmployees();1
