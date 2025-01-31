import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new RuntimeException("bu kullanici adi alindi");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user =userRepository.findByUsername(username);
        if(user.isEmpty()){

        }else{
            throw new RuntimeException("kullanici bulunamadi");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("yanlis sifre");
        }
        return user;
    }
}