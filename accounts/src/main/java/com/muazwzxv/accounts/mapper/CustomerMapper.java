package com.muazwzxv.accounts.mapper;

import com.muazwzxv.accounts.dto.customerDTO.CustomerDto;
import com.muazwzxv.accounts.entities.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());

        return customerDto;
    }

    public static Customer mapToCustomer(Customer customer, CustomerDto customerDto) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        return customer;
    }
}
