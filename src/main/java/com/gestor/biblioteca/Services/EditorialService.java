package com.gestor.biblioteca.Services;

import com.gestor.biblioteca.DTO.EditorialListResponse;
import com.gestor.biblioteca.Entities.Editorial;
import com.gestor.biblioteca.Repository.EditorialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorialService {

    @Autowired
    EditorialRepository editorialRepository;

    // findAll, findById, save y delete

    public List<EditorialListResponse> findAll(){
        List<Editorial> editoriales =  (List<Editorial>) editorialRepository.findAll();
        return editoriales.stream().map(
                editorial -> {
                    return new EditorialListResponse(editorial.getNombre(),editorial.getDireccion(), editorial.getTelefono());
                }
        ).collect(Collectors.toList());
    }

    public Editorial findById(Long id){
        return (Editorial) editorialRepository.findById(id).get();
    }

    @Transactional
    public Editorial save(Editorial editorial){
        if (editorial.getId() != null && !editorialRepository.existsById(editorial.getId()))
            return editorialRepository.save(editorial);

        throw new RuntimeException();
    }

    public boolean delete(Long id){
        if (id != null && editorialRepository.existsById(id)){
            editorialRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }

}
