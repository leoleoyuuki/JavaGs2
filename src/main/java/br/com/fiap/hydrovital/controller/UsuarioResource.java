package br.com.fiap.hydrovital.controller;

import java.util.ArrayList;

import br.com.fiap.hydrovital.model.entity.Usuario;
import br.com.fiap.hydrovital.model.repository.UsuarioRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/hydrovital/usuario")
public class UsuarioResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Usuario> resposta = UsuarioRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Usuario user) {
		Usuario resposta = UsuarioRepository.save(user);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); // 201 - Created
		} else {
			response = Response.status(400); // 400 - Bad Request
		}
		response.entity(resposta);
		return response.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		if (UsuarioRepository.delete(id)) {
			ResponseBuilder response = Response.noContent(); // 204 - No Content
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404); // 404 - Not Found
			return response.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Valid Usuario user) {
		Usuario resposta = UsuarioRepository.update(user);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); // 201 Created
		} else {
			response = Response.status(400); // 400 Bad Request
		}
		response.entity(resposta);
		return response.build();
	}
	

}
