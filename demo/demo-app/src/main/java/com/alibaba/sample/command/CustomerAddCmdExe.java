package com.alibaba.sample.command;


import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.Response;

import com.alibaba.sample.common.util.DomainEventPublisher;
import com.alibaba.sample.convertor.CustomerConvertor;
import com.alibaba.sample.domain.customer.CustomerE;
import com.alibaba.sample.dto.CustomerAddCmd;
import com.alibaba.sample.dto.domainevent.CustomerCreatedEvent;
import com.alibaba.sample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Command
public class CustomerAddCmdExe implements CommandExecutorI<Response, CustomerAddCmd>{

    @Autowired
    private CustomerConvertor customerConvertor;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DomainEventPublisher domainEventPublisher;


    @Override
    public Response execute(CustomerAddCmd cmd) {
        //1. biz check
        CustomerE customer = customerConvertor.clientToEntity(cmd.getCustomerCO(), cmd.getContext());
        customer.checkConfilict();

        //2. save customer
        customerRepository.save(customer);

        //3. Send domain event
        domainEventPublisher.publish(new CustomerCreatedEvent());

        return Response.buildSuccess();
    }

}
