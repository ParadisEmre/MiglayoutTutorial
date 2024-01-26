package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManagement {
    public static List<Scroll> scrolls = new ArrayList<>();
    public static List<Monster> monsters = new ArrayList<>();
    public static String summon(){
        Scroll scroll = new Scroll("");
        Monster mons = monsters.get(new Random().nextInt(monsters.size()));
        if(!scrolls.isEmpty()){
            scroll = scrolls.remove(0);
            monsters.add(mons);
            return "You got " + mons.getName() + " from " + scroll.getName() + "\n";

        }
        return "You dont have any scrolls.\n";
    }

    public static void dropScroll(){
        String ms = "Mystical Scroll";
        String us = "Unknown Scroll";
        String ld = "Light/Dark Scroll";
        String[] arr = {ms, us, ld};

        scrolls.add(new Scroll(arr[new Random().nextInt(3)]));
    }

}
