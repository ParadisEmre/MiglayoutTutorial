package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonsterTable extends JTable {

    private static Object[][] data;
    private String[] columnNames;
    public MonsterTable() {

        columnNames = new String[]{"Name", "Type", "Attribute", "Star"};
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            SwingUtilities.invokeLater(this::updateTable);
        }, 0, 1, TimeUnit.SECONDS);

    }

    public void updateTable() {
        data = new Object[GameManagement.monsters.size()][4];
        for(int i = 0; i < GameManagement.monsters.size(); i++){
            data[i][0] = GameManagement.monsters.get(i).getName();
            data[i][1] = GameManagement.monsters.get(i).getType();
            data[i][2] = GameManagement.monsters.get(i).getAttribute();
            data[i][3] = GameManagement.monsters.get(i).getStar();
        }
        this.setModel(new DefaultTableModel(data, columnNames));
    }
}
