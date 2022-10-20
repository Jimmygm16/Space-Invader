/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import estados.EstadosDeJuego;
import estados.Jugando;
import estados.Menu;
import java.awt.Graphics;

/**
 *
 * @author jpgonzalez
 */
public class Juego implements Runnable {
    private VentanaPrincipal ventana;
    private PanelJuego panel;
    private Thread hiloJuego;
    private int FPS = 120;  // Cantidad de fps en el juego
    
    private Jugando jugando;
    private Menu menu;

    public Juego() {
        inicializarPaneles();
        this.panel = new PanelJuego(this);
        this.ventana = new VentanaPrincipal(getPanel());
        this.panel.requestFocus();
        correrJuego();
    }

    
    /**
     * Hilo encargado de correr el juego con la cantidad de fps queridos
     */
    @Override
    public void run() {
        double tiempoPorFrame = 1000000000.0 / getFPS();
        long ultimoFrame = System.nanoTime();
        long actual = System.nanoTime();

        while(true) {
            actual = System.nanoTime();
            if(actual - ultimoFrame >= tiempoPorFrame) {
                getPanel().repaint();
                ultimoFrame = actual;
                System.out.println("Funciona");
            }
        }
    }
    
    public void actualizar() {
        switch (EstadosDeJuego.estadoActual) {
            case MENU:
                menu.actualizar();
                break;
            case JUGANDO:
                jugando.actualizar();
                break;
              
        }
    }
    
     /**
     * Renderiza al jugador
     * @param g 
     */
    public void renderizar(Graphics g) {
        switch(EstadosDeJuego.estadoActual) {
            case MENU:
                menu.actualizarRenderizado(g);
                break;
            case JUGANDO:
                jugando.actualizarRenderizado(g);
                break;
                
       }
    }

    /**
     * Metodo inicializador del ciclo de juego
     */
    public void correrJuego() {
        setHiloJuego(new Thread(this));
        getHiloJuego().start();
    }

    /**
     * Imprime los componentes queridos dentro del frame
     */
    private void inicializarPaneles() {
        this.jugando = new Jugando(this);
        this.menu = new Menu(this);
    }

    /**
     * @return the ventana
     */
    public VentanaPrincipal getVentana() {
        return ventana;
    }

    /**
     * @param ventana the ventana to set
     */
    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    /**
     * @return the panel
     */
    public PanelJuego getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(PanelJuego panel) {
        this.panel = panel;
    }

    /**
     * @return the hiloJuego
     */
    public Thread getHiloJuego() {
        return hiloJuego;
    }

    /**
     * @param hiloJuego the hiloJuego to set
     */
    public void setHiloJuego(Thread hiloJuego) {
        this.hiloJuego = hiloJuego;
    }

    /**
     * @return the FPS
     */
    public int getFPS() {
        return FPS;
    }

    /**
     * @param FPS the FPS to set
     */
    public void setFPS(int FPS) {
        this.FPS = FPS;
    }
}
