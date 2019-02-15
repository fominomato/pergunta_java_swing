package ui;

import entity.PratoModel;
import service.GeraResposta;

import javax.swing.*;

public class AdicionarPrato {

    private int width = 400;

    private int height = 200;

    private static JTextField input;

    public AdicionarPrato(PratoModel prato, String tipo) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Andre Guariento - AdicionarTipo Prato");
        frame.add(getMainLabel(tipo, prato));
        frame.add(getInputText());
        frame.add(getCancelaButton(frame, tipo, prato));
        frame.add(getAdicionaButton(frame, tipo, prato));
        frame.setLocationRelativeTo(null);
        frame.setSize(this.width, this.height);
        frame.setVisible(true);
    }

    private JLabel getMainLabel(String tipo, PratoModel prato) {
        JLabel label = new JLabel();
        label.setText(tipo + " é ______  mas, " + prato.getNome() + " não.");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setSize(380, 30);
        label.setLocation(10, 10);
        return label;
    }

    private JTextField  getInputText() {
        input = new JTextField(100);
        input.setSize(350, 30);
        input.setLocation(25, 50);
        return input;
    }

    private JButton getAdicionaButton(JFrame frame, String tipo, PratoModel prato) {
        JButton b = new JButton("OK");
        b.setSize(100, 30);
        b.setLocation(50, 100);
        b.addActionListener(arg0 -> {
            frame.dispose();
            new GeraResposta().add(input.getText(), tipo, prato.getCategoriaModel().getNome());
        });
        return b;
    }

    private JButton getCancelaButton(JFrame frame, String tipo, PratoModel prato) {
        JButton b = new JButton("Cancelar");
        b.setSize(100, 30);
        b.setLocation(175, 100);
        b.addActionListener(arg0 -> {
            frame.dispose();
            new GeraResposta().add(input.getText(), tipo, prato.getCategoriaModel().getNome());
        });
        return b;
    }
}
