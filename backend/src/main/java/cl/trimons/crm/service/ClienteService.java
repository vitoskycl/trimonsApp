package cl.trimons.crm.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.trimons.crm.dto.ClienteDTO;

@Service
public interface ClienteService {
	List<ClienteDTO> fetchAll();
	List<ClienteDTO> fetchAll(Pageable paging);
	long countAll();
}
