/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentación;

import Excepciones.DatosPerfilErroneosException;
import Excepciones.PerfilExistenteException;
import dominio.Especialidad;
import dominio.RangoAltura;
import dominio.RangoEdad;
import dominio.Estado;
import dominio.Perfil;
import dominio.Presencial;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.FabricaLogica;
import logica.ILogica;

/**
 * Clase que representa la pantalla de Perfil.
 *
 * @author Equipo 3
 */
public class FrmPerfil extends javax.swing.JFrame {

    /**
     * Atributo de tipo ILogica.
     */
    private ILogica logica;
    /**
     * Atributo de tipo FrmPerfil.
     */
    private static FrmPerfil frmPerfil;

    /**
     * Constructor que inicializa los componentes del formulario.
     */
    private FrmPerfil() {
        initComponents();
        logica = FabricaLogica.crearLogica();
        this.quitarEditablesComponentesPerfil();
        this.verificarCastingsRegistrados();
        this.llenarTablaCastings(logica.obtenerTodosCastings());
    }

    /**
     * Método utilizado para obtener al atributo de FrmPerfil inicializado.
     *
     * @return Atributo frmPerfil.
     */
    public static FrmPerfil obtenerFrmPerfil() {
        if (frmPerfil == null) {
            frmPerfil = new FrmPerfil();
        }
        return frmPerfil;
    }

    /**
     * Método para verificar si hay castings registrados.
     */
    private void verificarCastingsRegistrados() {
        List<Presencial> castings;
        try {
            castings = logica.obtenerTodosCastings();
        } catch (Exception e) {
            this.mostrarError(e.getMessage());
            return;
        }
        if (castings.isEmpty()) {
            this.mostrarError("No hay castings registrados");
            return;
        }
    }

    /**
     * Método que hace visible el formulario.
     */
    public void mostrarFormulario() {
        this.verificarCastingsRegistrados();
        this.limpiarCampos();
        this.quitarEditablesComponentesPerfil();
        this.setVisible(true);
    }

    /**
     * Método que convierte en editables los componentes del formulario.
     */
    private void volverEditablesComponentesPerfil() {
        this.txtCodigoPerfil.setEditable(true);
        this.txtColorOjos.setEditable(true);
        this.txtColorPelo.setEditable(true);
        this.cboSexo.setEnabled(true);
        this.cbxExperiencia.setEnabled(true);
        this.cboEspecialidad.setEnabled(true);
        this.cboEstado.setEnabled(true);
        this.cboRangoAltura.setEnabled(true);
        this.cboRangoEdad.setEnabled(true);
    }

    /**
     * Método que convierte en no editables los componentes del formulario.
     */
    private void quitarEditablesComponentesPerfil() {
        this.txtCodigoPerfil.setEditable(false);
        this.txtColorOjos.setEditable(false);
        this.txtColorPelo.setEditable(false);
        this.cboSexo.setEnabled(false);
        this.cbxExperiencia.setEnabled(false);
        this.cboEspecialidad.setEnabled(false);
        this.cboEstado.setEnabled(false);
        this.cboRangoAltura.setEnabled(false);
        this.cboRangoEdad.setEnabled(false);
    }

    /**
     * Método utilizado para llenar la tabla de castings.
     *
     * @param listaCastings lista de castings para llenar la tabla.
     */
    private void llenarTablaCastings(List<Presencial> listaCastings) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCastings.getModel();
        modeloTabla.setRowCount(0);
        listaCastings.forEach(casting -> {
            Object[] fila = new Object[6];
            fila[0] = casting.getCodigoCasting();
            fila[1] = casting.getNombre();
            fila[2] = casting.getDescripcion();
            fila[3] = casting.getFechaContratacion();
            fila[4] = casting.getNoPersonas();
            fila[5] = casting.getClienteCasting().getCoste();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Método para llenar el combobox de especialidades del perfil.
     */
    private void llenarComboBoxEspecialidad() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.cboEspecialidad.getModel();
        modelo.addElement(Especialidad.Actor);
        modelo.addElement(Especialidad.Modelo);
        this.cboEspecialidad.setSelectedIndex(-1);
    }

    /**
     * Método para llenar el combobox de estados del perfil.
     */
    private void llenarComboBoxEstado() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.cboEstado.getModel();
        modelo.addElement(Estado.Aguascalientes);
        modelo.addElement(Estado.BajaCalifornia);
        modelo.addElement(Estado.BajaCaliforniaSur);
        modelo.addElement(Estado.Campeche);
        modelo.addElement(Estado.Chiapas);
        modelo.addElement(Estado.Chihuahua);
        modelo.addElement(Estado.CiudadDeMexico);
        modelo.addElement(Estado.Coahuila);
        modelo.addElement(Estado.Colima);
        modelo.addElement(Estado.Durango);
        modelo.addElement(Estado.EstadoDeMexico);
        modelo.addElement(Estado.Guanajuato);
        modelo.addElement(Estado.Guerrero);
        modelo.addElement(Estado.Hidalgo);
        modelo.addElement(Estado.Jalisco);
        modelo.addElement(Estado.Michoacán);
        modelo.addElement(Estado.Morelos);
        modelo.addElement(Estado.Nayarit);
        modelo.addElement(Estado.NuevoLeon);
        modelo.addElement(Estado.Oaxaca);
        modelo.addElement(Estado.Puebla);
        modelo.addElement(Estado.Queretaro);
        modelo.addElement(Estado.QuintanaRoo);
        modelo.addElement(Estado.SanLuisPotosi);
        modelo.addElement(Estado.Sinaloa);
        modelo.addElement(Estado.Sonora);
        modelo.addElement(Estado.Tabasco);
        modelo.addElement(Estado.Tamaulipas);
        modelo.addElement(Estado.Tlaxcala);
        modelo.addElement(Estado.Veracruz);
        modelo.addElement(Estado.Yucatan);
        modelo.addElement(Estado.Zacatecas);
        this.cboEstado.setSelectedIndex(-1);
    }

