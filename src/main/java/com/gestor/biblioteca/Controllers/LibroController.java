package com.gestor.biblioteca.Controllers;

import com.gestor.biblioteca.DTO.LibroListResponse;
import com.gestor.biblioteca.Entities.Libro;
import com.gestor.biblioteca.Services.LibroService;
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
import java.util.Objects;

@RestController
@RequestMapping("api-biblioteca")
public class LibroController {

    @Autowired
    LibroService libroService;

    //http://localhost:8080/api-biblioteca/libros
    @GetMapping(value = "/libros")
    public ResponseEntity<?> obtenerLibros(){
        List<LibroListResponse> libros = null;
        Map<String, Object> response = new HashMap<>();

        try {
            libros = libroService.findAll();
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("libros",libros);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);

    }

    //http://localhost:8080/api-biblioteca/libro/{id}
    @GetMapping(value = "/libro/{id}")
    public ResponseEntity<?> obtenerLibro(@PathVariable Long id){
        Libro libro = null;
        Map<String, Object> response = new HashMap<>();

        try {
            libro = libroService.findAllById(id);
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("libro",libro);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

}
