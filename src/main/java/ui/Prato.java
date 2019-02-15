package ui;

import entity.PratoModel;
import service.GeraResposta;

import javax.swing.*;

public class Prato {

    private int width = 400;

    private int height = 200;

    public Prato(int pos, PratoModel pratoModel) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Andre Guariento - PRATO");
        frame.add(getMainLabel(pratoModel));
        frame.add(getCorrectButton(frame));
        frame.add(getProximaPergunta(pos, pratoModel, frame));
        frame.setLocationRelativeTo(null);
        frame.setSize(this.width,this.height);
        frame.setVisible(true);
    }

    private JLabel getMainLabel(PratoModel pratoModel) {
        JLabel label = new JLabel();
        label.setText("Seu prato é " + pratoModel.getNome() + "?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setSize(380, 30);
        label.setLocation(10, 10);
        return label;
    }


    private JButton getCorrectButton(JFrame frame) {
        JButton b = new JButton("OK");
        b.setSize(100, 30);
        b.setLocation(50, 100);
        b.addActionListener(arg0 -> {
            frame.dispose();
            new Final();
        });
        return b;
    }

    private JButton getProximaPergunta(int pos, PratoModel prato, JFrame frame) {
        JButton b = new JButton("Cancelar");
        b.setSize(100, 30);
        b.setLocation(200, 100);

        pos++;
        PratoModel pratoModel = new GeraResposta().get(pos,null, prato.getCategoriaModel().getNome());
        if (pratoModel == null) {
            b.addActionListener(arg0 -> {
                frame.dispose();
                new AdicionarTipo(prato);
            });
        } else {
            System.out.println(pos);
            int finalPos = pos;
            b.addActionListener(arg0 -> {
                frame.dispose();
                new TipoPrato(finalPos, pratoModel);
            });
        }
        return b;
    }
}
