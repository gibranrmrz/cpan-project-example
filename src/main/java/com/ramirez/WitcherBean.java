package com.ramirez;

import com.ramirez.alternatives.WitcherAnnouncer;
import com.ramirez.interceptor.Logged;
import com.ramirez.model.Geralt;
import com.ramirez.model.Witcher;
import com.ramirez.service.WitcherManager;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

import static com.ramirez.model.Witcher.School.BEAR;

@Model
public class WitcherBean {
    private String name;
    private String city;
    private String school;
    private String announcementMessage;

    @Inject private Event<Witcher> addWitcherEvent;

    @Inject
    private WitcherAnnouncer announcer;

    @Inject
    private WitcherManager witcherService;

    @PostConstruct
    public void constructMessage() {
        announcementMessage = announcer.announce();
    }

    public String getAnnouncementMessage() {
        return announcementMessage;
    }

    public List<Witcher> getWitchers() {
        return witcherService.getWitchers();
    }

    @Logged
    public void addWitcher() {
        Witcher.School defaultSchool = Witcher.School.WOLF;
        if (school.equals("CAT")) {
            defaultSchool = Witcher.School.CAT;
        }
        if (school.equals("BEAR")) {
            defaultSchool = BEAR;
        }
        Witcher witcher = new Geralt(name, city, defaultSchool);
        witcherService.add(witcher);
        addWitcherEvent.fire(witcher);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
