package com.example.email_box.service;

import com.example.email_box.model.Language;

import java.util.List;

public interface ILanguageService {
    List<Language> display();

    Language findID(int id);

    List<String> displayName();

    List<Integer> displaySize();

    void update(Language language, int id);
}
