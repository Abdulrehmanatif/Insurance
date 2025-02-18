package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddCustomerRequestDTO;
import com.example.insurance.entity.Customer;
import com.example.insurance.entity.CustomerInsurance;
import com.example.insurance.repository.CustomerInsuranceRepository;
import com.example.insurance.repository.CustomerRepository;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerInsuranceRepository customerInsuranceRepository;


    private Customer customer;
    private AddCustomerRequestDTO requestDTO;
    private CustomerInsurance customerInsurance;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setCustomerId(1);
        customer.setFullName("John Doe");
        customer.setBirthDate(new Date());

        requestDTO = new AddCustomerRequestDTO();
        requestDTO.setFullName("John Doe");
        requestDTO.setBirthDate(new Date());
        requestDTO.setInsuranceTypes(Arrays.asList(1, 2));

        customerInsurance = new CustomerInsurance();
        customerInsurance.setCustomerId(1);
        customerInsurance.setInsuranceId(1);
    }

    @Test
    void testAddCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        when(customerInsuranceRepository.save(any(CustomerInsurance.class))).thenReturn(customerInsurance);

        ApiResponse response = customerService.addCustomer(requestDTO);

        assertEquals(Constants.SUCCESS_CODE, response.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, response.getMessage());
        verify(customerRepository, times(1)).save(any(Customer.class));
        verify(customerInsuranceRepository, times(2)).save(any(CustomerInsurance.class));
    }
}
