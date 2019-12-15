package pl.programator.dao.impl;

import pl.programator.dao.IBmiDAO;
import pl.programator.model.Bmi;
import pl.programator.model.Sex;

import java.util.ArrayList;
import java.util.List;

public class BmiDOAStub implements IBmiDAO {
    @Override
    public Bmi saveBmi(Bmi bmi) {
        return null;
    }

    @Override
    public Bmi getBmiById(int id) {
        return null;
    }

    @Override
    public List<Bmi> getAllBims() {
        Bmi bmi1 = new Bmi(80, 185, Sex.MAN, 25.00);
        bmi1.setId(1);

        Bmi bmi2 = new Bmi(85, 185, Sex.MAN, 30.00);
        bmi2.setId(2);

        Bmi bmi3 = new Bmi(90, 185, Sex.MAN, 35.00);
        bmi3.setId(3);

        return new ArrayList<Bmi>(){{
            add(bmi1);
            add(bmi2);
            add(bmi3);
        }};
    }
}
