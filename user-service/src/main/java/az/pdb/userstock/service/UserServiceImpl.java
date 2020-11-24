package az.pdb.userstock.service;

import az.pdb.userstock.domain.User;
import az.pdb.userstock.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
