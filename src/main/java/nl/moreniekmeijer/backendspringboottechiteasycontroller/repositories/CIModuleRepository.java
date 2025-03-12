package nl.moreniekmeijer.backendspringboottechiteasycontroller.repositories;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
