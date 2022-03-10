package hr.b2m.mhalupa.b2mapplication.dao;

import hr.b2m.mhalupa.b2mapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
