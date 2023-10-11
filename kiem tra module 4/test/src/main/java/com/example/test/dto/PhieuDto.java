package com.example.test.dto;

import com.example.test.model.HinhThucSua;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PhieuDto implements Validator {

    private String code;

    private String captain;

    private String employee;

    private String content;

    private String startDate;

    private String endDate;

    private HinhThucSua hinhThucSua;

    public PhieuDto() {
    }

    public PhieuDto(String code, String captain, String employee, String content, String startDate, String endDate, HinhThucSua hinhThucSua) {
        this.code = code;
        this.captain = captain;
        this.employee = employee;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hinhThucSua = hinhThucSua;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        PhieuDto phieuDto = (PhieuDto) target;
        if (phieuDto.captain.equals("")){
            errors.rejectValue("captain", "invalid", "Không được để trống");
        }
        if (phieuDto.code.equals("")){
            errors.rejectValue("code", "invalid", "Không được để trống");
        }
        if (phieuDto.content.equals("")){
            errors.rejectValue("content", "invalid", "Không được để trống");
        }
        if (phieuDto.employee.equals("")){
            errors.rejectValue("employee", "invalid", "Không được để trống");
        }
        if (phieuDto.endDate.equals("")){
            errors.rejectValue("endDate", "invalid", "Không được để trống");
        }
        if (phieuDto.startDate.equals("")){
            errors.rejectValue("startDate", "invalid", "Không được để trống");
        }
        if (phieuDto.hinhThucSua.equals("")){
            errors.rejectValue("hinhThucSua", "invalid", "Không được để trống");
        }
//        if (phieuDto.hinhThucSua.getName().equals("")){
//            errors.rejectValue("hinhThucSua", "invalid", "Không được để trống");
//        }
//        if (!pigDto.code.matches("^MH-[0-9]{1,3}")) {
//            errors.rejectValue("code", "invalid", "Code Regex: MH-XXX (X: 0-9)");
//        }
//        if (pigDto.inputWeight <= 10) {
//            errors.rejectValue("inputWeight", "invalid", "Weight Must More Than 10");
//        }
    }
}
