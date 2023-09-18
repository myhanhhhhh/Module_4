package com.example.email_box.service;


import com.example.email_box.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService implements ILanguageService {
    @Autowired
    private LanguageService languageRepo;

    @Override
    public List<Language> display() {
        return languageRepo.display();
    }

    @Override
    public Language findID(int id) {
        return languageRepo.findID(id);
    }

    @Override
    public List<String> displayName() {
        return languageRepo.displayName();
    }

    @Override
    public List<Integer> displaySize() {
        return languageRepo.displaySize();
    }

    @Override
    public void update(Language language, int id) {
        languageRepo.update(language, id);
    }
}
