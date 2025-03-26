package nl.moreniekmeijer.backendspringboottechiteasycontroller.repositories;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
