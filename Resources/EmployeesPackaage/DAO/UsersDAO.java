package EmployeesPackaage.DAO;

import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import EmployeesPackaage.Model.Client;
import EmployeesPackaage.Model.Employee;
import EmployeesPackaage.Model.Role;

@Component
public class UsersDAO {

	private static SessionFactory sessionFactory;

	public UsersDAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public Long addEmployee(String surname, String name, String patronymic, char gender, String date_of_Birth,
			String begining_of_work, String end_of_contract, String position, Integer salary, String nationality,
			String address, String education, String experience, String language, String password, Set<Role> roles) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Employee employee = new Employee(surname, name, patronymic, gender, date_of_Birth, begining_of_work,
				end_of_contract, position, salary, nationality, address, education, experience, language, password,
				roles);
		
		Long employeeID = (Long) session.save(employee);
		transaction.commit();
		session.close();
		return employeeID;
	}

	public List allEmployees() {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		List employees = session.createQuery("FROM Employee").list();
		transaction.commit();
		session.close();
		return employees;
	}

	public Employee employeeById(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		transaction.commit();
		session.close();
		return employee;
	}

	public Employee employeeBySurname(String surname) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Employee e where e.surname = :surname");
		query.setParameter("surname", surname);
		transaction.commit();
		if (query.list().size() != 0) {
			Employee employee = (Employee) query.list().get(0);
			session.close();
			return employee;
		}
		return null;
	}

	public void updateEmployee(Long id, Employee modifyEmployee) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		employee.setSurname(modifyEmployee.getSurname());
		employee.setName(modifyEmployee.getName());
		employee.setPatronymic(modifyEmployee.getPatronymic());
		employee.setGender(modifyEmployee.getGender());
		employee.setDate_of_Birth(modifyEmployee.getDate_of_Birth());
		employee.setBegining_of_work(modifyEmployee.getBegining_of_work());
		employee.setEnd_of_contract(modifyEmployee.getEnd_of_contract());
		employee.setPosition(modifyEmployee.getPosition());
		employee.setSalary(modifyEmployee.getSalary());
		employee.setNationality(modifyEmployee.getNationality());
		employee.setAddress(modifyEmployee.getAddress());
		employee.setEducation(modifyEmployee.getEducation());
		employee.setExperience(modifyEmployee.getExperience());
		employee.setLanguage(modifyEmployee.getLanguage());
		session.update(employee);
		transaction.commit();
		session.close();
	}

	public void deleteEmployee(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
		transaction.commit();
		session.close();
	}

	public List employeesForReport(String surname, String name, String patronymic, String gender, String date_of_Birth,
			String begining_of_work, String end_of_contract, String position, String salary, String nationality,
			String address, String education, String experience, String language, String[] list, String sortedBy) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		StringBuilder queryStr = new StringBuilder("select ");
		queryStr.append("e." + list[0]);
		for (int i = 1; i < list.length; i++) {
			queryStr.append(", e." + list[i]);
		}
		queryStr.append(" from Employee e where");
		if (!surname.equals("")) {
			queryStr.append(" e.surname = \"" + surname + "\"" + " and");
		}
		if (!name.equals("")) {
			queryStr.append(" e.name = \"" + name + "\"" + " and");
		}
		if (!patronymic.equals("")) {
			queryStr.append(" e.patronymic = \"" + patronymic + "\"" + " and");
		}
		if (!gender.equals("")) {
			queryStr.append(" e.gender = \"" + gender + "\"" + " and");
		}
		if (!date_of_Birth.equals("")) {
			queryStr.append(" e.date_of_Birth = \"" + date_of_Birth + "\"" + " and");
		}
		if (!begining_of_work.equals("")) {
			queryStr.append(" e.begining_of_work = \"" + begining_of_work + "\"" + " and");
		}
		if (!end_of_contract.equals("")) {
			queryStr.append(" e.end_of_contract = \"" + end_of_contract + "\"" + " and");
		}
		if (!position.equals("")) {
			queryStr.append(" e.position = \"" + position + "\"" + " and");
		}
		if (!salary.equals("")) {
			queryStr.append(" e.salary = \"" + salary + "\"" + " and");
		}
		if (!nationality.equals("")) {
			queryStr.append(" e.nationality = \"" + nationality + "\"" + " and");
		}
		if (!address.equals("")) {
			queryStr.append(" e.address = \"" + address + "\"" + " and");
		}
		if (!education.equals("")) {
			queryStr.append(" e.education = \"" + education + "\"" + " and");
		}
		if (!experience.equals("")) {
			queryStr.append(" e.experience = \"" + experience + "\"" + " and");
		}
		if (!language.equals("")) {
			queryStr.append(" e.language = \"" + language + "\"" + " and");
		}
		if (queryStr.substring(queryStr.length() - 6, queryStr.length()).equals(" where")) {
			queryStr.delete(queryStr.length() - 6, queryStr.length());
		} else {
			queryStr.delete(queryStr.length() - 4, queryStr.length());
		}
		queryStr.append(" order by e." + sortedBy + " ASC");
		transaction = session.beginTransaction();
		List list1 = session.createQuery(queryStr.toString()).list();
		transaction.commit();
		return list1;
	}

	public Long addClient(String surname, String name, String patronymic, String password) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Client client = new Client(surname, name, patronymic, password);
		Long clientId = (Long) session.save(client);
		transaction.commit();
		session.close();
		return clientId;
	}

	public List allClients() {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		List clients = session.createQuery("FROM Client").list();
		transaction.commit();
		session.close();
		return clients;
	}

	public Client clientById(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Client client = (Client) session.get(Client.class, id);
		transaction.commit();
		session.close();
		return client;
	}

	public Client clientBySurname(String surname) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Client e where e.surname = :surname");
		query.setParameter("surname", surname);
		transaction.commit();
		if (query.list().size() != 0) {
			Client client = (Client) query.list().get(0);
			session.close();
			return client;
		}
		return null;
	}

	public void updateClient(Long id, Client modifyClient) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Client client = (Client) session.get(Client.class, id);
		client.setSurname(modifyClient.getSurname());
		client.setName(modifyClient.getName());
		client.setPatronymic(modifyClient.getPatronymic());
		client.setPassword(modifyClient.getPassword());
		session.update(client);
		transaction.commit();
		session.close();
	}

	public void deleteClient(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Client client = (Client) session.get(Client.class, id);
		session.delete(client);
		transaction.commit();
		session.close();
	}

	public Role roleById1() {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Role role = (Role) session.getReference(Role.class, 1);
		transaction.commit();
		session.close();
		return role;
	}

	
}
