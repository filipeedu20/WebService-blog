package com.template.app.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.template.app.entity.ComentarioEntity;
import com.template.app.entity.PostagemEntity;
import com.template.app.repository.ComentarioRepository;

@Stateless
@Local
public class ComentarioService {

	@Inject
	private ComentarioRepository comentarioRepository;

	public List<ComentarioEntity> retrieveAll() {			
		System.out.println("service");
		List<ComentarioEntity> comentarioList = comentarioRepository.retrieveAll();		
		return comentarioList;
			
	}
	public ComentarioEntity get(Long id) {
		System.out.println("service");
		ComentarioEntity c = comentarioRepository.get(id);
		return c;
	}
	public ComentarioEntity create(ComentarioEntity comentarioEntity) {
		return comentarioRepository.persist(comentarioEntity);	
	}
	public void delete(ComentarioEntity comentarioEntity) {
		comentarioRepository.delete(comentarioEntity);		
	}
	
	public void update(ComentarioEntity comentarioEntity) {
		comentarioRepository.update(comentarioEntity);			
	}
}
