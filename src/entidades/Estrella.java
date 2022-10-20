/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author jpgonzalez
 */
public class Estrella extends Imagen implements Config{
    
    public Estrella(boolean maquina, float x, float y, int ancho, int alto) {
        super(maquina, x, y, ancho, alto);
    }
    
    @Override
    public void renderizar(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image temp = t.getImage("src/recursos/estrella.png");
        g.drawImage(temp, (int) x, (int) y, this.getAncho(), this.getAlto(), null);
    }

    @Override
    public void actualizarPosicion() {
        
    }
    
}