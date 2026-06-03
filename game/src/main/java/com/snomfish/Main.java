package com.snomfish;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        GamePanel gp = new GamePanel();


        JFrame window = new JFrame();

        window.setTitle("game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        //window.setSize(800, 600); // Set preferred size
        window.add(gp);

        window.pack(); // Adjust window size based on the preferred size of components
        window.setLocationRelativeTo(null); // Center window
        window.setVisible(true);

        gp.startGameThread();
    }

}