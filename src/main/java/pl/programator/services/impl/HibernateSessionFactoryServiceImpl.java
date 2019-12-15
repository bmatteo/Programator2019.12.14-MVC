package pl.programator.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import pl.programator.services.IHibernateSessionFactoryService;

public class HibernateSessionFactoryServiceImpl
        implements IHibernateSessionFactoryService {

    private SessionFactory sessionFactory;

    public HibernateSessionFactoryServiceImpl() {
        this.sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public Session getSession() {
        return this.sessionFactory.openSession();
    }
}