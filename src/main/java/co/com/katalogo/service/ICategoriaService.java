package co.com.katalogo.service;

import java.util.List;


import co.com.katalogo.models.Categoria;

public interface ICategoriaService {

	List<Categoria> findAll();	
	Categoria agregar(Categoria categoria);
	Categoria editar(Categoria categoria);
	void borrar(Integer  id);
	Categoria findById(Integer id);
	
}
