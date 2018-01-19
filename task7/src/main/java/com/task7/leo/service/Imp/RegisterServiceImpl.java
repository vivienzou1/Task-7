package com.task7.leo.service.Imp;

import com.task7.leo.domain.Customer;
import com.task7.leo.domain.Employee;
import com.task7.leo.repositories.CustomerRepository;
import com.task7.leo.repositories.EmployeeRepository;
import com.task7.leo.repositories.RoleRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.RegisterService;
import com.task7.leo.dto.UserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    //private final UserRepository userRepository;

    //private final RoleRepository roleRepository;

    private final CustomerRepository customerRepository;

    private final EmployeeRepository employeeRepository;

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public RegisterServiceImpl(BCryptPasswordEncoder encoder, CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        //this.userRepository = userRepository;
        this.encoder = encoder;
        //this.roleRepository = roleRepository;
    }

    @Override
    public void Register(UserRegisterForm userRegisterForm) {
        if (userRegisterForm.getType().toLowerCase().equals("customer")) {
            RegisterForCustomer(userRegisterForm);
        } else {
            RegisterForEmployee(userRegisterForm);
        }

        /**
        User user = new User(userRegisterForm);
        user.setPassword(encoder.encode(userRegisterForm.getPassword()));

        Role role = roleRepository.findByName(userRegisterForm.getType());
        if (role == null) {
            role = new Role(userRegisterForm.getType());
        }
        role.getUsers().add(user);

        user.setRole(role);
        userRepository.save(user);
         */
    }

    private void RegisterForCustomer(UserRegisterForm userRegisterForm) {
        Customer customer = new Customer(userRegisterForm);
        customer.setPassword(encoder.encode(userRegisterForm.getPassword()));
        customerRepository.save(customer);
    }

    private void RegisterForEmployee(UserRegisterForm userRegisterForm) {
        Employee employee = new Employee(userRegisterForm);
        employee.setPassword(encoder.encode(userRegisterForm.getPassword()));
        employeeRepository.save(employee);
    }



}
