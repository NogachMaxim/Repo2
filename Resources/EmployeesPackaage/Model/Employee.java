package EmployeesPackaage.Model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PATRONYMIC")
	private String patronymic;

	@Column(name = "GENDER")
	private char gender;

	@Column(name = "DATE_OF_BIRTH")
	private String date_of_Birth;

	@Column(name = "BEGINING_OF_WORK")
	private String begining_of_work;

	@Column(name = "END_OF_CONTRACT")
	private String end_of_contract;

	@Column(name = "POSITION")
	private String position;

	@Column(name = "SALARY")
	private int salary;

	@Column(name = "NATIONALITY")
	private String nationality;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EDUCATION")
	private String education;

	@Column(name = "EXPERIENCE")
	private String experience;

	@Column(name = "FOREIGN_LANGUAGE")
	private String language;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "employees_roles", joinColumns = @JoinColumn(name = "EMPLOYEE___ID", 
	referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE___ID", 
	referencedColumnName = "ROLE_ID"))
	private Collection<Role> roles;

	public Employee() {
	}

	public Employee(String surname, String name, String patronymic, char gender, String date_of_Birth,
			String begining_of_work, String end_of_contract, String position, int salary, String nationality,
			String address, String education, String experience, String language, String password, Collection<Role> roles) {
		super();
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.gender = gender;
		this.date_of_Birth = date_of_Birth;
		this.begining_of_work = begining_of_work;
		this.end_of_contract = end_of_contract;
		this.position = position;
		this.salary = salary;
		this.nationality = nationality;
		this.address = address;
		this.education = education;
		this.experience = experience;
		this.language = language;
		this.password = password;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic
				+ ", gender=" + gender + ", date_of_Birth=" + date_of_Birth + ", begining_of_work=" + begining_of_work
				+ ", end_of_contract=" + end_of_contract + ", position=" + position + ", salary=" + salary
				+ ", nationality=" + nationality + ", address=" + address + ", education=" + education + ", experience="
				+ experience + ", language=" + language + ", password=" + password + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDate_of_Birth() {
		return date_of_Birth;
	}

	public void setDate_of_Birth(String date_of_Birth) {
		this.date_of_Birth = date_of_Birth;
	}

	public String getBegining_of_work() {
		return begining_of_work;
	}

	public void setBegining_of_work(String begining_of_work) {
		this.begining_of_work = begining_of_work;
	}

	public String getEnd_of_contract() {
		return end_of_contract;
	}

	public void setEnd_of_contract(String end_of_contract) {
		this.end_of_contract = end_of_contract;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
