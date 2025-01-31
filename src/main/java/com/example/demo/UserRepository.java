import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
