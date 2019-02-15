package ui;

import entity.PratoModel;
import service.GeraResposta;

import javax.swing.*;

public class Primeira {

    private int width = 400;

    private int height = 200;

    public Primeira(int pos, String tipo, String categoria) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Andre Guariento - Tomada decisao");
        PratoModel pratoModel = new GeraResposta().get(pos, tipo, categoria);
        frame.add(getMainLabel(pratoModel));
        frame.add(getCorrectButton(pos, pratoModel, frame));
        frame.add(getBotaoCancela(pos, pratoModel, frame));
        frame.setLocationRelativeTo(null);
        frame.setSize(this.width,this.height);
        frame.setVisible(true);
    }

    private JLabel getMainLabel(PratoModel pratoModel) {
        JLabel label = new JLabel();
        label.setText("Você pensou no prato do tipo " + pratoModel.getTipo() + "?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setSize(380, 30);
        label.setLocation(10, 10);
        return label;
    }

    private JButton getCorrectButton(int pos, PratoModel pratoModel, JFrame frame) {
        JButton b = new JButton("OK");
        b.setSize(100, 30);
        b.setLocation(50, 100);
        b.addActionListener(arg0 -> {
            frame.dispose();
            new Prato(pos, pratoModel);
        });
        return b;
    }

    private JButton getBotaoCancela(int pos, PratoModel prato, JFrame frame) {
        JButton b = new JButton("Cancelar");
        b.setSize(100, 30);
        b.setLocation(200, 100);

        PratoModel pratoModel = new GeraResposta().get(pos,null,"Alternativo");
        if (pratoModel == null) {
            b.addActionListener(arg0 -> {
                frame.dispose();
                new AdicionarTipo(pratoModel);
            });
        } else {
            b.addActionListener(arg0 -> {
                frame.dispose();
                new Prato(pos, pratoModel);
            });
        }
        return b;
    }
}
