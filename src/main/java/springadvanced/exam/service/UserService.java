package springadvanced.exam.service;

import springadvanced.exam.model.entities.User;
import springadvanced.exam.model.service.UserServiceModel;

import java.util.List;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    List<UserServiceModel> loadAllUsers();

    void deleteUser(Long id);

}
