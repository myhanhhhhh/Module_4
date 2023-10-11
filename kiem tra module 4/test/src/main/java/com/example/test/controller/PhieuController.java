package com.example.test.controller;

import com.example.test.dto.PhieuDto;
import com.example.test.model.HinhThucSua;
import com.example.test.model.Phieu;
import com.example.test.service.IHinhThucSuaService;
import com.example.test.service.IPhieuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/phieu")
public class PhieuController {
    @Autowired
    IPhieuService phieuService;
    @Autowired
    IHinhThucSuaService hinhThucSuaService;

    @ModelAttribute("typeEdit")
    List<HinhThucSua> getAll() {
        return hinhThucSuaService.getALl();
    }

    @GetMapping("")
    String showList(Model model, @RequestParam(defaultValue = "0") int page,
                    @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("code").ascending());
        Page<Phieu> phieuPage = phieuService.findAll(pageable, searchName);
        model.addAttribute("phieuPage", phieuPage);
        model.addAttribute("searchName", searchName);
        return "list";
    }


    @PostMapping("/delete")
    String deletePig(@RequestParam int deleteId, RedirectAttributes redirect) {
        redirect.addFlashAttribute("mess", "Xóa thành công!");
        phieuService.deletePhieu(deleteId);
        return "redirect:/phieu";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("phieuDto", new PhieuDto());
        return "create";
    }

    @PostMapping("/create")
    public String createNew(@Validated PhieuDto phieuDto, BindingResult bindingResult, Model model, RedirectAttributes redirect) {
        new PhieuDto().validate(phieuDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("phieuDto", phieuDto);
            return "/create";
        } else {
            Phieu phieu = new Phieu();
            BeanUtils.copyProperties(phieuDto, phieu);
            phieuService.save(phieu);
            redirect.addFlashAttribute("mess", "Thêm mới thành công!");
            return "redirect:/phieu";
        }
    }
}
