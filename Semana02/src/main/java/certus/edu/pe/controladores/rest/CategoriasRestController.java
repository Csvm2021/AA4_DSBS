package certus.edu.pe.controladores.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import certus.edu.pe.modelo.Categorias;
import certus.edu.pe.servicios.CategoriasServicio;
@RestController
@RequestMapping("/rest/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriasRestController {

	@Autowired
	private CategoriasServicio servicio;

	@GetMapping
	public ResponseEntity<Object> buscarTodo() {
		List<Categorias> listaCategoria = servicio.buscarTodo();
		
			System.out.println("Lista de Categoria : " + listaCategoria);
		return new ResponseEntity<>(listaCategoria, HttpStatus.OK);
	}
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	@ResponseBody
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		Categorias categoria= servicio.buscarPorId(id);
		if (categoria == null)
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Categoria no encontrada, id porpocionado no es correcto");
		return new ResponseEntity<Object>(categoria,HttpStatus.OK);
	}
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } 
			)
	public ResponseEntity <Object> crear (@RequestBody Categorias categoria){
		
		servicio.crear(categoria);
		return new ResponseEntity<Object>("Categoria creada correctamente", HttpStatus.OK);
		}

	@PutMapping (value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
	consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	)
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Categorias categoria){
		
		servicio.actualizar(categoria);
		return new ResponseEntity<Object>("Categoria actualizada correctamente", HttpStatus.OK);		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
	    servicio.eliminarCategorias(id);
	    return new ResponseEntity<Object>("La categoria ha sido eliminada correctamente", HttpStatus.OK);
	}

}
