package com.alibaba.sample.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.sample.api.CustomerServiceI;
import com.alibaba.sample.dto.CustomerAddCmd;
import com.alibaba.sample.dto.CustomerListByNameQry;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/customer")
    public MultiResponse<CustomerCO> listCustomerByName(@RequestParam String name){
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        return customerService.addCustomer(customerAddCmd);
    }
}
