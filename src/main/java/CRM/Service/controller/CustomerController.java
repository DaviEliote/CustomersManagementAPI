package CRM.Service.controller;

import CRM.Service.dto.CustomerDTO;
import CRM.Service.entity.Customer;
import CRM.Service.service.CustomerService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Customer> save(@Valid @RequestBody CustomerDTO customerDTO){

        Customer newCustumer = customerService.saveCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustumer);
    }

    @GetMapping("/customer")
    public Page<Customer> getAll(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int itens,
                                 @RequestParam(required = false) Boolean deleted){

        return customerService.getAllCustomers(page, itens, deleted);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id,
                                           @RequestBody CustomerDTO customerDTO
    ){

            Customer customer = customerService.updateCustomer(id,customerDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);

    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }
}
