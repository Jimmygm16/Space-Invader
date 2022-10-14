/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author 57301
 */
public class Imagen {
    private String ruta;
    private int alto;
    private int ancho;
    private int x;
    private int y;
    private int direccion;
    private boolean maquina;

    public Imagen() {
    }

    public Imagen(String ruta, int alto, int ancho, int x, int y, int direccion) {
        this.ruta = ruta;
        this.alto = alto;
        this.ancho = ancho;
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.maquina = true;
    }

    

    

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }   

    public boolean isMaquina() {
        return maquina;
    }

    public void setMaquina(boolean maquina) {
        this.maquina = maquina;
    }
        
    public void moverDE(int distancia){
        this.x=this.x+distancia;
    }
    public void moverIZ(int distancia){
        this.x=this.x-distancia;
    }
    public void moverAR(int distancia){
        this.y=this.y-distancia;
    }
    public void moverAB(int distancia){
        this.y=this.y+distancia;
    }
    
}
