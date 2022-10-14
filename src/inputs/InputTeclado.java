/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import controladores.PanelJuego;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jpgonzalez
 */
public class InputTeclado implements KeyListener {
    private PanelJuego panelJuego;

    public InputTeclado(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }

    @Override
    public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_W:
            panelJuego.moverEnEjeY(-5f);
            break;
        case KeyEvent.VK_A:
            panelJuego.moverEnEjeX(-5f);
            break;
        case KeyEvent.VK_S:
            panelJuego.moverEnEjeY(5f);
            break;
        case KeyEvent.VK_D: 
            panelJuego.moverEnEjeX(5f);
            break;
        }
    }

}
