/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import inputs.InputTeclado;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author jpgonzalez
 */
public class PanelJuego extends JPanel {
    
    private float x = 0, y = 0;
    private BufferedImage imagen;

    public PanelJuego() {
        addKeyListener(new InputTeclado(this));
        setReslucion();
        importarImagen();
    }

    public void setReslucion() {
        Dimension res = new Dimension(1280,800);
        setMinimumSize(res);
        setMaximumSize(res);
        setPreferredSize(res);
    }

    public void importarImagen() {
        try {
            imagen = ImageIO.read(new FileInputStream("src/recursos/Ship1.png"));
        } catch (IOException e) {
            
        }
    }

    public void moverEnEjeX(float cantidad) {
            this.x += cantidad;
    }

    public void moverEnEjeY(float cantidad) {
        this.y += cantidad;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imagen, (int) x, (int) y, 128, 128, null);
    }
}
