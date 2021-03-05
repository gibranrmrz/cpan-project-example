package com.ramirez.service;

import com.ramirez.model.Witcher;

import java.util.List;

public interface WitcherManager {
    void add(Witcher witcher);

    List<Witcher> getWitchers();
    void delete(Witcher witcher);
}
