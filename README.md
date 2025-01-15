package com.employeemanagment;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class EmployeeManagementSystem extends JFrame {
	private ArrayList<Employee> employees = new ArrayList<>();

    private JTextField idField, nameField, emailField, salaryField, departmentField;
    private JComboBox<String> genderComboBox;
    private JTextArea displayArea;

    public EmployeeManagementSystem() {
        setTitle("Employee Management System");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        // Input fields
        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        salaryField = new JTextField();
        
        // Gender options
        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        
        departmentField = new JTextField();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        
        inputPanel.add(new JLabel("Salary:"));
        inputPanel.add(salaryField);
        
        inputPanel.add(new JLabel("Gender:"));
        inputPanel.add(genderComboBox);
        
        inputPanel.add(new JLabel("Department:"));
        inputPanel.add(departmentField);

        // Buttons
        JButton addButton = new JButton("Add Employee");
        JButton viewButton = new JButton("View Employees");
        JButton deleteButton = new JButton("Delete Employee");

        // Display area
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(displayArea);

       
        add(inputPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        
        add(buttonPanel, BorderLayout.CENTER);
        
        add(scrollPane, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEmployees();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });
        
         // Set a background color for the JFrame
         getContentPane().setBackground(Color.LIGHT_GRAY);
         setFontStyles();

         // Center the window on the screen
         setLocationRelativeTo(null);
         
         setVisible(true);
     }

     private void setFontStyles() {
         Font font = new Font("Arial", Font.PLAIN, 14);
         for (Component component : getContentPane().getComponents()) {
             if (component instanceof JPanel) {
                 for (Component inner : ((JPanel) component).getComponents()) {
                     inner.setFont(font);
                 }
             } else if (component instanceof JTextArea) {
                 component.setFont(font);
             }
         }
     }

     private void addEmployee() {
         try {
             int id = Integer.parseInt(idField.getText());
             String name = nameField.getText();
             String email = emailField.getText();
             double salary = Double.parseDouble(salaryField.getText());
             String gender = (String) genderComboBox.getSelectedItem();
             String department = departmentField.getText();

             employees.add(new Employee(id, name, email, salary, gender, department));
             JOptionPane.showMessageDialog(this, "Employee added successfully!");
             clearFields();
         } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "Please enter valid ID and Salary.");
         }
     }

     private void viewEmployees() {
         displayArea.setText("");
         for (Employee emp : employees) {
             displayArea.append(emp.toString() + "\n");
         }
     }

     private void deleteEmployee() {
         try {
             int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Employee ID to delete:"));
             employees.removeIf(emp -> emp.getId() == id);
             JOptionPane.showMessageDialog(this, "Employee deleted successfully!");
             viewEmployees();
         } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "Please enter a valid ID.");
         }
     }

     private void clearFields() {
         idField.setText("");
         nameField.setText("");
         emailField.setText("");
         salaryField.setText("");
         genderComboBox.setSelectedIndex(0);  // Reset to first option
         departmentField.setText("");
     }

     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> new EmployeeManagementSystem());
     }
}

------------------------------------------------------------------------------------------
package com.employeemanagment;

public class Employee {
	 private int id;
	    private String name;
	    private String email;
	    private double salary;
	    private String gender;
	    private String department;

	    public Employee(int id, String name, String email, double salary, String gender, String department) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.salary = salary;
	        this.gender = gender;
	        this.department = department;
	    }

	    // Getters
	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    @Override
	    public String toString() {
	        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Salary: " + salary +
	               ", Gender: " + gender + ", Department: " + department;
	    }
}
