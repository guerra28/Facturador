package com.guerra.vista;

import com.guerra.boton.Boton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author juan_guerra
 */
public class Ventana extends JFrame implements ActionListener, MouseListener, FocusListener {

    private JPanel contenedorUsuario;
    private JPanel contenedorMenu;
    private JPanel contenedorPrincipal;

    private JDialog menuUsuario;

    private JPanel contenedor;

    private GridBagConstraints constraints = new GridBagConstraints();

    private Boton btnInicio = new Boton();
    private Boton btnFactura = new Boton();
    private Boton btnInventario = new Boton();
    private JButton btnAyuda = new JButton();
    private JButton btnOcultar = new JButton();
    private Boton btnPerfil = new Boton();
    private Boton btnLogout = new Boton();

    JLabel lblUser = new JLabel();
    JLabel menuUser = new JLabel();
    GridBagConstraints c = new GridBagConstraints();
    JPanel panelDatos = new JPanel();
    JPanel panelUsuario = new JPanel();

    private boolean oculto = false;

    public Ventana() {
        super("Ventanita");
        this.setLayout(new GridLayout(1, 1));
        this.setPreferredSize(new Dimension(300, 200));
        this.setExtendedState(6);
        //  this.setResizable(false);

        contenedor = new JPanel(new GridBagLayout());
        contenedor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        contenedor.setBackground(new Color(hex("BDBAA9")));
        //contenedor.setSize(300, 200);

        iniciarPanelMenu();

        contenedorUsuario = new JPanel();
        contenedorUsuario.setPreferredSize(new Dimension(350, 150));
        contenedorUsuario.setBackground(new Color(hex("162542")));
        contenedorUsuario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contenedorUsuario.setLayout(new GridBagLayout());

        contenedorPrincipal = new JPanel();
        contenedorPrincipal.setBackground(new Color(hex("BDBAA9")));
        contenedorPrincipal.setPreferredSize(new Dimension(200, 200));

        iniciarPanelUsuario();
        iniciarMenuUsuario();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;

        contenedor.add(contenedorUsuario, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;

        contenedor.add(contenedorPrincipal, constraints);

        this.add(contenedor);
    }

    public void iniciarMenuUsuario() {
        menuUsuario = new JDialog();

        menuUsuario.setUndecorated(true);
        menuUsuario.setSize(100, 150);
        menuUsuario.setFocusable(true);
        menuUsuario.addFocusListener(this);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 1));
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        // menuUsuario.setLayout(new BoxLayout(menuUsuario, BoxLayout.PAGE_AXIS));
        // menuUsuario.setVisible(true);

        btnPerfil.setText("Perfil");
        btnPerfil.setColorFocusGained(new Color(hex("162542")));
        btnPerfil.setColorPresed(new Color(hex("152E4A")));
        btnPerfil.setSize(new Dimension(150, 50));
        btnPerfil.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/perfil.png"));
        btnPerfil.setColorNormal(Color.YELLOW);

        btnPerfil.setColorPresed(Color.green);
        btnPerfil.addActionListener(this);

        btnLogout.setText("Logout");
        btnLogout.setColorFocusGained(new Color(hex("162542")));
        btnLogout.setColorPresed(new Color(hex("152E4A")));
        btnLogout.setSize(new Dimension(150, 50));
        btnLogout.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/logout2.png"));
        btnLogout.setColorNormal(Color.YELLOW);

        btnLogout.setColorPresed(Color.green);
        btnLogout.addActionListener(this);

        p.add(btnPerfil);
        p.add(btnLogout);

