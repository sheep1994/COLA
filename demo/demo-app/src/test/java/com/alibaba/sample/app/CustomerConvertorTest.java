package com.alibaba.sample.app;

import com.alibaba.sample.dto.clientobject.CustomerCO;
import org.junit.Before;
import org.junit.Test;

public class CustomerConvertorTest {


    private CustomerCO customerCO;

    @Before
    public void setup(){
        customerCO = new CustomerCO();
        customerCO.setCompanyName("TestCompany");
    }

    @Test
    public void testConvert(){

    }

}
