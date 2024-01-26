package org.example;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameManagement.monsters.add(new Monster("Hwa", "Fire", "Attack", 4));
                GameManagement.monsters.add(new Monster("Kobold Bomber", "Water", "Attack", 4));
                GameManagement.monsters.add(new Monster("Racoon", "Fire", "Support", 3));
                GameManagement.monsters.add(new Monster("Veronica", "Light", "Attack", 5));
                new MainFrame();

            }
        });
    }
}