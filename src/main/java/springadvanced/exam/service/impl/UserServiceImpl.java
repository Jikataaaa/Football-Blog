package springadvanced.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springadvanced.exam.model.entities.User;
import springadvanced.exam.model.service.UserServiceModel;
import springadvanced.exam.repository.UserRepository;
import springadvanced.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository repository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        repository.save(user);
    }
}
