package controller;

import model.User;
import service.UserService;

public class UserController {
    public void addUser(User user){
        UserService service = new UserService();
        service.addUser(user);
    }
    public User getByUsername(String username){
        UserService userService = new UserService();
        return userService.getByUsername(username);
    }
}
