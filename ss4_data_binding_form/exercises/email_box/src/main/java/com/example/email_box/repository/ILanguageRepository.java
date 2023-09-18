package com.example.email_box.repository;

import com.example.email_box.model.Language;

import java.util.List;

public interface ILanguageRepository {
    List<Language> display();

    Language findID(int id);

    List<String> displayName();

    List<Integer> displaySize();

    void update(Language language,int id);
}
