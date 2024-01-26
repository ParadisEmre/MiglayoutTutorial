package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {

    private TabbedPane tabbedPane;
    //private Toolbar toolbar;

    public MainFrame(){

        super("Hello BRAH");

        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.tabbedPane = new TabbedPane();

        this.add(tabbedPane, BorderLayout.CENTER);

    }
}
