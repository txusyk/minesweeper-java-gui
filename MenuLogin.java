/*
 * Copyright [2016] [Josu]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class MenuLogin extends javax.swing.JPanel implements ActionListener {

    private javax.swing.JRadioButton botonDificil;
    private javax.swing.JRadioButton botonFacil;
    private javax.swing.JButton botonLogIn;
    private javax.swing.JRadioButton botonMedio;
    private javax.swing.JButton botonNuevoUsuario;
    private javax.swing.ButtonGroup grupoBotonesDif;
    private javax.swing.JLabel labelBienvenida;
    private javax.swing.JLabel labelPasswd;
    private javax.swing.JLabel labelPideSelDif;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JPasswordField passwordUsuario;

    private String dificultad_juego = "facil";
    private String jugActual = "";

    /**
     * Creates new form VistaLogin
     */
    public MenuLogin() {
        initComponents();
        inicializarBotonesDificultad();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    private void initComponents() {

        grupoBotonesDif = new javax.swing.ButtonGroup();
        labelUsuario = new javax.swing.JLabel();
        labelPasswd = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        labelPideSelDif = new javax.swing.JLabel();
        labelBienvenida = new javax.swing.JLabel();
        passwordUsuario = new javax.swing.JPasswordField();
        botonFacil = new javax.swing.JRadioButton();
        botonMedio = new javax.swing.JRadioButton();
        botonDificil = new javax.swing.JRadioButton();
        botonLogIn = new javax.swing.JButton();
        botonNuevoUsuario = new javax.swing.JButton();

        labelUsuario.setText("Usuario:");

        labelPasswd.setText("Contraseña:");

        nombreUsuario.setText("Usuario");
        nombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreUsuarioMouseClicked(evt);
            }
        });

        labelPideSelDif.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        labelPideSelDif.setText("Selecciona un nivel de dificultad");

        labelBienvenida.setFont(new java.awt.Font("Didact Gothic", 1, 18)); // NOI18N
        labelBienvenida.setText("Bienvenido al Buscaminas!!!");

        passwordUsuario.setText("Password");
        passwordUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordUsuarioMouseClicked(evt);
            }
        });

        botonFacil.setText("Facil");

        botonMedio.setText("Medio");

        botonDificil.setText("Dificil");

        botonLogIn.setText("Login");
        botonLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLogInMouseClicked(evt);
            }
        });

        botonNuevoUsuario.setText("Nuevo Usuario");
        botonNuevoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNuevoUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelPideSelDif)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(labelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonLogIn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelPasswd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(botonFacil))
                                                        .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(botonMedio)
                                                                .addGap(115, 115, 115)
                                                                .addComponent(botonDificil))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(passwordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                                                .addComponent(botonNuevoUsuario)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(labelBienvenida)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUsuario)
                                        .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonLogIn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPasswd)
                                        .addComponent(passwordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonNuevoUsuario))
                                .addGap(34, 34, 34)
                                .addComponent(labelPideSelDif)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonFacil)
                                        .addComponent(botonMedio)
                                        .addComponent(botonDificil))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
    }

    public String getDificultad_juego() {
        return this.dificultad_juego;
    }

    private void nombreUsuarioMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        nombreUsuario.setText("");
    }

    private void passwordUsuarioMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        passwordUsuario.setText("");
    }

    /*private String imprimir(){
        String pass = "";

        for (char output : this.passwordUsuario.getPassword()) {

                    pass = pass+""+output;
        }
        return pass;
    }*/


    private void botonLogInMouseClicked(java.awt.event.MouseEvent evt) {
        //JOptionPane.showMessageDialog(this, this.nombreUsuario.getText()+","+this.imprimir());
        Jugador auxUser = new Jugador(nombreUsuario.getText(), passwordUsuario.getPassword());
        if (ListaJugadores.getMiListaJugadores().getJugador(auxUser.getNombreJugador()) != null) {
            if (ListaJugadores.getMiListaJugadores().getJugador(auxUser.getNombreJugador()).comprobarPasswd(auxUser.getContrasena())) {
                this.setVisible(false);
                this.jugActual = nombreUsuario.getText();
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña erronea");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario inexistente, pruebe de nuevo");
        }
    }

    private void botonNuevoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {
        Jugador auxUser = new Jugador(nombreUsuario.getText(), passwordUsuario.getPassword());
        if (ListaJugadores.getMiListaJugadores().getJugador(auxUser.getNombreJugador()) == null) {
            ListaJugadores.getMiListaJugadores().anadirJugador(auxUser);
            this.setVisible(false);
            this.jugActual = nombreUsuario.getText();
        } else {
            JOptionPane.showMessageDialog(this, "El usuario ya existe. pruebe con otro nombre");
        }
    }


    private void inicializarBotonesDificultad() {
        //al inicializar la clase instancia los botones JRadioButton
        //dentro de un grupo de botones para que solo uno de ellos pueda
        //estar pulsado a la vez

        botonFacil.setActionCommand("facil");
        botonMedio.setActionCommand("medio");
        botonDificil.setActionCommand("dificil");

        botonFacil.setSelected(true);
        grupoBotonesDif.add(botonFacil);
        grupoBotonesDif.add(botonMedio);
        grupoBotonesDif.add(botonDificil);

        //Regsitramos un listener para los radio buttons
        botonFacil.addActionListener(this);
        botonMedio.addActionListener(this);
        botonDificil.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dificultad_juego = e.getActionCommand();
    }

    public String getUsuarioActual() {
        return this.jugActual;
    }
}