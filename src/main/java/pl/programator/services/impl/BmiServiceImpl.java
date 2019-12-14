package pl.programator.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programator.dao.IBmiDAO;
import pl.programator.model.Bmi;
import pl.programator.services.IBmiService;

import java.util.List;

@Service
public class BmiServiceImpl implements IBmiService {

    @Autowired
    IBmiDAO bmiDAO;

    @Override
    public Bmi save(Bmi bmi) {
        return this.bmiDAO.saveBmi(bmi);
    }

    @Override
    public Bmi getBmiById(int id) {
        return this.bmiDAO.getBmiById(id);
    }

    @Override
    public List<Bmi> getAllBims() {
        return this.bmiDAO.getAllBims();
    }
}
