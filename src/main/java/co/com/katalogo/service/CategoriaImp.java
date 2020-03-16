package co.com.katalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.katalogo.models.Categoria;
import co.com.katalogo.repository.CategoriaRepository;

@Service
public class CategoriaImp  implements ICategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>)categoriaRepository.findAll();
	}

	@Override
	public Categoria agregar(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria editar(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(id);
	}

	@Override
	public Categoria findById(Integer id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id).orElse(null);
	}

}
