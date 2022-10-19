/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Estrella;
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
    private ArrayList<Estrella> estrellas;
    private Thread hiloJuego;
    private int FPS = 120;  // Cantidad de fps en el juego
    private Nave nave; 

    public Juego() {
        this.imagenes = new ArrayList<>();
        this.estrellas = new ArrayList<>();
        crearEstrellas();
        desplegarComponentes();
        this.panel = new PanelJuego(this);
        this.ventana = new VentanaPrincipal(getPanel());
        this.panel.requestFocus();
        System.out.println(this.estrellas);
        correrJuego();
    }

    /**
     * Renderiza al jugador
     * @param g 
     */
    public void renderizar(Graphics g) {
        for(Estrella temp : estrellas) {
            temp.renderizar(g);
        }
        getNave().renderizar(g);
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
            }
        }
    }
    
    public void actualizar() {
        getNave().actualizarEstdo();
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
    private void desplegarComponentes() {
        setNave(new Nave(false, 368f, 278f, 64, 64));
        getImagenes().add(getNave());
    }

    public Nave getNave() {
        return nave;
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
     * @return the imagenes
     */
    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
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

    /**
     * @param nave the nave to set
     */
    public void setNave(Nave nave) {
        this.nave = nave;
    }
    
    public void crearEstrellas(){
        int cantidad = (int)Math.random()*30+29;
        for(int i = 0; i<cantidad; i++){
            Estrella aux = new Estrella(false, Math.round(Math.random()*800+10), Math.round(Math.random()*620+10), 13, 13);
            System.out.println(Math.round((Double)Math.random()*800+10));
            this.estrellas.add(aux);
        }
        
    }
}
