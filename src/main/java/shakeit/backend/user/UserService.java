package shakeit.backend.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById (Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException(id + "not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user, Long id) {
        User found = getById(id);
        return userRepository.save(found);
    }

}
