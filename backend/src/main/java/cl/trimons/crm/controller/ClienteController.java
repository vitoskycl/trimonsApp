package cl.trimons.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.trimons.crm.dto.ClienteDTO;
import cl.trimons.crm.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	// @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> findAll(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size){		
		try {
			Pageable paging = PageRequest.of(page, size);
			return new ResponseEntity<List<ClienteDTO>>(clienteService.fetchAll(paging), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/clientes/count")
	public ResponseEntity<Long> getNumeroClientes(){		
		try {			
			return new ResponseEntity<Long>(Long.valueOf(clienteService.countAll()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
