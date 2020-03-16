package co.com.katalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.katalogo.models.Fotos;
import co.com.katalogo.repository.FotosRepository;

@Service
public class FotosImp  implements IFotosService{
	
	@Autowired
	private FotosRepository FotosRepository;

	@Override
	public List<Fotos> listar() {
		// TODO Auto-generated method stub
		return (List<Fotos>)FotosRepository.findAll();
	}

	@Override
	public Fotos Add(Fotos fotos) {
		// TODO Auto-generated method stub
		return FotosRepository.save(fotos);
	}

	@Override
	public Fotos Update(Fotos fotos) {
		// TODO Auto-generated method stub
		return FotosRepository.save(fotos);
	}

	@Override
	public void DeleteById(Integer id) {
		// TODO Auto-generated method stub
		FotosRepository.deleteById(id);
	}

	@Override
	public Fotos FindById(Integer id) {
		// TODO Auto-generated method stub
		return FotosRepository.findById(id).orElse(null);
	}

}
