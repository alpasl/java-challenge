package jp.co.axa.apidemo.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl service;
    
    @Mock
    private EmployeeRepository repository;
	
    @Test
	public void testGetEmployee_null() {
    	Employee employee = service.getEmployee(null);
    	assertNull(employee);
	}
    
    @Test
	public void testGetEmployee_valid() {
    	// Prepare
    	Employee expected = Employee.builder().id(1L).name("Loraine Alpas").salary(100).department("HR").build();
    	when(repository.findById(1L)).thenReturn(Optional.of(expected));
    	
    	// Call method
    	Employee employee = service.getEmployee(1L);
    	
    	// Assert
    	assertNotNull(employee);
    	assertEquals(employee.getId().longValue(), 1L);
	}
    
    // Other methods has no custom logic, so there's no need to add unit test for now

}
