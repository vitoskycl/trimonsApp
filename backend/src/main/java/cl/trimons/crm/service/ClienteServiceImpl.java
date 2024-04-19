package cl.trimons.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.trimons.crm.dto.ClienteDTO;
import cl.trimons.crm.entity.Cliente;
import cl.trimons.crm.repository.ClienteRepository;
import cl.trimons.crm.utils.FormatUtil;

@Service
public class ClienteServiceImpl implements ClienteService {
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	ClienteRepository clienteRepository;
		
	public List<ClienteDTO> fetchAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> resultadoList = new ArrayList<ClienteDTO>();
		
		for (Cliente entity : clientes) {
			ClienteDTO dto = new ClienteDTO();
			dto.setId(entity.getId());
			dto.setDireccion(entity.getDireccion());
			dto.setEmail(entity.getEmail());
			dto.setFechaNacimiento(FormatUtil.formatSimpleDate(entity.getFechaNacimiento()));
			dto.setNombre(entity.getNombre());
			dto.setTelefono(entity.getTelefono());
			dto.setEnable(FormatUtil.formatBoolean(entity.getEnable()));
			
			log.debug("VML -> Add ClienteDTO: " + dto);
			resultadoList.add(dto);
		}
		
		return resultadoList;
	}

	public List<ClienteDTO> fetchAll(Pageable paging) {
		Page<Cliente> page   = clienteRepository.findAll(paging);
		List<Cliente> clientes = page.getContent();
		List<ClienteDTO> resultadoList = new ArrayList<ClienteDTO>();
		
		for (Cliente entity : clientes) {
			ClienteDTO dto = new ClienteDTO();
			dto.setId(entity.getId());
			dto.setDireccion(entity.getDireccion());
			dto.setEmail(entity.getEmail());
			dto.setFechaNacimiento(FormatUtil.formatSimpleDate(entity.getFechaNacimiento()));
			dto.setNombre(entity.getNombre());
			dto.setTelefono(entity.getTelefono());
			dto.setEnable(FormatUtil.formatBoolean(entity.getEnable()));
			
			log.debug("VML -> Add ClienteDTO: " + dto);
			resultadoList.add(dto);
		}
		
		return resultadoList;		
	}

}
