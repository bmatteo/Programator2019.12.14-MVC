package pl.programator.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.programator.controllers.BmiController;
import pl.programator.dao.IBmiDAO;
import pl.programator.dao.impl.BmiDAOImpl;
import pl.programator.dao.impl.BmiDOAStub;
import pl.programator.services.IBmiService;
import pl.programator.services.IHibernateSessionFactoryService;
import pl.programator.services.impl.BmiServiceImpl;
import pl.programator.services.impl.HibernateSessionFactoryServiceImpl;

@Configuration
public class AppConfigurationTest {

    @Bean
    public IBmiService bmiService(IBmiDAO bmiDAO) {
        return new BmiServiceImpl(bmiDAO);
    }

    @Bean
    public BmiController bmiController(IBmiService bmiService) {
        return new BmiController(bmiService);
    }
}
