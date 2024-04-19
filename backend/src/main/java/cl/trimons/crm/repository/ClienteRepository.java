package cl.trimons.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.trimons.crm.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
