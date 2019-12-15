package pl.programator.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programator.dao.IBmiDAO;
import pl.programator.model.Bmi;
import pl.programator.services.IBmiService;

import java.util.List;

public class BmiServiceImpl implements IBmiService {

    IBmiDAO bmiDAO;

    public BmiServiceImpl(IBmiDAO bmiDAO) {
        this.bmiDAO = bmiDAO;
    }

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

    @Override
    public double calculateAverageBmi() {
        List<Bmi> bmiList = this.bmiDAO.getAllBims();
        double result = 0;
        for (Bmi bmi : bmiList) {
            result += bmi.getBmiValue();
        }

        result = ((double) Math.round((result/bmiList.size())*100)) / 100.0;
        return result;
    }
}
