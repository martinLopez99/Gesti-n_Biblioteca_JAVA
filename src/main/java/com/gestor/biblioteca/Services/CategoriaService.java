package com.gestor.biblioteca.Services;

import com.gestor.biblioteca.DTO.CategoriaListResponse;
import com.gestor.biblioteca.Entities.Categoria;
import com.gestor.biblioteca.Repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaListResponse> findAll(){

        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();

        return categorias.stream().map(
                categoria -> {
                    return new CategoriaListResponse(categoria.getNopmbre(),categoria.getLibros());
                }
        ).collect(Collectors.toList());
    }

    public Categoria findById(Long id){
            return (Categoria) categoriaRepository.findById(id).get();
    }
    @Transactional
    public Categoria save(Categoria categoria){
        if (categoria.getId() != null && !categoriaRepository.existsById(categoria.getId())){
            return (Categoria) categoriaRepository.save(categoria);
        }
        throw new RuntimeException();
    }

    public boolean delete(Long id){
        if (id != null && categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
