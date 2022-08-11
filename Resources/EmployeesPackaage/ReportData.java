package EmployeesPackaage;

public class ReportData {
	private String surname;
	private String name;
	private String patronymic;
	private char gender;
	private String date_of_Birth;
	private String begining_of_work;
	private String end_of_contract;
	private String position;
	private int salary;
	private String nationality;
	private String[] masChoose;
	private String sortValue;
	
	public ReportData() {
		
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String[] getMasChoose() {
		return masChoose;
	}
	public void setMasChoose(String[] masChoose) {
		this.masChoose = masChoose;
	}
	public String getSortValue() {
		return sortValue;
	}
	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}
}
