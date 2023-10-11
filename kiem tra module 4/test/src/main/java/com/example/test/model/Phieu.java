package com.example.test.model;

import javax.persistence.*;

@Entity
public class Phieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "phieu_code")
    private String code;
    @Column(name = "phieu_captain")
    private String captain;
    @Column(name = "phieu_employee")
    private String employee;
    @Column(name = "phieu_content")
    private String content;
    @Column(name = "phieu_startDate")
    private String startDate;
    @Column(name = "phieu_endDate")
    private String endDate;
    @ManyToOne
    @JoinColumn(name = "hinhThucSua_id", referencedColumnName = "id")
    private HinhThucSua hinhThucSua;

    public Phieu() {
    }

    public Phieu(int id, String code, String captain, String employee, String content, String startDate, String endDate, HinhThucSua hinhThucSua) {
        this.id = id;
        this.code = code;
        this.captain = captain;
        this.employee = employee;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hinhThucSua = hinhThucSua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public HinhThucSua getHinhThucSua() {
        return hinhThucSua;
    }

    public void setHinhThucSua(HinhThucSua hinhThucSua) {
        this.hinhThucSua = hinhThucSua;
    }
}
