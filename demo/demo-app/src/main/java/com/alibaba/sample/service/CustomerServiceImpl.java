package com.alibaba.sample.service;

import com.alibaba.sample.dto.CustomerListByNameQry;
import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.sample.api.CustomerServiceI;
import com.alibaba.sample.dto.CustomerAddCmd;
import com.alibaba.sample.dto.CustomerListByNameQry;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Autowired
    private CommandBusI commandBus;

    @Override
    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return (Response)commandBus.send(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerCO> listByName(CustomerListByNameQry customerListByNameQry) {
        return (MultiResponse<CustomerCO>)commandBus.send(customerListByNameQry);
    }

}
