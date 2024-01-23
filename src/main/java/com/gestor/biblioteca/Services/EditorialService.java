package com.gestion.biblioteca.Services;

import com.gestion.biblioteca.Entities.Editorial;
import com.gestion.biblioteca.Repository.EditorialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {

    @Autowired
    EditorialRepository editorialRepository;

    // findAll, findById, save y delete

    public List<Editorial> findAll(){
        return (List<Editorial>) editorialRepository.findAll();
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
