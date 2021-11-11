package com.nology.FirstAPI.repository;

import com.nology.FirstAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBooksRepository extends JpaRepository<Book, Integer> {

}
