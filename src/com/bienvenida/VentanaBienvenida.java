package com.bienvenida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class VentanaBienvenida extends JFrame {

    public VentanaBienvenida() {
        // Configuración básica de la ventana
        setTitle("Bienvenid@");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);

        // Botón
        JButton boton = new JButton("Mostrar saludo");
        boton.setBackground(Color.CYAN);
        panel.add(boton);

        // Acción del botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSaludo();
            }
        });

        // Ícono personalizado
        try {
            Image icono = Toolkit.getDefaultToolkit().getImage("resources/icono.png");
            setIconImage(icono);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el ícono.");
        }
    }

    public void mostrarSaludo() {
        String nombre = JOptionPane.showInputDialog("¿Cuál es tu nombre?");

        if (nombre != null && !nombre.trim().isEmpty()) {
            // Internacionalización
            Locale locale = Locale.getDefault();
            ResourceBundle mensajes = ResourceBundle.getBundle("mensajes", locale);

            String saludo = mensajes.getString("saludo");
            JOptionPane.showMessageDialog(null, saludo.replace("{nombre}", nombre));
        } else {
            JOptionPane.showMessageDialog(null, "No ingresaste un nombre válido.");
        }
    }

    public void mostrar() {
        // Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
