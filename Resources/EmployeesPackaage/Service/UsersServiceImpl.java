package EmployeesPackaage.Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import EmployeesPackaage.DAO.UsersDAO;
import EmployeesPackaage.Model.Client;
import EmployeesPackaage.Model.Employee;
import EmployeesPackaage.Model.Role;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	@Qualifier(value="usersDAO")
	private UsersDAO usersDAO;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Long addEmployee(String surname, String name, String patronymic, char gender, String date_of_Birth,
			String begining_of_work, String end_of_contract, String position, Integer salary, String nationality,
			String address, String education, String experience, String language, String password) {
		HashSet<Role> hsr = new HashSet<Role>();
		hsr.add(usersDAO.roleById1());
		return this.usersDAO.addEmployee(surname, name, patronymic, gender, date_of_Birth, begining_of_work,
				end_of_contract, position, salary, nationality, address, education, experience, language, passwordEncoder.encode(password),
				hsr);
	}

	@Override
	public List allEmployees() {
		return this.usersDAO.allEmployees();
	}

	@Override
	public Employee employeeById(Long id) {
		return this.usersDAO.employeeById(id);
	}

	@Override
	public void updateEmployee(Long id, Employee modifyEmployee) {
		this.usersDAO.updateEmployee(id, modifyEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = this.usersDAO.employeeById(id);
		if (employee != null) {
			this.usersDAO.deleteEmployee(employee.getId());
		}
	}

	@Override
	public List employeesForReport(String surname, String name, String patronymic, String gender, String date_of_Birth,
			String begining_of_work, String end_of_contract, String position, String salary, String nationality,
			String address, String education, String experience, String language, String[] list, String sortedBy) {
		return this.usersDAO.employeesForReport(surname, name, patronymic, gender, date_of_Birth, begining_of_work,
				end_of_contract, position, salary, nationality, address, education, experience, language, list,
				sortedBy);
	}

	@Override
	public void inWord(Long id) {
		Employee employee = this.usersDAO.employeeById(id);
		StringBuilder sb = new StringBuilder();
		sb.append(" ".repeat(30));
		sb.append("Employee card\n" + "\n" + "\n");
		sb.append("Common information:\n" + "\n");
		sb.append("Surname" + " ".repeat(10) + employee.getSurname() + "\n");
		sb.append("Name" + " ".repeat(13) + employee.getName() + "\n");
		sb.append("Patronymic" + " ".repeat(7) + employee.getPatronymic() + "\n");
		sb.append("-".repeat(50) + "\n" + "\n");
		sb.append("Position" + " ".repeat(9) + employee.getPosition() + "\n");
		sb.append("-".repeat(50) + "\n" + "\n");
		sb.append("Personal information:" + "\n" + "\n");
		sb.append("Date of Birth" + " ".repeat(4) + employee.getDate_of_Birth() + "\n");
		sb.append("Gender" + " ".repeat(11) + employee.getGender() + "\n");
		sb.append("Address" + " ".repeat(10) + employee.getAddress() + "\n");
		sb.append("-".repeat(70) + "\n" + "\n");
		sb.append("Proffessional information:\n" + "\n");
		sb.append("Begining of work" + " ".repeat(3) + employee.getBegining_of_work() + " ".repeat(5)
				+ "End of contract" + " ".repeat(3) + employee.getEnd_of_contract() + "\n");
		sb.append("Education" + " ".repeat(10) + employee.getEducation() + " ".repeat(11) + "Experience" + " ".repeat(9)
				+ employee.getExperience() + "\n");
		sb.append("-".repeat(70) + "\n" + "\n");
		sb.append("Additional information:" + "\n" + "\n");
		sb.append("Nationality" + " ".repeat(14) + employee.getNationality() + " ".repeat(5) + "Salary" + " ".repeat(10)
				+ employee.getSalary() + "\n");
		sb.append("Foreign language" + " ".repeat(9) + employee.getLanguage() + "\n");
		sb.append("-".repeat(70) + "\n" + "\n");
		FileWriter fw;
		try {
			fw = new FileWriter("File.doc");
			fw.write(sb.toString());
			fw.close();
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(new File("File.doc"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Long addClient(String surname, String name, String patronymic, String password) {
		return this.usersDAO.addClient(surname, name, patronymic, password);
	}

	@Override
	public List allClients() {
		return this.usersDAO.allClients();
	}

	@Override
	public Client clientById(Long id) {
		return this.usersDAO.clientById(id);
	}

	@Override
	public void deleteClient(Long id) {
		this.usersDAO.deleteClient(id);
	}

	@Override
	public UserDetails loadUserByUsername(String surname) throws UsernameNotFoundException {
	
		Employee employee = usersDAO.employeeBySurname(surname);
		if(employee == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(employee.getSurname(), employee.getPassword(), mapRolesToAuthorities(employee.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return (Collection<? extends GrantedAuthority>) roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
}

