package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name like :name or id_category = :id", nativeQuery = true)
    Page<Blog> findBlogByNameContaining(Pageable pageable, @Param("name") String searchName, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "insert into blog_management2.blog(description,name,id_category) values (:description,:name,:id_category)", nativeQuery = true)
    void save(@Param("description") String description, @Param("name") String name, @Param("id_category") int id_category);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "delete from blog where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update blog set description = :description, name = :name, id_category = :id where id = :id1", nativeQuery = true)
    void edit(@Param("description") String description, @Param("name") String name, @Param("id") int id, @Param("id1") int id1);

    @Query(value = "select * from blog where name like :name", nativeQuery = true)
    Page<Blog> findBlogByNameContaining(Pageable pageable, @Param("name") String searchName);

    @Query(value = "select * from blog where id_category =:id", nativeQuery = true)
    List<Blog> findByCategory(@Param("id") int id);
}
