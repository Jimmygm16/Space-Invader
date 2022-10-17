/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author 57301
 */
public class Imagen {
    protected String ruta;
    protected boolean maquina;
    protected float x, y;

    public Imagen(float x, float y, boolean maquina) {
        this.x = x;
        this.y = y;
        this.maquina = maquina;
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
