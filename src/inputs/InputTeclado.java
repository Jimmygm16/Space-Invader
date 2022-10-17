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
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                panelJuego.getJuego().getNave().setUp(false);
                break;
            case KeyEvent.VK_A:
                panelJuego.getJuego().getNave().setLeft(false);
                break;
            case KeyEvent.VK_S:
                panelJuego.getJuego().getNave().setDown(false);
                break;
            case KeyEvent.VK_D:
                panelJuego.getJuego().getNave().setRight(false);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                panelJuego.getJuego().getNave().setUp(true);
                break;
            case KeyEvent.VK_A:
                panelJuego.getJuego().getNave().setLeft(true);
                break;
            case KeyEvent.VK_S:
                panelJuego.getJuego().getNave().setDown(true);
                break;
            case KeyEvent.VK_D:
                panelJuego.getJuego().getNave().setRight(true);
                break;
            case KeyEvent.VK_L:
                panelJuego.getJuego().getNave().disparar();
                break;
        }
    }

}
