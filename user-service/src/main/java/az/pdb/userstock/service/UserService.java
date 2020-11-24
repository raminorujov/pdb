package az.pdb.userstock.service;

import az.pdb.userstock.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUserList();
    Optional<User> getUser(String username);
    User save(User user);
}
