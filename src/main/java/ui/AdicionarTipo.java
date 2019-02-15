package ui;

import entity.PratoModel;

import javax.swing.*;

public class AdicionarTipo {

    private int width = 400;

    private int height = 200;

    private static JTextField input;

    public AdicionarTipo(PratoModel prato) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Andre Guariento - AdicionarTipo");
        frame.add(getMainLabel());
        frame.add(getInputText());
        frame.add(getCancelaButton(frame, prato));
        frame.add(getAdicionaButton(frame, prato));
        frame.setLocationRelativeTo(null);
        frame.setSize(this.width, this.height);
        frame.setVisible(true);
    }

    private JLabel getMainLabel() {
        JLabel label = new JLabel();
        label.setText("Qual tipo de prato deseja adicionar?");
        label.setSize(300, 50);
        label.setLocation(50, 10);
        return label;
    }

    private JTextField  getInputText() {
        input = new JTextField(20);
        input.setSize(350, 30);
        input.setLocation(25, 50);
        return input;
    }

    private JButton getAdicionaButton(JFrame frame, PratoModel prato) {
        JButton b = new JButton("OK");
        b.setSize(100, 30);
        b.setLocation(50, 100);
        b.addActionListener(arg0 -> {
            frame.dispose();
            new AdicionarPrato(prato, input.getText());
        });
        return b;
    }

    private JButton getCancelaButton(JFrame frame, PratoModel prato) {
        JButton b = new JButton("Cancelar");
        b.setSize(100, 30);
        b.setLocation(175, 100);
        b.addActionListener(arg0 -> {
            frame.dispose();
            new AdicionarPrato(prato, input.getText());
        });
        return b;
    }
}
