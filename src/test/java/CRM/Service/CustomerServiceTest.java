package CRM.Service;

import CRM.Service.dto.CustomerDTO;
import CRM.Service.entity.Customer;
import CRM.Service.repository.CustomerRepository;
import CRM.Service.service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    @DisplayName("Must save sucessfuly a customer")
    void saveCustomer_MustReturnSavedClient(){

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Mocked test");
        customerDTO.setEmail("mocked@Email.com");
        customerDTO.setStatus("Active");

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setStatus(customerDTO.getStatus());

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer result = customerService.saveCustomer(customerDTO);

        assertNotNull(result);
        assertEquals("Mocked test", result.getName());
        assertEquals("mocked@Email.com", result.getEmail());
        assertEquals("Active", result.getStatus());

        verify(customerRepository, times(1)).save(any(Customer.class));
    }

}
