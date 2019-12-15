package pl.programator.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.programator.services.IBmiService;

@RunWith(SpringJUnit4ClassRunner.class)
public class BmiServiceImplTest {

    @Autowired
    IBmiService bmiService;

    @Test
    public void calculateAverageBmiTest() {
        double expectedResult = 33.33;

        double result = this.bmiService.calculateAverageBmi();

        Assert.assertEquals(expectedResult, result, 0.01);
    }

}
