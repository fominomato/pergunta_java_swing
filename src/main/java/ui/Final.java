package ui;

import javax.swing.*;

public class Final {
    private int width = 400;

    private int height = 200;

    public Final() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Andre Guariento - Final");
        frame.add(getMainLabel());
        frame.add(getFecharButton(frame));
        frame.setLocationRelativeTo(null);
        frame.setSize(this.width,this.height);
        frame.setVisible(true);
    }

    private JLabel getMainLabel() {
        JLabel label = new JLabel();
        label.setText("Uhuu acertei");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setSize(380, 30);
        label.setLocation(10, 10);
        return label;
    }

    private JButton getFecharButton(JFrame frame) {
        JButton b = new JButton("Fechar");
        b.setSize(100, 30);
        b.setLocation(100, 100);
        b.addActionListener(arg0 -> {
            frame.dispose();
        });
        return b;
    }
}
