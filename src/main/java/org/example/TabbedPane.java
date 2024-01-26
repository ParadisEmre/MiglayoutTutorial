package org.example;

import javax.swing.*;

public class TabbedPane extends JTabbedPane {
    private SelectionPanel selectionPanel;
    private MonsterTable monsterTable;
    public TabbedPane(){
        this.selectionPanel = new SelectionPanel();
        this.monsterTable = new MonsterTable();

        selectionPanel.setListener(() -> {
            this.monsterTable.updateTable();
        });

        this.setBounds(50, 50, 400, 400);
        this.add("Summoners War", selectionPanel);
        this.add("Monster Table", monsterTable);
    }
}
