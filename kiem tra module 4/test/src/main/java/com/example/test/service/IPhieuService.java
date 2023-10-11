package com.example.test.service;

import com.example.test.model.Phieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhieuService {
    Page<Phieu> findAll(Pageable pageable, String searchName);

    void deletePhieu(int deleteId);

    void save(Phieu phieu);
}
