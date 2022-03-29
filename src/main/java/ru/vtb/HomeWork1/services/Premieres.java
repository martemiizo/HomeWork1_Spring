package ru.vtb.HomeWork1.services;

import org.springframework.stereotype.Component;
import ru.vtb.HomeWork1.model.Premiere;

import java.util.ArrayList;
import java.util.List;

@Component
public class Premieres {
    private final List<Premiere> list;

    public Premieres() {
        list = new ArrayList<>();
    }

    public List<Premiere> getList() {
        return list;
    }

}
