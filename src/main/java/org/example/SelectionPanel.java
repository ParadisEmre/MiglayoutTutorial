package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.*;

public class SelectionPanel extends JPanel{

    TextArea textArea;
    JButton fightButton;
    JButton summonButton;
    JButton monstersButton;
    JComboBox<String> missions;
    JButton communityButton;
    JRadioButton darkMode;
    JLabel label;

    FightButtonListener listener;
    int count;
    public SelectionPanel(){
        label = new JLabel("hey");
        count = 0;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        label.setFont(new Font("Arial", Font.BOLD, 20));

        executor.scheduleAtFixedRate(() -> {
            System.out.println(++count);
            SwingUtilities.invokeLater(() -> {
                label.setText(count +"");
                label.setForeground(count % 2 == 0 ? Color.RED : Color.GREEN);
            });
        }, 0, 1, TimeUnit.SECONDS);


        fightButton = new JButton("Fight");
        textArea = new TextArea(4, 5);
        fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Continuous Fight Has Started...\n");
                fightButton.setEnabled(false); // Disable the button temporarily
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameManagement.dropScroll();
                        textArea.append("You dropped: " + GameManagement.scrolls.get(GameManagement.scrolls.size()-1).getName() + "\n");
                        fightButton.setEnabled(true); // Re-enable the button
                    }
                });
                timer.setInitialDelay(3000); // Set the initial delay before starting the timer
                timer.setRepeats(false); // Only fire the timer once
                timer.start();
            }
        });
        summonButton = new JButton("Summon");
        summonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(GameManagement.summon());
                if(listener != null){
                    listener.OnClickFightButtonEvent();
                }
            }
        });

        monstersButton = new JButton("Monsters");
        monstersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Monster mons : GameManagement.monsters){
                    textArea.append(mons.toString());
                }

            }
        });

        missions = new JComboBox<>(new String[]{"FARM A WHOLE LOT BRUH", "SUMMON A BUNCH"});
        missions.addActionListener(e -> {
            if(missions.getSelectedIndex() == 0){
                textArea.append("Do something 0 \n");
            }
            else if(missions.getSelectedIndex() == 1){
                textArea.append("Do something 1 \n");
            }
        });

        communityButton = new JButton("Community");
        communityButton.addActionListener(this::onCommunityButtonClick);

        darkMode = new JRadioButton();
        darkMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (darkMode.isSelected()) {
                    setBackground(Color.BLACK);
                    setForeground(Color.WHITE);
                    textArea.setBackground(Color.BLACK);
                    textArea.setForeground(Color.WHITE);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(Color.BLACK);
                    textArea.setBackground(Color.WHITE);
                    textArea.setForeground(Color.BLACK);

                }

            }
        });

        this.setLayout(new MigLayout("insets 50 50 50 50, fill", "[]20[]20[]", "[]30[]30[]"));

        this.add(fightButton, "width :70:, height :40:, center"); // Span 2 columns
        this.add(summonButton, "width :70:, height :40:, center");
        this.add(monstersButton,"width :70:, height :40:, center");
        this.add(missions,"width :70:, height :40:, center"); // Span 3 columns
        this.add(communityButton,"width :70:, height :40:, center, wrap"); // Span all columns, grow horizontally
        this.add(textArea, "width :600:, height :400:, span 8");
        this.add(darkMode);
        this.add(label);
    }

    public void onCommunityButtonClick(ActionEvent e){
        try {
            Desktop.getDesktop().browse(new URI("https://sw.com2us.com/en/skyarena"));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    public FightButtonListener getListener(){
        return listener;
    }

    public void setListener(FightButtonListener fb){
        listener = fb;
    }
}
