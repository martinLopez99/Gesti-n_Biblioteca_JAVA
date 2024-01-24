package com.gestor.biblioteca.Controllers;

import com.gestor.biblioteca.DTO.CategoriaListResponse;
import com.gestor.biblioteca.DTO.EditorialListResponse;
import com.gestor.biblioteca.Entities.Categoria;
import com.gestor.biblioteca.Entities.Editorial;
import com.gestor.biblioteca.Services.CategoriaService;
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
@RequestMapping("api-biblioteca-C")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    //http://localhost:8080/api-biblioteca-C/categorias
    @GetMapping(value = "/categotrias")
    public ResponseEntity<?> obtenerLibros(){
        List<CategoriaListResponse> categorias = null;
        Map<String, Object> response = new HashMap<>();

        try {
            categorias = categoriaService.findAll();
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("categorias",categorias);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);

    }

    //http://localhost:8080/api-biblioteca-C/categoria/{id}
    @GetMapping(value = "/editorial/{id}")
    public ResponseEntity<?> obtenerLibro(@PathVariable Long id){
        Categoria categoria = null;
        Map<String, Object> response = new HashMap<>();

        try {
            categoria = categoriaService.findById(id);
        } catch (DataAccessException dataAccessException){
            response.put("mensaje","Error al consultar base de datos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","succed");
        response.put("categoria",categoria);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }


}
