package co.com.katalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.katalogo.models.Productos;
import co.com.katalogo.repository.ProductosRepository;

@Service
public class ProductosImp implements IProductosService {

	@Autowired
	private ProductosRepository productosRepository;

	@Override
	public List<Productos> findAll() {
		// TODO Auto-generated method stub
		return (List<Productos>) productosRepository.findAll();
	}

	@Override
	public Productos agregar(Productos productos) {
		// TODO Auto-generated method stub
		return productosRepository.save(productos);
	}

	@Override
	public Productos editar(Productos productos) {
		// TODO Auto-generated method stub
		return productosRepository.save(productos);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		productosRepository.deleteById(id);
	}

	@Override
	public Productos findById(Integer id) {
		// TODO Auto-generated method stub
		return productosRepository.findById(id).orElse(null);
	}

}
