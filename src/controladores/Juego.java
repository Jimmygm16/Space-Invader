/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author jpgonzalez
 */
public class Juego implements Runnable {
    private VentanaPrincipal ventana;
    private PanelJuego panel;
    private Thread hiloJuego;
    private final int FPS = 120;

    public Juego() {
        this.panel = new PanelJuego();
        this.ventana = new VentanaPrincipal(panel);
        this.panel.requestFocus();
        correrJuego();
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

    public void correrJuego() {
        hiloJuego = new Thread(this);
        hiloJuego.start();
    }

}
