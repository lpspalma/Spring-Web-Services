package com.dash.Dash.Management.web;

import com.dash.Dash.Management.DAO.EmployeeRepository;
import com.dash.Dash.Management.DAO.ProjectRepository;
import com.dash.Dash.Management.model.Employee;
import com.dash.Dash.Management.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee){
        employeeRepository.save(employee);

        return "redirect:/employees/new";
    }

    @GetMapping("/home")
    public String displayHome(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee-home";
    }
}
