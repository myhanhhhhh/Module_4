package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category", nativeQuery = true)
    List<Category> findAll();

    @Transactional
    @Modifying
    @Query(value = "insert into category(name) values (:name)", nativeQuery = true)
    void save(@Param("name") String name);

    @Query(value = "select * from category where id_category = :id", nativeQuery = true)
    Category findById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update category set name = :name where id_category = :id", nativeQuery = true)
    void edit(@Param("name") String name, @Param("id") int id);
    @Transactional
    @Modifying
    @Query(value = "delete from category where id_category = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);
}