package ru.vtb.HomeWork1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtb.HomeWork1.model.Premiere;
import ru.vtb.HomeWork1.services.PremiereService;

@SpringBootApplication
public class AviasalesSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AviasalesSpringApplication.class, args);

        PremiereService premiereService = ctx.getBean(PremiereService.class);

        //Добавили 2-е премьеры
        System.out.println("---------Добавили 2-е премьеры-------------");
        premiereService.addPremiere(new Premiere("Брат 2", "Русский криминальный боевик'", 18, 100));
        premiereService.addPremiere(new Premiere("Маугли", "Мультфильм", 3, 50));

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        //Изменили кол-во доступных мест в премьере
        System.out.println("---------Изменили кол-во доступных мест в премьере \"Брат 2\"-------------");
        premiereService.changePremiere("Брат 2", null, 0, 90);
        //Добавлена новая премьера
        System.out.println("---------Добавлена новая премьера \"Вампиры\"-------------");
        premiereService.addPremiere(new Premiere("Вампиры", "Вампирская сага", 16, 60));

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        //Удалена премьера
        System.out.println("---------Удалена премьера \"Брат 2\"-------------");
        premiereService.deletePremiere("Брат 2");

        //Куплено 5 билетов на премьеру
        System.out.println("---------Куплено 5 билетов на премьеру \"Вампиры\"-------------");
        if (!premiereService.buyTickets("Вампиры", 5)) {
            System.out.println("Все билеты на премьру \"Вампиры\" выкуплены");
        }

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        //Вернули 2 билета на премьеру
        System.out.println("---------Вернули 2 билета на премьеру \"Вампиры\"-------------");
        premiereService.returnTickets("Вампиры", 2);

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        //Вывод информации о премьере
        System.out.println("---------Вывод информации о премьере \"Вампиры\"-------------");
        System.out.println(premiereService.getPremeiresInfo("Вампиры"));

        //Вывод информации обо всех премьерах
        System.out.println("---------Вывод информации обо всех премьерах-------------");
        System.out.println(premiereService.getPremeiresInfo(null));

    }

}
