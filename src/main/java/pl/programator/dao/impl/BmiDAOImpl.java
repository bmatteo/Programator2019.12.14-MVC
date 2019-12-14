package pl.programator.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import pl.programator.dao.IBmiDAO;
import pl.programator.model.Bmi;
import pl.programator.services.IHibernateSessionFactoryService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BmiDAOImpl implements IBmiDAO {

    @Autowired
    IHibernateSessionFactoryService sessionFactoryService;

    @Override
    public Bmi saveBmi(Bmi bmi) {
        Session session = this.sessionFactoryService.getSession();
        Transaction tx = session.beginTransaction();
        session.save(bmi);
        tx.commit();
        session.close();

        return bmi;
    }

    @Override
    public Bmi getBmiById(int id) {
        Session session = this.sessionFactoryService.getSession();
        Query query = session.createQuery("FROM pl.programator.model.Bmi WHERE id = " + id);
        Bmi bmi = (Bmi) query.uniqueResult();
        session.close();

        return bmi;
    }

    @Override
    public List<Bmi> getAllBims() {
        Session session = this.sessionFactoryService.getSession();
        Query query = session.createQuery("FROM pl.programator.model.Bmi");
        List<Bmi> bmis = query.list();
        session.close();

        return bmis;
    }
}
