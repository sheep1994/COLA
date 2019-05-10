package com.alibaba.sample.repository;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.sample.tunnel.database.dataobject.CustomerDO;
import com.alibaba.sample.tunnel.database.CustomerDBTunnel;
import com.alibaba.sample.convertor.CustomerConvertor;
import com.alibaba.sample.domain.customer.CustomerE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.alibaba.cola.repository.RepositoryI;

@Repository
public class CustomerRepository implements RepositoryI{

    @Autowired
    private CustomerDBTunnel customerDBTunnel;

    @Autowired
    private CustomerConvertor customerConvertor;

    public void save(CustomerE customer) {
        customerDBTunnel.create(customerConvertor.entityToData(customer));
    }

}