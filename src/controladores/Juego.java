/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Nave;
import java.awt.Graphics;

/**
 *
 * @author jpgonzalez
 */
public class Juego implements Runnable {
    private VentanaPrincipal ventana;
    private PanelJuego panel;
    private Thread hiloJuego;
    private final int FPS = 120;
    private Nave nave;

    public Juego() {
        desplegarComponentes();
        this.panel = new PanelJuego(this);
        this.ventana = new VentanaPrincipal(panel);
        this.panel.requestFocus();
        correrJuego();
    }

    public void renderizar(Graphics g) {
        nave.renderizar(g);
    }
    
    @Override
    public void run() {
        double tiempoPorFrame = 1000000000.0 / FPS;
        long ultimoFrame = System.nanoTime();
        long actual = System.nanoTime();

        while(true) {
            actual = System.nanoTime();
            if(actual - ultimoFrame >= tiempoPorFrame) {
                panel.repaint();
                ultimoFrame = actual;
            }
        }
    }
    
    public void actualizar() {
        nave.actualizarEstdo();
    }

    public void correrJuego() {
        hiloJuego = new Thread(this);
        hiloJuego.start();
    }

    private void desplegarComponentes() {
        nave = new Nave(368f, 278f, false);
    }

    public Nave getNave() {
        return nave;
    }
}
