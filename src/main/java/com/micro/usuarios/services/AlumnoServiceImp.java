package com.micro.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micro.common.alumnos.models.entity.Alumno;
import com.micro.commons.services.CommonServiceImp;
import com.micro.usuarios.client.CursoFeingClient;
import com.micro.usuarios.model.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp extends CommonServiceImp<Alumno, AlumnoRepository> implements AlumnoService {

	@Autowired
	private CursoFeingClient clientCurso;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {		
		return repo.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		clientCurso.eliminarCursoAlumnoPorId(id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {		
		super.deleteById(id);
		this.eliminarCursoAlumnoPorId(id);
	}	
}
