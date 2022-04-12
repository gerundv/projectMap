package me.gerundv;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class main extends JPanel implements Runnable {

    private BufferedImage canvas;
    int width = 640;
    int height = 480;

    public main() {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.WHITE);
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();
        Graphics2D g2 = (Graphics2D) g;
        for (int y = 0; y < 480; y++) {
            for (int x = 0; x < 640; x++) {
                int number = random.nextInt(3);
                char ch = ' ';
                switch (number) {
                    case 0:
                        ch = ' ';
                        break;
                    case 1:
                        ch = '.';
                        break;
                    case 2:
                        ch = '#';
                        break;
                    case 3:
                        ch = '%';
                        break;
                }

                g2.drawString(String.valueOf(ch), x *10, y * 15);
            }
        }
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Direct draw demo");

        main panel = new main();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() {

    }
}