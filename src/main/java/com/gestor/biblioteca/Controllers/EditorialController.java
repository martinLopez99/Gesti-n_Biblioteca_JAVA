package com.gestor.biblioteca.Controllers;

import com.gestor.biblioteca.DTO.EditorialListResponse;
import com.gestor.biblioteca.DTO.LibroListResponse;
import com.gestor.biblioteca.Entities.Editorial;
import com.gestor.biblioteca.Entities.Libro;
import com.gestor.biblioteca.Services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api-biblioteca-E")
public class EditorialController {
    @Autowired
    EditorialService editorialService;

    //http://localhost:8080/api-biblioteca-E/editoriales
    @GetMapping(value = "/editoriales")
    public ResponseEntity<?> obtenerLibros(){
        List<EditorialListResponse> editoriales = null;
        Map<String, Object> response = new HashMap<>();

        try {
            editoriales = editorialService.findAll();
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("editoriales",editoriales);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);

    }

    //http://localhost:8080/api-biblioteca-E/editorial/{id}
    @GetMapping(value = "/editorial/{id}")
    public ResponseEntity<?> obtenerLibro(@PathVariable Long id){
        Editorial editorial = null;
        Map<String, Object> response = new HashMap<>();

        try {
            editorial = editorialService.findById(id);
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("editorial",editorial);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }


}
