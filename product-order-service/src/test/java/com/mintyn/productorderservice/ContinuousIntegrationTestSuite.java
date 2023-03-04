package com.mintyn.productorderservice;

import com.mintyn.productorderservice.controller.OrderControllerTest;
import com.mintyn.productorderservice.controller.ProductControllerTest;
import com.mintyn.productorderservice.database.DataStoreSystemsHealthTest;
import com.mintyn.productorderservice.service.OrderServiceTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({DataStoreSystemsHealthTest.class, OrderControllerTest.class,
        ProductControllerTest.class, OrderServiceTest.class, ProductControllerTest.class})
public class ContinuousIntegrationTestSuite {

    //Intentionally empty - Test suite annotations set up is enough
}
