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
    private boolean maquina;

    public Imagen() {
    }

    public Imagen(String ruta, boolean maquina) {
        this.ruta = ruta;
        this.maquina = true;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean isMaquina() {
        return maquina;
    }

    public void setMaquina(boolean maquina) {
        this.maquina = maquina;
    }
}
