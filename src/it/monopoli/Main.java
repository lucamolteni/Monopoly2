package it.monopoli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main (String[] args){

        final Game monopoly = new Game(new Board());
        monopoly.addPlayer("Mino");
        monopoly.addPlayer("Pino");
        monopoly.addPlayer("Lino");
        monopoly.addPlayer("Gino");

        JFrame frame = new JFrame("Test");
        frame.setVisible(true);
        frame.setSize(1400,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Container panel = frame.getContentPane();

        JButton button = new JButton("Next turn");

        final JTextArea area = new JTextArea(40, 30);
        final JScrollPane scrollPane = new JScrollPane(area);
        panel.add(button, BorderLayout.PAGE_END);
        panel.add(scrollPane, BorderLayout.PAGE_START);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameEvent event = monopoly.nextTurn(new RealDice());
                area.setText(area.getText() + event.getDiceRoll() + "\n");
                area.setText(area.getText() + event.getMovement() + "\n");
            }
        });

    }
}
