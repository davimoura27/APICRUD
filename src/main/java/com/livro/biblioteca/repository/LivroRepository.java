package com.livro.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.livro.biblioteca.classe.Livro;
public interface LivroRepository extends JpaRepository<Livro,Long> {

}
