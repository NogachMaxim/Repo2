package EmployeesPackaage.Service;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;

import EmployeesPackaage.Model.Client;
import EmployeesPackaage.Model.Employee;
import EmployeesPackaage.Model.Role;

public interface UsersService extends UserDetailsService {
	Long addEmployee(String surname, String name, String patronymic, char gender, String date_of_Birth,
			String begining_of_work, String end_of_contract, String position, Integer salary, String nationality,
			String address, String education, String experience, String language, String password);

	List allEmployees();

	Employee employeeById(Long id);

	void updateEmployee(Long id, Employee modifyEmployee);

	void deleteEmployee(Long id);

	List employeesForReport(String surname, String name, String patronymic, String gender, String date_of_Birth,
			String begining_of_work, String end_of_contract, String position, String salary, String nationality,
			String address, String education, String experience, String language, String[] list, String sortedBy);

	Long addClient(String surname, String name, String patronymic, String password);

	List allClients();

	Client clientById(Long id);

	void deleteClient(Long id);

	void inWord(Long id);
}
