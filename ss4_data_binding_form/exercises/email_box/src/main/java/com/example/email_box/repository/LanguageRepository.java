package com.example.email_box.repository;

import com.example.email_box.model.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LanguageRepository implements ILanguageRepository {
    private static List<Language> languages = new ArrayList<>();

    static {
        languages.add(new Language(1, "English", 5, "Enable spams filter", "OK"));
        languages.add(new Language(2, "Vietnamese", 10, "Disable spams filter", "NOK"));
        languages.add(new Language(3, "Japanese", 15, "Enable spams filter", "OK"));
        languages.add(new Language(4, "Chinese", 20, "Disable spams filter", "NOK"));
    }

    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("English");
        stringList.add("Vietnamese");
        stringList.add("Japanese");
        stringList.add("Chinese");
    }

    private static List<Integer> integerList = new ArrayList<>();

    static {
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        integerList.add(20);
        integerList.add(50);
    }

    @Override
    public List<Language> display() {
        return languages;
    }

    @Override
    public Language findID(int id) {
        return languages.get(id - 1);
    }

    @Override
    public List<String> displayName() {
        return stringList;
    }

    @Override
    public List<Integer> displaySize() {
        return integerList;
    }

    @Override
    public void update(Language language, int id) {
        languages.set(id - 1, language);
    }
}
