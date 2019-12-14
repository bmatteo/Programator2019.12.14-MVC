package pl.programator.dao;

import pl.programator.model.Bmi;

import java.util.List;

public interface IBmiDAO {
    Bmi saveBmi(Bmi bmi);
    Bmi getBmiById(int id);
    List<Bmi> getAllBims();
}
