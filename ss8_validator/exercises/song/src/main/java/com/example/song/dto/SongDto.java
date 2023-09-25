package com.example.song.dto;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SongDto implements Validator {
    private String name;
    private String singer;
    private String type;

    public SongDto() {
    }

    public SongDto(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getName().equals("")) {
            errors.rejectValue("name", null, "Require not empty");
        } else if (!songDto.getName().matches("^[^@;,.=+…-]+$")) {
            errors.rejectValue("name", null, "Don't contain special characters");
        } else if (songDto.getName().length() > 800) {
            errors.rejectValue("name",null,"Name mustn't over 800 characters ");
        }

        if (songDto.getSinger().equals("")) {
            errors.rejectValue("name", null, "Require not empty");
        } else if (!songDto.getSinger().matches("^[^@;,.=+…-]+$")) {
            errors.rejectValue("name", null, "Don't contain special characters");
        } else if (songDto.getSinger().length() > 300) {
            errors.rejectValue("name",null,"Singer mustn't over 300 characters ");
        }

        if (songDto.getType().equals("")) {
            errors.rejectValue("name", null, "Require not empty");
        } else if (!songDto.getType().matches("^[^@;.=+…-]+$")) {
            errors.rejectValue("name", null, "Don't contain special characters");
        } else if (songDto.getType().length() > 1000) {
            errors.rejectValue("name",null,"Type mustn't over 1000 characters ");
        }
    }
}
