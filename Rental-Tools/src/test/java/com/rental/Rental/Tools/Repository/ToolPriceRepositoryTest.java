package com.rental.Rental.Tools.Repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class ToolPriceRepositoryTest {
    @Autowired
    private ToolPriceRepository toolPriceRepository;



}