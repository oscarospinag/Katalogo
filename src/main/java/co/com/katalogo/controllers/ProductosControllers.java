package co.com.katalogo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import co.com.katalogo.models.Productos;
import co.com.katalogo.service.IProductosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/productos")
public class ProductosControllers {

	@Autowired
	private IProductosService iProductosService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Productos>> findAll() {
		List<Productos> productos = iProductosService.findAll();
		if (productos.isEmpty()) {
			return new ResponseEntity<List<Productos>>(productos, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Productos>>(productos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Productos getParameter(@PathVariable Integer id) {
		return iProductosService.findById(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/grabar")
	public ResponseEntity<Productos> grabar(@RequestBody Productos productos) {
		if (iProductosService.agregar(productos) != null) {
			return new ResponseEntity<Productos>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Productos>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("borrar/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		iProductosService.borrar(id);
	}

	@PutMapping("/editar/{id}")
	public Productos editar(@PathVariable Integer id, @RequestBody Productos productos) {
		productos.setIdProducto(id);
		return iProductosService.editar(productos);
	}
	
	
}
