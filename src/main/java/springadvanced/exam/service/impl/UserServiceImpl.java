package springadvanced.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springadvanced.exam.model.entities.User;
import springadvanced.exam.model.service.UserServiceModel;
import springadvanced.exam.repository.UserRepository;
import springadvanced.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository repository, PasswordEncoder encoder) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.encoder = encoder;
    }




    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setPassword(encoder.encode(userServiceModel.getPassword()));
        repository.save(user);
    }
}
