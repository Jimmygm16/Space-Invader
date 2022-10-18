/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Imagen;
import entidades.Nave;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author jpgonzalez
 */
public class Juego implements Runnable {
    private VentanaPrincipal ventana;
    private PanelJuego panel;
    private ArrayList<Imagen> imagenes;
    private Thread hiloJuego;
    private final int FPS = 120;  // Cantidad de fps en el juego
    private Nave nave; 

    public Juego() {
        desplegarComponentes();
        this.panel = new PanelJuego(this);
        this.ventana = new VentanaPrincipal(panel);
        this.imagenes = new ArrayList<>();
        this.panel.requestFocus();
        correrJuego();
    }

    /**
     * Renderiza al jugador
     * @param g 
     */
    public void renderizar(Graphics g) {
        nave.renderizar(g);
    }
    
    /**
     * Hilo encargado de correr el juego con la cantidad de fps queridos
     */
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

    /**
     * Metodo inicializador del ciclo de juego
     */
    public void correrJuego() {
        hiloJuego = new Thread(this);
        hiloJuego.start();
    }

    /**
     * Imprime los componentes queridos dentro del frame
     */
    private void desplegarComponentes() {
        nave = new Nave(false, 368f, 278f, 64, 64);
        imagenes.add(nave);
    }

    public Nave getNave() {
        return nave;
    }
}
