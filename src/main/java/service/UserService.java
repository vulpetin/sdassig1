package service;

import model.User;
import repository.UserRepository;

public class UserService {

    public void addUser(User user){
        UserRepository repository = new UserRepository();
        repository.addUser(user);
    }

    public User getByUsername(String username){
        UserRepository userRepository = new UserRepository();
        return userRepository.getByUsername(username);
    }


}
