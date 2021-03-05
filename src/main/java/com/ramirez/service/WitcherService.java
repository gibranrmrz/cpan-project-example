package com.ramirez.service;

import com.ramirez.model.Geralt;
import com.ramirez.model.Witcher;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class WitcherService implements WitcherManager {
    private List<Witcher> witchers;

    @PostConstruct
    public void addGeralt() {
        witchers = new ArrayList<>();
        witchers.add(new Geralt("Geralt", "Rivia", Witcher.School.WOLF));

        witchers.add(new Geralt("Gaetan", "Velen", Witcher.School.WOLF));

        witchers.add(new Geralt("Bobby", "Skellige", Witcher.School.WOLF));
    }

    @Override
    public void add(@Observes Witcher witcher) {
        witchers.add(witcher);
    }

    @Override
    public List<Witcher> getWitchers() {
        return witchers;
    }

    @Override
    public void delete(Witcher witcher) {
        Witcher deletedWitcher = witchers.stream().filter(witcher1 ->
                witcher1.getName().equals(witcher.getName())).findFirst().orElse(null);
    }

}
