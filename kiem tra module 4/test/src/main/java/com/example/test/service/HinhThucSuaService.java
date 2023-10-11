package com.example.test.service;

import com.example.test.model.HinhThucSua;
import com.example.test.repository.IHinhThucSuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhThucSuaService implements IHinhThucSuaService{
    @Autowired
    IHinhThucSuaRepository hinhThucSuaRepository;

    @Override
    public List<HinhThucSua> getALl() {
        return hinhThucSuaRepository.findAll();
    }
}
