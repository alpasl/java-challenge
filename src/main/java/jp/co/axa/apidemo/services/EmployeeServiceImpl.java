package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> retrieveEmployees() {
    	return employeeRepository.findAll();
    }

    public Employee getEmployee(Long employeeId) {
    	// check if employeeId is not null so that IllegalArgumentException won't be thrown
    	if (null == employeeId) {
    		return null;
    	}
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }
    
    public void updateEmployee(Long id, Employee employee) {
    	if (getEmployee(id) != null) {
            employeeRepository.save(employee);
    	}
    }
}