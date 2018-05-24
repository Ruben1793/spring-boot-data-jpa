package com.bolsadeideas.springboot.app.Service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findOne(long id);
	public void delete(long id);
	
}
