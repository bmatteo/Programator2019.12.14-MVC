package pl.programator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.programator.controllers.BmiController;
import pl.programator.dao.IBmiDAO;
import pl.programator.dao.impl.BmiDAOImpl;
import pl.programator.services.IBmiService;
import pl.programator.services.IHibernateSessionFactoryService;
import pl.programator.services.impl.BmiServiceImpl;
import pl.programator.services.impl.HibernateSessionFactoryServiceImpl;

@Configuration
public class AppConfiguration {
    @Bean
    public IHibernateSessionFactoryService hibernateSessionFactoryService() {
        return new HibernateSessionFactoryServiceImpl();
    }

    @Bean
    public IBmiDAO bmiDAO(IHibernateSessionFactoryService hibernateSessionFactoryService) {
        return new BmiDAOImpl(hibernateSessionFactoryService);
    }

    @Bean
    public IBmiService bmiService(IBmiDAO bmiDAO) {
        return new BmiServiceImpl(bmiDAO);
    }
}
