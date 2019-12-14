package pl.programator.services;

import org.hibernate.Session;

public interface IHibernateSessionFactoryService {
    Session getSession();
}
