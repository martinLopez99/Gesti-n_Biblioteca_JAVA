package com.gestor.biblioteca.Controllers;

import com.gestor.biblioteca.DTO.AutorListResponse;
import com.gestor.biblioteca.Entities.Autor;
import com.gestor.biblioteca.Services.AutorService;
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
@RequestMapping("api-biblioteca-A")
public class AutorController {

    @Autowired
    AutorService autorService;

    //http://localhost:8080/api-biblioteca-A/autores
    @GetMapping(value = "/autoress")
    public ResponseEntity<?> obtenerAutores(){
        List<AutorListResponse> autores = null;
        Map<String, Object> response = new HashMap<>();

        try {
            autores = autorService.obtenerAutores();
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("autores",autores);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);

    }

    //http://localhost:8080/api-biblioteca-A/autor/{id}
    @GetMapping(value = "/autor/{id}")
    public ResponseEntity<?> obtenerAutor(@PathVariable Long id){
        Autor autor = null;
        Map<String, Object> response = new HashMap<>();

        try {
            autor = autorService.obtenerAutor(id);
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("autor",autor);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }
}
