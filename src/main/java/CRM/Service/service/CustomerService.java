package CRM.Service.service;


import CRM.Service.dto.CustomerDTO;
import CRM.Service.entity.Customer;
import CRM.Service.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer saveCustomer(CustomerDTO customerDTO) {

        LocalDateTime date = LocalDateTime.now();

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setCreatedAt(date);
        customer.setUpdatedAt(customerDTO.getUpdatedAt());
        customer.setStatus(customerDTO.getStatus());
        customer.setDeleted(customerDTO.isDeleted());

        customerRepository.save(customer);
        return customer;

    }

    public Page<Customer> getAllCustomers(int page, int itens, Boolean deleted){
        Pageable pageable = PageRequest.of(page, itens);

        return customerRepository.findByActive(deleted, pageable);
    }


    public Customer updateCustomer(Long id,CustomerDTO customerDTO){



        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));

        customer.setName(customerDTO.getName());
        customer.setStatus(customerDTO.getStatus());
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setEmail(customerDTO.getEmail());

        customerRepository.save(customer);

        return customer;

    }

    public void deleteCustomer(Long id){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        customer.setDeleted(true);
        customer.setStatus("deleted");
        customerRepository.save(customer);

    }

}