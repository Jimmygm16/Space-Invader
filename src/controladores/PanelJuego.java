/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import inputs.InputTeclado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jpgonzalez
 */
public class PanelJuego extends JPanel implements ActionListener{
    
    private float x = 0, y = 0;
    private LinkedList<Imagen> misImagenes;
    private JButton start;
    private boolean isPlaying;
    
    public PanelJuego() {
        this.setLayout(null);
        this.misImagenes = new LinkedList<>();
        //Boton start
        this.start = new JButton("START");
        this.start.setBounds(640, 10, 100, 100);
        this.start.addActionListener(this);
        this.add(start);
        
        //imagenes
        Imagen jugador = new Imagen("src/recursos/Ship1.png", 50, 50, 0, 0, 3);
        jugador.setMaquina(false);
        Imagen img = new Imagen("src/recursos/estrella.png", 10, 10, 640, 440, 3);
        this.misImagenes.add(jugador);
        this.misImagenes.add(img);
        
        addKeyListener(new InputTeclado(this));
        this.setBackground(Color.BLACK);
        setReslucion();
        moverEstrellas();
    }

    public void setReslucion() {
        Dimension res = new Dimension(1280,800);
        setMinimumSize(res);
        setMaximumSize(res);
        setPreferredSize(res);
    }
    
    public void moverEnEjeX(float cantidad) {
            this.x += cantidad;
    }

    public void moverEnEjeY(float cantidad) {
        this.y += cantidad;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Imagen actual : misImagenes) {
            dibujarImagen(g, (Imagen) actual);
        }
    }

    
    public void dibujarImagen(Graphics lapiz,Imagen imagenActual){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(imagenActual.getRuta());
        lapiz.drawImage(imagen,imagenActual.getX(),imagenActual.getY(),
                               imagenActual.getAncho(),imagenActual.getAlto(),this);
    }
    
    public void moverEstrellas(){
        for (Imagen actual : misImagenes) {
            if(actual.isMaquina()){
                actual.moverDE(10);
            }
            repaint();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.start){
            System.exit(0);
        }
    }
}
