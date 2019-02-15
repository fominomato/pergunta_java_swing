package ui;

import entity.PratoModel;
import service.GeraResposta;

import javax.swing.*;

public class TipoPrato {

    private int width = 400;

    private int height = 200;

    public TipoPrato(int pos, PratoModel prato) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Andre Guariento - Alternativa");
        frame.add(getMainLabel(prato));
        frame.add(getCorrectButton(pos, prato, frame));
        frame.add(getProximaPergunta(pos, prato, frame));
        frame.setLocationRelativeTo(null);
        frame.setSize(this.width,this.height);
        frame.setVisible(true);
    }

    private JLabel getMainLabel(PratoModel pratoModel) {
        JLabel label = new JLabel();
        label.setText("Você pensou no prato do tipo " + pratoModel.getTipo() + "?");
        label.setSize(300, 50);
        label.setLocation(50, 10);
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
            int finalPos = pos;
            b.addActionListener(arg0 -> {
                frame.dispose();
                new TipoPrato(finalPos, pratoModel);
            });
        }
        return b;
    }
}
