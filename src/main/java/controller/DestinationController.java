package controller;

import model.Destination;
import service.DestinationService;

import java.util.List;

public class DestinationController {
    private final DestinationService service;

    public DestinationController(){
        service = new DestinationService();
    }

    public void addDestination(Destination destination){
        service.addDestination(destination);
    }

    public List<Destination> getAll(){
        return service.getAll();
    }

    public Destination getById(String id){
        return service.getById(id);
    }

    public void deleteById(String id){
        Destination destination = getById(id);
        VacationController vacationController = new VacationController();
        vacationController.deleteByDestination(destination);
        service.deleteById(id);
    }
}
