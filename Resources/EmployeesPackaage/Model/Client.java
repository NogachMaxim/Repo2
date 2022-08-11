package EmployeesPackaage.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID")
	private Long client_id;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PATRONYMIC")
	private String patronymic;

	@Column(name = "PASSWORD")
	private String password;
	
	public Client() {
		
	}
	
	public Client(String surname, String name, String patronymic, String password) {
		super();
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.password=password;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
