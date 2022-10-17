/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import controladores.Imagen;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author jpgonzalez
 */
public class Nave extends Entidad {
    
    private ArrayList<Imagen> posiblesNaves;
    private int naveUsada = 0;
    private boolean up, down, left, right;
    private float velocidad = 2.0f;
    
    public Nave(float x, float y) {
        super(x, y);
        this.posiblesNaves = new ArrayList<>();
        sacarImagenes();
    }
    
    public void actualizarEstdo() {
        actualizarPosicion();
    }
    
    public void actualizarPosicion() {
       if(left && !right) {
           this.x -= velocidad;
       } else if(!left && right) {
           this.x += velocidad;
       }
       
       if(up && !down) {
           this.y -= velocidad;
       } else if(!up && down) {
           this.y += velocidad;
       }
    }
    
    public void renderizar(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(posiblesNaves.get(naveUsada).getRuta());
        g.drawImage(imagen, (int) x, (int) y, 64, 64, null);
        actualizarEstdo();
    }
    
    public void sacarImagenes() {
        posiblesNaves.add(new Imagen("src/recursos/Ship1.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship2.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship4.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship5.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship6.png", false));
    }

    /**
     * @return the up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * @return the down
     */
    public boolean isDown() {
        return down;
    }

    /**
     * @return the left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @param up the up to set
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * @param down the down to set
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }
}
