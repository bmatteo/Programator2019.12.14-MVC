package pl.programator.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.programator.configuration.AppConfiguration;
import pl.programator.configuration.AppConfigurationTest;
import pl.programator.dao.IBmiDAO;
import pl.programator.model.Bmi;
import pl.programator.model.Sex;
import pl.programator.services.IBmiService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
@WebMvcTest
public class BmiServiceImplTest {

    @Autowired
    IBmiService bmiService;

    @MockBean
    IBmiDAO bmiDAO;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateAverageBmiTest() {
        double expectedResult = 30.00;
        Bmi bmi1 = new Bmi(80, 185, Sex.MAN, 25.00);
        bmi1.setId(1);

        Bmi bmi2 = new Bmi(85, 185, Sex.MAN, 30.00);
        bmi2.setId(2);

        Bmi bmi3 = new Bmi(90, 185, Sex.MAN, 35.00);
        bmi3.setId(3);

        Mockito.when(this.bmiDAO.getAllBims()).thenReturn(new ArrayList<Bmi>() {{
            add(bmi1);
            add(bmi2);
            add(bmi3);
        }});

        double result = this.bmiService.calculateAverageBmi();

        Assert.assertEquals(expectedResult, result, 0.01);
    }

    @Test
    public void allRecordsTest() throws Exception {
        Bmi bmi1 = new Bmi(80, 185, Sex.MAN, 25.00);
        bmi1.setId(1);

        Bmi bmi2 = new Bmi(85, 185, Sex.MAN, 30.00);
        bmi2.setId(2);

        Bmi bmi3 = new Bmi(90, 185, Sex.MAN, 35.00);
        bmi3.setId(3);

        Mockito.when(this.bmiDAO.getAllBims()).thenReturn(new ArrayList<Bmi>() {{
            add(bmi1);
            add(bmi2);
            add(bmi3);
        }});

        this.mockMvc.perform(get("/allRecords"))
                .andExpect(status().isOk())
                .andExpect(view().name("allResult"))
                .andExpect(model().attribute("bmiList", hasSize(3)))
                .andExpect(model().attribute("bmiList", hasItem(
                        allOf(
                                hasProperty("weight", is(80)),
                                hasProperty("height", is(185)),
                                hasProperty("sex", is(Sex.MAN)),
                                hasProperty("bmiValue", is(25.00)),
                                hasProperty("id", is(1))
                        )
                )));

        verify(this.bmiDAO, times(2)).getAllBims();
    }

}
