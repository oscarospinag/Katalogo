package co.com.katalogo.service;

import java.util.List;

import co.com.katalogo.models.Fotos;

public interface IFotosService {
	
	List<Fotos> listar();
	Fotos Add(Fotos fotos);
	Fotos Update(Fotos fotos);
	void DeleteById(Integer id);
	Fotos FindById(Integer id);
	

}
