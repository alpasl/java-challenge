package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

/**
 * Class that holds the business logic related to employee operations
 */
public interface EmployeeService {

	/**
	 * Get all employee records
	 */
    public List<Employee> retrieveEmployees();
    
    /**
	 * Get employee record by employee ID
	 */
    public Employee getEmployee(Long employeeId);
    
    /**
	 * Register the employee if it doesn't exist, otherwise, update the employee record
	 */
    public void saveEmployee(Employee employee);

    
    /**
     * Delete the employee record
     */
    public void deleteEmployee(Long employeeId);

    
    /**
     * Update the employee record
     */
    public void updateEmployee(Long employeeId, Employee employee);
}