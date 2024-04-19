package cl.trimons.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.trimons.crm.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

//	 @Query("SELECT COUNT(u) FROM Cliente u")
//     long countAll();
}
