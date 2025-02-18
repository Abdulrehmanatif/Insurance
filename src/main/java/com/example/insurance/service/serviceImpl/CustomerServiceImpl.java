package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddCustomerRequestDTO;
import com.example.insurance.dto.CustomerResponseDTO;
import com.example.insurance.entity.Customer;
import com.example.insurance.entity.CustomerInsurance;
import com.example.insurance.entity.InsuranceType;
import com.example.insurance.repository.CustomerInsuranceRepository;
import com.example.insurance.repository.CustomerRepository;
import com.example.insurance.repository.InsuranceTypeRepository;
import com.example.insurance.service.CustomerService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerInsuranceRepository customerInsuranceRepository;

    @Autowired
    InsuranceTypeRepository insuranceTypeRepository;

    @Override
    public ApiResponse addCustomer(AddCustomerRequestDTO request) {
        Customer customer = new Customer();
        if (request.getFullName() != null && !request.getFullName().trim().isEmpty()) {
            customer.setFullName(request.getFullName());
        } else {
            throw new IllegalArgumentException("Full name cannot be null or empty");
        }
        if (request.getBirthDate() != null) {
            customer.setBirthDate(request.getBirthDate());
        } else {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        customer = customerRepository.save(customer);

        if (request.getInsuranceTypes() != null && !request.getInsuranceTypes().isEmpty()) {
            for (Integer i : request.getInsuranceTypes()) {
                if (i == null) {
                    throw new IllegalArgumentException("Insurance type ID cannot be null");
                }
                CustomerInsurance customerInsurance = new CustomerInsurance();
                customerInsurance.setCustomerId(customer.getCustomerId());
                customerInsurance.setInsuranceId(i);
                customerInsuranceRepository.save(customerInsurance);
            }
        } else {
            throw new IllegalArgumentException("At least one insurance type must be provided");
        }
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, null);
    }

    @Override
    public ApiResponse getCustomerInfo( Integer customerId) throws Exception {
        Customer customer = customerRepository.findById(customerId).get();
        CustomerResponseDTO response = new CustomerResponseDTO();
        if(customer != null) {
            response.setCustomerId(customer.getCustomerId());
            response.setFullName(customer.getFullName());
            response.setBirthDate(customer.getBirthDate());
            List<CustomerInsurance> customerInsurance = customerInsuranceRepository.findAllByCustomerId(customerId);
            List<String> insuranceTypeList = new ArrayList<>();
            for (CustomerInsurance customerInsurance1 : customerInsurance) {
                InsuranceType insuranceType = insuranceTypeRepository.findById(customerInsurance1.getInsuranceId()).get();
                insuranceTypeList.add(insuranceType.getInsuranceTypeName());
            }
            response.setInsuranceTypes(insuranceTypeList);
        }else {
            throw new Exception("Customer Not Found!");
        }
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE,response);
    }
}
