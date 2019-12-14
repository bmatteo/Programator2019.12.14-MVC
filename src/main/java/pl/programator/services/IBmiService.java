package pl.programator.services;

import pl.programator.model.Bmi;

import java.util.List;

public interface IBmiService {
    Bmi save(Bmi bmi);
    Bmi getBmiById(int id);
    List<Bmi> getAllBims();
}
