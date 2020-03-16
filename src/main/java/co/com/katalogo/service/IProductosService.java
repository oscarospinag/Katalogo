package co.com.katalogo.service;

import java.util.List;


import co.com.katalogo.models.Productos;

public interface IProductosService {
	
	List<Productos> findAll();	
	Productos agregar(Productos productos);
	Productos editar(Productos productos);
	void borrar(Integer  id);
	Productos findById(Integer id);
	

}
