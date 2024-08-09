package com.livro.biblioteca.controller;

import com.livro.biblioteca.classe.Livro;
import com.livro.biblioteca.repository.LivroRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("livros")
public class LivroController {

@Autowired
private LivroRepository livroRepository;

@GetMapping
public List<Livro> getAllLivros(@RequestBody Livro livro) {
   return livroRepository.findAll();
}
@GetMapping("/{id}")
public Livro getById(@PathVariable Long id){
    return livroRepository.findById(id).orElse(null);
}


@PostMapping
public Livro creat(@RequestBody Livro livro){
    return livroRepository.save(livro);

}

@PutMapping("/{id}")
public Livro update(@PathVariable Long id, @RequestBody Livro livros){
   Livro livro = livroRepository.findById(id).orElse(null);
  if (livro != null) {
   livro.setAutor(livros.getAutor());
   livro.setNome(livros.getNome());
   return livroRepository.save(livro);
    }
    return null;
}
@DeleteMapping("/{id}")
public void deleteLivro(@PathVariable Long id){
    livroRepository.deleteById(id);
}

}