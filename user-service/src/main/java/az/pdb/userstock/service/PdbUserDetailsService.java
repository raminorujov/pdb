package az.pdb.userstock.service;

import az.pdb.userstock.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PdbUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public PdbUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<az.pdb.userstock.domain.User> optionalUser = userRepository.findByEmail(username);

        if(optionalUser.isPresent()){
            az.pdb.userstock.domain.User user = optionalUser.get();
            return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
        } else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
