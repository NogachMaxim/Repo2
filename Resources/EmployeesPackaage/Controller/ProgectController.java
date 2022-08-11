package EmployeesPackaage.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import EmployeesPackaage.DAO.UsersDAO;
import EmployeesPackaage.Model.Client;
import EmployeesPackaage.Model.Employee;
import EmployeesPackaage.Model.Role;
import EmployeesPackaage.Service.UsersService;

import java.awt.Desktop;

@Controller
public class ProgectController {
	
	@Autowired
	private UsersService usersService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/list")
	public String index(Model model) {
		model.addAttribute("employees", this.usersService.allEmployees());
		return "List";
	}

	@GetMapping("/employee/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employee", this.usersService.employeeById(id));
		return "EmployeeById";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("newEmployee", new Employee());
		return "NewEmployee";
	}

	@PostMapping("/addEmployee")
	public String add(@ModelAttribute("newEmployee") Employee employee) {
		Long saveId = this.usersService.addEmployee(employee.getSurname(), employee.getName(), employee.getPatronymic(),
				employee.getGender(), employee.getDate_of_Birth(), employee.getBegining_of_work(),
				employee.getEnd_of_contract(), employee.getPosition(), employee.getSalary(), employee.getNationality(),
				employee.getAddress(), employee.getEducation(), employee.getExperience(), employee.getLanguage(), 
				employee.getPassword());
		return "redirect:/list";
	}

	@GetMapping("/employee/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		Employee employee = this.usersService.employeeById(id);
		if (employee != null) {
			model.addAttribute("editEmployee", employee);
			return "Edit";
		}

		model.addAttribute("employees", this.usersService.allEmployees());
		return "List";
	}

	@PostMapping("/employees/edit")
	public String update(@ModelAttribute("editEmployee") Employee editEmployee) {
		this.usersService.updateEmployee(editEmployee.getId(), editEmployee);
		return "redirect:/list";
	}

	@PostMapping("/employee/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {
		this.usersService.deleteEmployee(id);
		model.addAttribute("employees", this.usersService.allEmployees());
		return "List";
	}

	@GetMapping("/createReport")
	public String createReport() {
		return "SettingsReport";
	}

	@PostMapping("/showReport")
	public String showReport(@RequestParam("reportName") String reportName, @RequestParam("surname") String surname,
			@RequestParam("name") String name, @RequestParam("patronymic") String patronymic,
			@RequestParam("gender") String gender, @RequestParam("date_of_Birth") String date_of_Birth,
			@RequestParam("begining_of_work") String begining_of_work,
			@RequestParam("end_of_contract") String end_of_contract, @RequestParam("position") String position,
			@RequestParam("salary") String salary, @RequestParam("nationality") String nationality,
			@RequestParam("address") String address, @RequestParam("education") String education,
			@RequestParam("experience") String experience, @RequestParam("language") String language,
			@RequestParam("list") String[] list, @RequestParam("sortedBy") String sortedBy, Model model) {

		model.addAttribute("reportName", reportName);
		model.addAttribute("listFields", list);
		model.addAttribute("employeesForReport",
				this.usersService.employeesForReport(surname, name, patronymic, gender, date_of_Birth, begining_of_work,
						end_of_contract, position, salary, nationality, address, education, experience, language, list,
						sortedBy));

		return "Report";
	}

	@GetMapping("/inWord")
	public String inWord(@RequestParam("id") Long id) {
		this.usersService.inWord(id);
		return "redirect:/list";
	}
	
	@GetMapping("/registrationClient")
	public String registrationClient(Model model) {
		model.addAttribute("newClient", new Client());
		return "RegistrationClient";
	}

	@PostMapping("/registClient")
	public String regist(@ModelAttribute("newClient") Client client) {
		this.usersService.addClient(client.getSurname(),  client.getName(), client.getPatronymic(), client.getPassword());
		return "redirect:/list";
	}


}
