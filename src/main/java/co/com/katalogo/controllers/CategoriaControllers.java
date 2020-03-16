package co.com.katalogo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import co.com.katalogo.models.Categoria;
import co.com.katalogo.service.ICategoriaService;

@RestController
@RequestMapping("/categoria")

public class CategoriaControllers {

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> categoria = categoriaService.findAll();
		if (categoria.isEmpty()) {
			return new ResponseEntity<List<Categoria>>(categoria, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Categoria>>(categoria, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Categoria getParameter(@PathVariable Integer id) {
		return categoriaService.findById(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/grabar")
	public ResponseEntity<Categoria> grabar(@RequestBody Categoria categoria) {
		if (categoriaService.agregar(categoria) != null) {
			categoriaService.agregar(categoria);
			return new ResponseEntity<Categoria>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Categoria>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("borrar/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		categoriaService.borrar(id);
	}

	@PutMapping("/editar/{id}")
	public Categoria editar(@PathVariable Integer id, @RequestBody Categoria categoria) {
		categoria.setIdCategoria(id);
		return categoriaService.editar(categoria);
	}

}
