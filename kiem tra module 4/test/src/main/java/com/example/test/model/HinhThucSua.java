package com.example.test.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class HinhThucSua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "hinhThucSua")
    private Set<Phieu> phieuSet;

    public HinhThucSua() {
    }

    public HinhThucSua(int id, String name, Set<Phieu> phieuSet) {
        this.id = id;
        this.name = name;
        this.phieuSet = phieuSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Phieu> getPhieuSet() {
        return phieuSet;
    }

    public void setPhieuSet(Set<Phieu> phieuSet) {
        this.phieuSet = phieuSet;
    }
}
