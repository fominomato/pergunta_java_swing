package ui;

import service.GeraResposta;

import javax.swing.*;

public class Principal {

    private int width = 400;

    private int height = 200;

    public Principal() {
        new GeraResposta().init();
        JFrame frame = new JFrame();
        frame.setTitle("Andre Guariento - Jogo");
        frame.add(this.getInitButton());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(this.width,this.height);
        frame.setVisible(true);
    }

    private JButton getInitButton() {
        JButton b = new JButton("Iniciar");
        b.setSize(100, 50);
        b.setLocation(100, 100);
        b.addActionListener(arg0 -> {
            new Primeira(0,"massa", "Principal");
        });
        return b;
    }

    public static void main(String[] args) {
        new Principal();
    }
}
