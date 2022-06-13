package code.elif.bootMySqlDocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CamblyRepository extends JpaRepository<CamblyDTO, Long> {
}
