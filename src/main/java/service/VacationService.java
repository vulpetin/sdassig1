package service;

import model.Destination;
import model.Vacation;
import repository.VacationRepository;

import java.util.List;

public class VacationService {
    VacationRepository repository = new VacationRepository();

    public void addVacation(Vacation vacation){
        repository.addVacation(vacation);
    }

    public List<Vacation> getAll(){
        return repository.getAll();
    }

    public Vacation getById(String id){
        return repository.getById(id);
    }

    public void deleteByDestination(Destination destination){
        repository.deleteByDestination(destination);
    }

        public void deleteById(String id){
        repository.deleteById(id);
    }

    public void editVacation(Vacation vacation){
        repository.editVacation(vacation);
    }
}
