package com.example.song.controller;

import com.example.song.dto.SongDto;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showList(Model model) {
        List<Song> list = songService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirect) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.add(song);
            redirect.addFlashAttribute("mess", "Create successful");
            return "redirect:/song";
        }
    }

    @GetMapping("/update/{id}")
    public String showEdit(Model model, @RequestParam int id) {
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        if (songDto == null) {
            model.addAttribute("mess", "Song don't exist");
        } else {
            model.addAttribute("songDto", songDto);
        }
        return "update";

    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute SongDto songdto, BindingResult bindingResult, RedirectAttributes redirect) {
        new SongDto().validate(songdto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songdto, song);
        songService.update(song);
        redirect.addFlashAttribute("mess", "Update successful");
        return "redirect:/song";
    }
}
