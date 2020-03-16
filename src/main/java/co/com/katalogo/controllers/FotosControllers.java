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
import co.com.katalogo.models.Fotos;
import co.com.katalogo.service.IFotosService;

@RestController
@RequestMapping("/fotos")
public class FotosControllers {

	@Autowired
	private IFotosService fotosService;

	@GetMapping
	public ResponseEntity<List<Fotos>> findAll() {
		List<Fotos> fotos = fotosService.listar();
		if (fotos.isEmpty()) {
			return new ResponseEntity<List<Fotos>>(fotos, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Fotos>>(fotos, HttpStatus.OK);
	}

	@PostMapping("/grabar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Fotos> add(@RequestBody Fotos fotos) {
		if (fotosService.Add(fotos) != null) {
			return new ResponseEntity<Fotos>(fotos, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Fotos>(fotos, HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("borrar/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		fotosService.DeleteById(id);
	}

	@PutMapping("/editar/{id}")
	public Fotos editar(@PathVariable Integer id, @RequestBody Fotos fotos) {
		fotos.setIdFoto(id);
		return fotosService.Update(fotos);
	}
}