        menuUsuario.add(p);
    }

    public void iniciarPanelMenu() {

        contenedorMenu = new JPanel();
        contenedorMenu.setLayout(new GridBagLayout());
        contenedorMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        contenedorMenu.setPreferredSize(new Dimension(300, 150));
        contenedorMenu.setBackground(new Color(hex("1E426B")));

        GridBagConstraints c = new GridBagConstraints();

        btnInicio.setText("Inicio");
        btnInicio.setColorFocusGained(new Color(hex("162542")));
        btnInicio.setColorPresed(new Color(hex("152E4A")));
        btnInicio.setSize(new Dimension(150, 50));
        btnInicio.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/home.png"));
        btnInicio.setColorNormal(Color.YELLOW);
        // btnInicio.setColorFocusGained(Color.orange);
        btnInicio.setColorPresed(Color.green);
        btnInicio.addActionListener(this);

        btnFactura.setText("Facturas");
        btnFactura.setColorFocusGained(new Color(hex("162542")));
        btnFactura.setColorPresed(new Color(hex("152E4A")));
        btnFactura.setSize(new Dimension(150, 50));
        btnFactura.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/factura.png"));
        btnFactura.setColorNormal(Color.YELLOW);
        //btnFactura.setColorFocusGained(Color.orange);
        btnFactura.setColorPresed(Color.green);
        btnFactura.addActionListener(this);

        btnInventario.setText("Inventario");
        btnInventario.setColorFocusGained(new Color(hex("162542")));
        btnInventario.setColorPresed(new Color(hex("152E4A")));
        btnInventario.setSize(new Dimension(150, 50));
        btnInventario.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/inventario.png"));
        btnInventario.setColorNormal(Color.YELLOW);
        // btnInventario.setColorFocusGained(Color.orange);
        btnInventario.setColorPresed(Color.green);
        btnInventario.addActionListener(this);

        btnAyuda.setSize(new Dimension(150, 50));
        btnAyuda.setOpaque(false);
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setBorder(null);
        btnAyuda.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/ayuda.png"));
        btnAyuda.setCursor(new Cursor(12));
        btnAyuda.setFocusable(false);
        btnAyuda.addActionListener(this);

        btnOcultar.setPreferredSize(new Dimension(18, 50));
        btnOcultar.setOpaque(false);
        btnOcultar.setContentAreaFilled(false);
        btnOcultar.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        btnOcultar.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/ocultar.png"));
        btnOcultar.setCursor(new Cursor(12));
        btnOcultar.setFocusable(false);
        btnOcultar.addActionListener(this);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        contenedorMenu.add(btnInicio, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;

        contenedorMenu.add(btnFactura, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;

        contenedorMenu.add(btnInventario, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.SOUTH;

        contenedorMenu.add(btnAyuda, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;

        contenedorMenu.add(btnOcultar, c);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        constraints.weightx = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.WEST;

        contenedor.add(contenedorMenu, constraints);

    }

    public void iniciarPanelUsuario() {

        panelDatos.setLayout(new GridBagLayout());
        panelDatos.setSize(100, 100);
        // panelDatos.setBackground(Color.red);
        panelDatos.setOpaque(false);

        panelUsuario.setLayout(new GridBagLayout());
        panelUsuario.setBackground(Color.blue);

        lblUser.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/user2.png"));
        lblUser.setText("User Name");
        lblUser.setHorizontalTextPosition(CENTER);
        lblUser.setVerticalTextPosition(BOTTOM);
        menuUser.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/menu.png"));
        //menuUser.setSize(new Dimension(40,40));
        menuUser.addMouseListener(this);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;

        panelUsuario.add(lblUser, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;

        panelUsuario.add(menuUser, c);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;

        contenedorUsuario.add(panelDatos, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;

        contenedorUsuario.add(panelUsuario, c);

    }

    private int hex(String color_hex) {
        return Integer.parseInt(color_hex, 16);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnInicio) {

        }
        if (e.getSource() == btnFactura) {

        }
        if (e.getSource() == btnInventario) {

        }
        if (e.getSource() == btnAyuda) {

        }
        if (e.getSource() == btnOcultar) {

            if (oculto) {

                contenedorMenu.setPreferredSize(new Dimension(300, 150));
                btnInicio.setText("Inicio");
                btnFactura.setText("Factura");
                btnInventario.setText("Inventario");
                btnOcultar.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/ocultar.png"));
                contenedor.updateUI();
                oculto = false;

            } else {
                contenedorMenu.setPreferredSize(new Dimension(100, 150));
                btnInicio.setText("");
                btnFactura.setText("");
                btnInventario.setText("");

                btnOcultar.setIcon(new ImageIcon("src/com/guerra/vista/recursos/iconos/mostrar.png"));
                contenedor.updateUI();
                oculto = true;
            }

        }

        if (e.getSource() == btnLogout) {
            menuUsuario.dispose();
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == menuUser) {
            menuUsuario.setLocation(menuUser.getLocationOnScreen().x + (menuUser.getWidth() - menuUser.getWidth()), menuUser.getLocationOnScreen().y + menuUser.getHeight());
            menuUsuario.setVisible(true);

        }

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void focusLost(FocusEvent fe) {

        if (fe.getSource() == menuUsuario) {

            menuUsuario.dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setTitle("ventanita");
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
        v.setVisible(true);
    }

}