    /**
     * Método para llenar el combobox de rango de edades del perfil.
     */
    private void llenarComboBoxRangoEdad() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.cboRangoEdad.getModel();
        modelo.addElement(RangoEdad.De0A15);
        modelo.addElement(RangoEdad.De15A18);
        modelo.addElement(RangoEdad.De18A25);
        modelo.addElement(RangoEdad.De25A35);
        modelo.addElement(RangoEdad.De35A45);
        modelo.addElement(RangoEdad.De45A60);
        modelo.addElement(RangoEdad.MayorDe60);
        this.cboRangoEdad.setSelectedIndex(-1);
    }

    /**
     * Método para llenar el combobox de rango de alturas del perfil.
     */
    private void llenarComboBoxRangoAltura() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.cboRangoAltura.getModel();
        modelo.addElement(RangoAltura.De1_5A1_7);
        modelo.addElement(RangoAltura.De1_7A1_9);
        modelo.addElement(RangoAltura.MayorA1_9);
        modelo.addElement(RangoAltura.MenorA1_5);
        this.cboRangoAltura.setSelectedIndex(-1);
    }

    /**
     * Método para mostrar mensaje de error.
     *
     * @param error Mensaje de error a mostrar.
     */
    private void mostrarError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error!...", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método utilizado para mostrar mensaje de guardado exitoso.
     */
    private void mostrarMensajeGuardadoExitoso() {
        JOptionPane.showMessageDialog(this, "Perfil agregado con éxito!! ", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para limpiar los campos del formulario.
     */
    private void limpiarCampos() {
        this.txtCodigoPerfil.setText("");
        this.cboSexo.setSelectedIndex(-1);
        this.txtColorPelo.setText("");
        this.txtColorOjos.setText("");
        this.cbxExperiencia.setSelected(false);
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboEstado.setSelectedIndex(-1);
        this.cboRangoAltura.setSelectedIndex(-1);
        this.cboRangoEdad.setSelectedIndex(-1);
        this.tblCastings.clearSelection();
    }

    /**
     * Método utilizado para verificar que se haya seleccionado un casting.
     *
     * @return verdadero o falso.
     */
    private boolean verificarCastingSeleccionado() {
        int filaSeleccionada = this.tblCastings.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "No hay casting seleccionado", "Error!...", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCastings = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarPerfil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtCodigoPerfil = new javax.swing.JTextField();
        txtColorPelo = new javax.swing.JTextField();
        txtColorOjos = new javax.swing.JTextField();
        cboEspecialidad = new javax.swing.JComboBox<>();
        cboEstado = new javax.swing.JComboBox<>();
        cboRangoAltura = new javax.swing.JComboBox<>();
        cboRangoEdad = new javax.swing.JComboBox<>();
        cboSexo = new javax.swing.JComboBox<>();
        cbxExperiencia = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de perfiles");

        tblCastings.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblCastings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código Casting", "Nombre", "Descripción", "Fecha Contratación", "Número Personas", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCastings);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Castings");

        btnAgregarPerfil.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAgregarPerfil.setText("Agregar Perfil");
        btnAgregarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPerfilActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Registrar Perfil");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Código perfil: ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Sexo:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Color pelo: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Color ojos:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Experiencia: ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Especialidad: ");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Estado: ");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Rango altura: ");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Rango edad: ");

        btnRegistrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtCodigoPerfil.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCodigoPerfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoPerfilKeyTyped(evt);
            }
        });

        txtColorPelo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtColorPelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorPeloKeyTyped(evt);
            }
        });

        txtColorOjos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtColorOjos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorOjosKeyTyped(evt);
            }
        });

        cboEspecialidad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cboEstado.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cboRangoAltura.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cboRangoEdad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cboSexo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));
        cboSexo.setSelectedIndex(-1);

        cbxExperiencia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbxExperiencia.setText("¿Cuenta con experiencia?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(btnAgregarPerfil))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCodigoPerfil)
                                            .addComponent(txtColorPelo)
                                            .addComponent(txtColorOjos)
                                            .addComponent(cboEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboRangoAltura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboRangoEdad, 0, 221, Short.MAX_VALUE)
                                            .addComponent(cboSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxExperiencia))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(216, 216, 216)
                                        .addComponent(btnRegistrar)
                                        .addGap(122, 122, 122)
                                        .addComponent(btnVolver)))
                                .addGap(0, 274, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarPerfil)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtColorPelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtColorOjos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxExperiencia))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboRangoAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboRangoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnVolver))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Función del botón volver.
     *
     * @param evt evento al que escucha.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.limpiarCampos();
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    /**
     * Función del botón agregar perfil.
     *
     * @param evt evento al que escucha.
     */
    private void btnAgregarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPerfilActionPerformed
        int filaSeleccionada = this.tblCastings.getSelectedRow();

        if (filaSeleccionada == -1) {
            this.mostrarError("No hay casting seleccionado");
            return;
        }

        if (this.cboEspecialidad.getItemCount() > 0) {

        } else {
            this.llenarComboBoxEspecialidad();
            this.llenarComboBoxEstado();
            this.llenarComboBoxRangoAltura();
            this.llenarComboBoxRangoEdad();
        }

        this.volverEditablesComponentesPerfil();
    }//GEN-LAST:event_btnAgregarPerfilActionPerformed
    /**
     * Función del botón registrar.
     *
     * @param evt evento al que escucha.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!this.verificarCastingSeleccionado()) {
            return;
        }

        String codigoPerfil = this.txtCodigoPerfil.getText();
        String sexo = (String) this.cboSexo.getSelectedItem();
        String colorPelo = this.txtColorPelo.getText();
        String colorOjos = this.txtColorOjos.getText();
        boolean experiencia = this.cbxExperiencia.isSelected();
        Especialidad especialidad = (Especialidad) this.cboEspecialidad.getSelectedItem();
        Estado estado = (Estado) this.cboEstado.getSelectedItem();
        RangoAltura rangoAltura = (RangoAltura) this.cboRangoAltura.getSelectedItem();
        RangoEdad rangoEdad = (RangoEdad) this.cboRangoEdad.getSelectedItem();

        int filaSeleccionada = this.tblCastings.getSelectedRow(), indiceColumnaCodigoCasting = 0;
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCastings.getModel();
        String codigoCasting = (String) modeloTabla.getValueAt(filaSeleccionada, indiceColumnaCodigoCasting);
        Presencial presencial = logica.obtenerCastingCodigo(codigoCasting);

        Perfil perfil = new Perfil(codigoPerfil, estado, sexo, rangoAltura, rangoEdad, colorPelo, colorOjos, experiencia, especialidad);

        try {
            perfil.verificarDatos();
        } catch (DatosPerfilErroneosException dpee) {
            this.mostrarError(dpee.getMessage());
            return;
        }
        perfil.generarId();
        try {
            logica.agregarPerfilACasting(presencial, perfil);
        } catch (PerfilExistenteException pee) {
            this.mostrarError(pee.getMessage());
            return;
        } catch (Exception e) {
            this.mostrarError(e.getMessage());
            return;
        }

        this.mostrarMensajeGuardadoExitoso();
        this.limpiarCampos();
        this.quitarEditablesComponentesPerfil();
    }//GEN-LAST:event_btnRegistrarActionPerformed
    /**
     * Función del campo de texto código.
     *
     * @param evt evento al que escucha.
     */
    private void txtCodigoPerfilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPerfilKeyTyped
        if (this.txtCodigoPerfil.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoPerfilKeyTyped
    /**
     * Función del campo de texto color de pelo.
     *
     * @param evt evento al que escucha.
     */
    private void txtColorPeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorPeloKeyTyped
        if (this.txtColorPelo.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtColorPeloKeyTyped
    /**
     * Función del campo de texto color de ojos.
     *
     * @param evt evento al que escucha.
     */
    private void txtColorOjosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorOjosKeyTyped
        if (this.txtColorOjos.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtColorOjosKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPerfil;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboEspecialidad;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboRangoAltura;
    private javax.swing.JComboBox<String> cboRangoEdad;
    private javax.swing.JComboBox<String> cboSexo;
    private javax.swing.JCheckBox cbxExperiencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCastings;
    private javax.swing.JTextField txtCodigoPerfil;
    private javax.swing.JTextField txtColorOjos;
    private javax.swing.JTextField txtColorPelo;
    // End of variables declaration//GEN-END:variables
}
