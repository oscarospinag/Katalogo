package co.com.katalogo.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.katalogo.models.Productos;

public interface ProductosRepository extends CrudRepository<Productos, Integer> {

}
