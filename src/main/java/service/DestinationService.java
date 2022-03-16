package service;

import model.Destination;
import repository.DestinationRepository;

import java.util.List;

public class DestinationService {
    private final DestinationRepository repository = new DestinationRepository();

    public void addDestination(Destination destination){
        repository.addDestination(destination);
    }

    public List<Destination> getAll(){
        return repository.getAll();
    }

    public Destination getById(String id){
        return repository.getById(id);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }
}
