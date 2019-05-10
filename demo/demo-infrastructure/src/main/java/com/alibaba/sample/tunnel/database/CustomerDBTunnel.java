package com.alibaba.sample.tunnel.database;

import com.alibaba.sample.tunnel.database.dataobject.CustomerDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import com.alibaba.cola.tunnel.DataTunnelI;
import java.util.List;

@Component
@Mapper
public class CustomerDBTunnel implements DataTunnelI {

    public CustomerDO create(CustomerDO customerDo) {
        return new CustomerDO();
    }

    public void update(CustomerDO customerDo) {
    }

    public CustomerDO get(String id) {
        CustomerDO customerDo = new CustomerDO();//just for demo
        return customerDo;
    }

    public CustomerDO getByName(String name) {
        CustomerDO customerDO = new CustomerDO();
        customerDO.setCompanyName("Hello, " + name);
        return customerDO;
    }

}
