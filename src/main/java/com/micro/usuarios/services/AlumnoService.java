package com.micro.usuarios.services;

import java.util.List;

import com.micro.common.alumnos.models.entity.Alumno;
import com.micro.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno>{

	public List<Alumno> findByNombreOrApellido(String term);
	
	public Iterable<Alumno> findAllById(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
}
