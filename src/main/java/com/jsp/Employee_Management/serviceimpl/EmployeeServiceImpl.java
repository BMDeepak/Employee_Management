package com.jsp.Employee_Management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Employee_Management.dto.EmployeeRequest;
import com.jsp.Employee_Management.dto.EmployeeResponse;
import com.jsp.Employee_Management.exception.EmployeeNotFoundByIdException;
import com.jsp.Employee_Management.model.Employee;
import com.jsp.Employee_Management.repository.EmployeeRepository;
import com.jsp.Employee_Management.service.EmployeeService;
import com.jsp.Employee_Management.util.ResponseStructure;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ResponseStructure<EmployeeResponse> responseStructure;

	@Autowired
	private EmployeeRepository repository;

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		employee.setEmployeeName(employeeRequest.getEmployeeName());
		employee.setEmployeeEmail(employeeRequest.getEmployeeEmail());
		employee.setEmployeePassword(employeeRequest.getEmployeePassword());
		employee.setEmployeePhoneNumber(employeeRequest.getEmployeePhoneNumber());
		employee.setEmployeeSalary(employeeRequest.getEmployeeSalary());
		employee = repository.save(employee);

		EmployeeResponse response = new EmployeeResponse().setEmployeeId(employee.getEmployeeId())
				.setEmployeeName(employee.getEmployeeName()).setEmployeeEmail(employee.getEmployeeEmail())
				.setEmployeePhoneNumber(employee.getEmployeePhoneNumber())
				.setEmployeeSalary(employee.getEmployeeSalary());
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("employee create");
		responseStructure.setData(response);
		return new ResponseEntity<ResponseStructure<EmployeeResponse>>(responseStructure, HttpStatus.CREATED);

	}

	@Override
	public Employee findEmployeebyid(int employeeId) {
		Optional<Employee> optional = repository.findById(employeeId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	@Override
	public List<Employee> findAllEmployee() {
		if ((repository.findAll()) != null) {
			return repository.findAll();
		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> updateEmployee(EmployeeRequest employeeRequest,
			int employeeId) {
		Optional<Employee> optional = repository.findById(employeeId);
		if (optional.isPresent()) {
			Optional<Employee> user = repository.findById(employeeId);
			if (user.isPresent()) {
				Employee emp1 = mapper.map(employeeRequest, Employee.class);
				emp1.setEmployeeId(employeeId);
				Employee employee2 = repository.save(emp1);

				EmployeeResponse response = mapper.map(employee2, EmployeeResponse.class);
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMessage("Employee successfully Updated");
				responseStructure.setData(response);
				return new ResponseEntity<ResponseStructure<EmployeeResponse>>(responseStructure, HttpStatus.CREATED);
			} else {
				throw new EmployeeNotFoundByIdException("Filed to update the Employee!!");
			}
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<EmployeeResponse>> deleteEmployee(int employeeId) {
		Optional<Employee> optional = repository.findById(employeeId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			repository.delete(employee);
			EmployeeResponse response = new EmployeeResponse().setEmployeeId(employee.getEmployeeId())
					.setEmployeeName(employee.getEmployeeName()).setEmployeeEmail(employee.getEmployeeEmail())
					.setEmployeePhoneNumber(employee.getEmployeePhoneNumber())
					.setEmployeeSalary(employee.getEmployeeSalary());
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Employee deleted successfully");
			responseStructure.setData(response);
			return new ResponseEntity<ResponseStructure<EmployeeResponse>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new EmployeeNotFoundByIdException("Filed to Delete the Employee!!");
		}
	}

	@Override
	public Employee deleteEmployeeById(int employeeId) {
		Optional<Employee> optional = repository.findById(employeeId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			repository.deleteById(employeeId);
			return employee;
		} else {
			throw new EmployeeNotFoundByIdException("failed to delete the Employee!!");
		}
	}

	@Override
	public Employee findByEmployeeEmail(String employeeEmail) {
		Optional<Employee> optional = repository.findByEmployeeEmail(employeeEmail);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;

		}
	}

	@Override
	public Employee findByEmployeeEmailAndPassword(String employeeEmail, String employeePassword) {
		Optional<Employee> optional = repository.findByEmployeeEmailAndPassword(employeeEmail, employeePassword);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

}