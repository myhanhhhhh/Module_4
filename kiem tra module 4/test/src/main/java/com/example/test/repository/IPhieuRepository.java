package com.example.test.repository;

import com.example.test.model.Phieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhieuRepository extends JpaRepository<Phieu, Integer> {
    Page<Phieu> findPhieuByCodeContaining(Pageable pageable, String searchName);
}
