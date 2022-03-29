package ru.vtb.HomeWork1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtb.HomeWork1.model.Premiere;

import java.util.List;

@Service
public class PremiereService {

    private final Premieres premieres;

    @Autowired
    public PremiereService(Premieres premieres) {
        this.premieres = premieres;
    }

    public void addPremiere(Premiere premiere) {
        premieres.getList().add(premiere);
    }

    public void deletePremiere(String premiereName) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                premieres.getList().remove(p);
                return;
            }
        }
    }


    public void changePremiere(String premiereName, String newDescription,
                               Integer newAgeCategory, Integer newNumberOfSeats) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                if (newDescription != null) {
                    p.setDescription(newDescription);
                }
                if (newAgeCategory > 0) {
                    p.setAgeCategory(newAgeCategory);
                }
                if (newAgeCategory >= 1) {
                    p.setAgeCategory(newAgeCategory);
                }
                if (newNumberOfSeats >= 1) {
                    p.setNumberOfSeats(newNumberOfSeats);
                }
            }
        }
    }


    public boolean buyTickets(String premiereName, Integer numTikets) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName) && p.getNumberOfSeats() - numTikets >= 0) {
                p.setNumberOfSeats(p.getNumberOfSeats() - numTikets);
                return true;
            }
        }
        return false;
    }

    public void returnTickets(String premiereName, Integer numTikets) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                p.setNumberOfSeats(p.getNumberOfSeats() + numTikets);
            }
        }
    }

    public List<Premiere> getPremieres() {
        return premieres.getList();
    }

    public int getListPremiereSize() {
        return premieres.getList().size();
    }

    public String getPremeiresInfo(String premiereName) {
        StringBuilder sb = new StringBuilder();
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                return p.toString();
            } else {
                sb.append(p.toString()).append("\n");
            }

        }
        return sb.toString();
    }
}
