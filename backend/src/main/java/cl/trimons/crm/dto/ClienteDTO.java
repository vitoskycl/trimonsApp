package cl.trimons.crm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = -2783279928411239147L;

	private Integer id;
	private String nombre;
	private String fechaNacimiento;
	private String direccion;
	private String telefono;
	private String email;
	private String enable;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
