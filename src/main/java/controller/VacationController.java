package controller;

import model.Destination;
import model.Vacation;
import service.VacationService;

import java.util.List;

public class VacationController {
    VacationService service = new VacationService();

    public void addVacation(Vacation vacation){
        service.addVacation(vacation);
    }

    public List<Vacation> getAll(){
        return service.getAll();
    }

    public Vacation getById(String id){
        return service.getById(id);
    }

    public void deleteByDestination(Destination destination){
        service.deleteByDestination(destination);
    }

        public void deleteById(String id){
        service.deleteById(id);
    }

    public void editVacation(Vacation vacation){
        service.editVacation(vacation);
    }
}
