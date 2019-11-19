package com.template.app.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.ComentarioEntity;
import com.template.app.entity.PostagemEntity;
import com.template.app.exception.AppException;
import com.template.app.service.ComentarioService;

@Path("/comentario")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ComentarioRest {

	@Inject
	private ComentarioService comentarioService;
	
	@GET
	@Path("/")
	public List<ComentarioEntity> getAllComentarios() throws AppException{
				
		List<ComentarioEntity> listComentarios = comentarioService.retrieveAll();
		return listComentarios;
	}
	
	@POST
	@Path("/")
	public ComentarioEntity create(ComentarioEntity comentarioEntity) throws AppException{
		return comentarioService.create(comentarioEntity);
	}
	
	@DELETE
	@Path("/")
	public void delete(ComentarioEntity comentarioEntity) throws AppException{
		comentarioService.delete(comentarioEntity);
	}
	
	@GET
	@Path("/{id}")
	public ComentarioEntity get( @PathParam("id") Long entityId) throws AppException {
		ComentarioEntity c =  comentarioService.get(entityId);
		return c;
	}	
	
	@PUT
	@Path("/")
	public void updateComentario(ComentarioEntity comentarioEntity) throws AppException{
		comentarioService.update(comentarioEntity);
	}
}
