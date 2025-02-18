package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddCustomerRequestDTO;
import com.example.insurance.dto.CustomerResponseDTO;
import com.example.insurance.entity.Customer;
import com.example.insurance.entity.CustomerInsurance;
import com.example.insurance.exception.CustomerNotFoundException;
import com.example.insurance.repository.CustomerInsuranceRepository;
import com.example.insurance.repository.CustomerRepository;
import com.example.insurance.service.CustomerService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerInsuranceRepository customerInsuranceRepository;

    @Override
    public ApiResponse addCustomer(AddCustomerRequestDTO request) {
        Customer customer = new Customer();
        customer.setFullName(request.getFullName());
        customer.setBirthDate(request.getBirthDate());
        customer = customerRepository.save(customer);
        for (Integer i : request.getInsuranceTypes()) {
            CustomerInsurance customerInsurance = new CustomerInsurance();
            customerInsurance.setCustomerId(customer.getCustomerId());
            customerInsurance.setInsuranceId(i);
            customerInsuranceRepository.save(customerInsurance);
        }
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }

    @Override
    public ApiResponse getCustomerInfo( Integer customerId) throws Exception {
        Customer customer = Optional.of(customerRepository.findById(customerId))
                .filter(Optional::isPresent)
                .orElseThrow(() -> new CustomerNotFoundException(customerId)).get();
        CustomerResponseDTO response = new CustomerResponseDTO();
            response.setCustomerId(customer.getCustomerId());
            response.setFullName(customer.getFullName());
            response.setBirthDate(customer.getBirthDate());
            List<CustomerInsurance> customerInsurance = customerInsuranceRepository.findAllByCustomerId(customerId);
            List<String> insuranceTypeList = new ArrayList<>();
            for (CustomerInsurance customerInsurance1 : customerInsurance) {
                insuranceTypeList.add(Constants.InsuranceTypeEnum.getDescriptionById(customerInsurance1.getInsuranceId()));
            }
            response.setInsuranceTypes(insuranceTypeList);
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, response);
    }
}
