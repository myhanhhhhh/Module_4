package com.example.test.service;

import com.example.test.model.Phieu;
import com.example.test.repository.IPhieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhieuService implements IPhieuService{
    @Autowired
    IPhieuRepository phieuRepository;

    @Override
    public Page<Phieu> findAll(Pageable pageable, String searchName) {
        return phieuRepository.findPhieuByCodeContaining(pageable, searchName);
    }

    @Override
    public void deletePhieu(int deleteId) {
        phieuRepository.deleteById(deleteId);
    }

    @Override
    public void save(Phieu phieu) {
        phieuRepository.save(phieu);
    }
}
