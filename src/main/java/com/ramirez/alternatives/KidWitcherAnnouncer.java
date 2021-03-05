package com.ramirez.alternatives;

import javax.enterprise.inject.Alternative;

@Alternative
public class KidWitcherAnnouncer implements WitcherAnnouncer {
    @Override
    public String announce() {
        return "Witcher is the least violent game of all times, children!";
    }
}
