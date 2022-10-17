/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author jpgonzalez
 */
public class Nave extends Imagen {
    
    private ArrayList<Imagen> posiblesNaves;
    private int naveUsada = 0;
    private boolean up, down, left, right;
    private float velocidad = 2.0f;
    private ArrayList<Disparo> disparos;
    
    public Nave(float x, float y, boolean maquina) {
        super(x, y, maquina); // Super de imagen
        this.posiblesNaves = new ArrayList<>();
        this.disparos = new ArrayList<>();
        sacarImagenes(); // Agrega las imagenes al arraylist
    }
    
    /**
     * Se encarga de actualzar la pantlla con la ultima información recogida
     */
    public void actualizarEstdo() {
        actualizarPosicion();
        actualizarDiapros();
    }
    
    /**
     * Realiza la acción de disparar, agregando un nuevo proyectil al arreglo
     */
    public void disparar() {
        disparos.add(new Disparo((int) x, (int) y - 32, true, 1));
    }
    
    /**
     * Actualiza la posicion de los disparos, verificando si estos 
     * todavia deberían ser impresos en pantalla.
     */
    public void actualizarDiapros() {
        for (Disparo actual : disparos) {
            if(actual.isEnRango()) {
                actual.actualizarPosicion();
            }
        }
    }
    
    /**
     * Soluciona los problemas con los inputs de teclado para el 
     * movimiento del jugador y da la posibilidad de mover en vertical
     * al mismo.
     */
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
    
    /**
     * Se encarga de dibujar la nave en pantalla
     * @param g 
     */
    public void renderizar(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(posiblesNaves.get(naveUsada).getRuta());
        g.drawImage(imagen, (int) x, (int) y, 64, 64, null);
        for(Disparo temp : disparos) {
            temp.renderizar(g);
        }
        actualizarEstdo();
    }
    
    /**
     * Mete las imagenes de las naves a su respectivo arraylist
     */
    public void sacarImagenes() {
        posiblesNaves.add(new Imagen("src/recursos/Ship1.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship2.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship4.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship5.png", false));
        posiblesNaves.add(new Imagen("src/recursos/Ship6.png", false));
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
