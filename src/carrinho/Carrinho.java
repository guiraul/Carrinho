package carrinho;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Carrinho extends Frame implements Runnable {

    int x = 0, y = 0, sleeptime = 20, pontos = 0;
    double sX = 0.1, sY = 0.1, pX = 200, pY = 70;
    Desenha desenha = new Desenha();
    Random rand = new Random();
    ArrayList<Pedra> listpedra = new ArrayList();
    Pedra remove;
    Thread animator;

    Carrinho() {

        addWindowListener(new MyFinishWindow());
        addKeyListener(new ID());
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D estrada = (Graphics2D) g;
        Graphics2D carro = (Graphics2D) g;
        Graphics2D pedra = (Graphics2D) g;

        //estrada
        estrada.draw(desenha.estrada(0, 70));

        //carro
        carro.draw(desenha.carro(175 + x, 300));

        //pedra
        for (Pedra listpedra1 : listpedra) {

            pedra.scale(listpedra1.sX, listpedra1.sY);
            pedra.translate((listpedra1.pxI / listpedra1.sX) - listpedra1.pxI, (listpedra1.pyI / listpedra1.sY) - listpedra1.pyI);
            pedra.draw(desenha.pedra(listpedra1.pxI, listpedra1.pyI));

        }

    }

    @Override
    public void run() {

        int spawn = 249;

        while (true) {
            spawn++;

            for (Pedra listpedra1 : listpedra) {
                System.out.println("X: " + listpedra1.pxI);
                listpedra1.pxI += varX(listpedra1.x, listpedra1.pxF, 250);
                System.out.println("X: " + listpedra1.pxI + "\n\n");
                listpedra1.pyI += varX(listpedra1.y, listpedra1.pyF, 250);
                listpedra1.sX += varEscala(0.9, 250);
                listpedra1.sY += varEscala(0.9, 250);
                if (listpedra1.pyI > listpedra1.pyF) {

                    remove = listpedra1;
                }
            }

            if (spawn == 250) {
                listpedra.add(new Pedra(rand.nextInt(3)));
                //nasce uma nova pedra
                //System.out.println("Pontos: " + pontos);
                //System.out.println(sleeptime);
                spawn = 0;
            }
            pontos++;

            listpedra.remove(remove);

            repaint();
            try {
                Thread.sleep(sleeptime);
            } catch (InterruptedException e) {
            }
        }
    }

    private static double varY(double pInicial, double pFinal, double tempo) {
        return (pFinal - pInicial) / tempo;
    }

    private static double varX(double pInicial, double pFinal, double tempo) {
        return (pFinal - pInicial) / tempo;
    }

    private static double varEscala(double escala, double tempo) {
        return escala / tempo;
    }

    public void start() {
        animator = new Thread(this);
        animator.start();
    }

    public static void main(String[] args) {
        Carrinho p = new Carrinho();
        p.setSize(400, 400);
        p.setVisible(true);
        p.start();
    }

    private class ID implements KeyListener {

        public ID() {
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (sleeptime <= 20 && sleeptime > 10) {
                        sleeptime -= 1;
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (sleeptime >= 10 && sleeptime < 20) {
                        sleeptime += 1;
                    }
                    break;

                case KeyEvent.VK_LEFT:
                    x -= 5;
                    repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 5;
                    repaint();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //repaint();
        }
    }

}
