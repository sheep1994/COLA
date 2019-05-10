package com.alibaba.sample.command.query;

import com.alibaba.sample.convertor.CustomerConvertor;
import com.alibaba.sample.tunnel.database.dataobject.CustomerDO;
import com.alibaba.sample.tunnel.database.CustomerDBTunnel;
import com.alibaba.sample.dto.CustomerListByNameQry;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.QueryExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Command
public class CustomerListByNameQryExe implements QueryExecutorI<MultiResponse<CustomerCO>, CustomerListByNameQry> {

    @Autowired
    private CustomerDBTunnel customerDBTunnel;

    @Autowired
    private CustomerConvertor customerConvertor;

    @Override
    public MultiResponse<CustomerCO> execute(CustomerListByNameQry cmd) {
        CustomerDO customerDO = customerDBTunnel.getByName(cmd.getName());
        List<CustomerCO> customerCOList = new ArrayList<>();
        customerCOList.add(customerConvertor.dataToClient(customerDO));
        return MultiResponse.ofWithoutTotal(customerCOList);
    }
}
