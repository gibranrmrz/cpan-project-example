package com.ramirez.decorator;

import com.ramirez.service.WitcherManager;
import com.ramirez.service.WitcherService;
import com.ramirez.model.Geralt;
import com.ramirez.model.Witcher;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.List;

@Decorator
public class WitcherServiceDecorator implements WitcherManager {

    @Inject
    @Delegate
    private WitcherService witcherService;

    @Override
    public void add(Witcher witcher) {
        witcherService.add(witcher);
        witcherService.add(new Geralt("Fake Geralt", "Skellige", Witcher.School.CAT));
    }

    @Override
    public List<Witcher> getWitchers() {
        return witcherService.getWitchers();
    }

    @Override
    public void delete(Witcher witcher) {
        witcherService.delete(witcher);
    }
}
