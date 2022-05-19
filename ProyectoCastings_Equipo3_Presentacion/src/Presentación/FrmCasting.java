/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentación;

import Excepciones.DatosCastingIncorrectosException;
import Excepciones.FaseConFechaRegistrada;
import dominio.Agente;
import dominio.Cliente;
import dominio.ClienteCasting;
import dominio.Fase;
import dominio.Presencial;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.FabricaLogica;
import logica.ILogica;

/**
 * Clase que representa la pantalla de Casting.
 *
 * @author Equipo 3
 */
public class FrmCasting extends javax.swing.JFrame {

    /**
     * Atributo de tipo FrmCasting.
     */
    private static FrmCasting frmCasting;
    /**
     * Atributo de tipo ILogica.
     */
    private ILogica logica;

    /**
     * Constructor que inicializa los componentes del formulario.
     */
    private FrmCasting() {
        initComponents();
        logica = FabricaLogica.crearLogica();
        this.recuperarAgentes();
        this.recuperarClientes();
    }

    /**
     * Método utilizado para obtener al atributo de FrmCasting inicializado.
     *
     * @return Atributo frmCasting.
     */
    public static FrmCasting obtenerFrmCasting() {
        if (frmCasting == null) {
            frmCasting = new FrmCasting();
        }
        return frmCasting;
    }

    /**
     * Método que hace visible el formulario.
     */
    public void mostrarFormulario() {
        this.limpiarCampos();
        this.recuperarClientes();
        this.recuperarAgentes();
        this.setVisible(true);
    }

    /**
     * Método utilizado para recuperar a los clientes.
     */
    private void recuperarClientes() {
        List<Cliente> listaClientes;
        try {
            listaClientes = logica.obtenerClientes();
        } catch (Exception e) {
            this.mostrarError(e.getMessage());
            return;
        }
        if (listaClientes.isEmpty()) {
            this.mostrarNoHayRegistros("Cliente");
            return;
        }

        this.llenarTablaClientes(listaClientes);
    }

    /**
     * Método utilizado para recuperar a los agentes.
     */
    private void recuperarAgentes() {
        List<Agente> listaAgentes;
        try {
            listaAgentes = logica.obtenerAgentes();
        } catch (Exception e) {
            this.mostrarError(e.getMessage());
            return;
        }
        if (listaAgentes.isEmpty()) {
            this.mostrarNoHayRegistros("Agente");
            return;
        }

        this.llenarTablaAgentes(listaAgentes);
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
     * Método para mostrar advertencia la inexistencia de registros.
     *
     * @param tipoRegistro tipo de registro a especificar.
     */
    private void mostrarNoHayRegistros(String tipoRegistro) {
        JOptionPane.showMessageDialog(this, "No hay registros en la base de datos del tipo: " + tipoRegistro, "No hay registros", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método utilizado para llenar la tabla de clientes.
     *
     * @param listaClientes lista de clientes para llenar la tabla.
     */
    private void llenarTablaClientes(List<Cliente> listaClientes) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblClientes.getModel();
        modeloTabla.setRowCount(0);
        listaClientes.forEach(cliente -> {
            Object[] fila = new Object[6];
            fila[0] = cliente.getCodigoCliente();
            fila[1] = cliente.getNombre();
            fila[2] = cliente.getDireccion();
            fila[3] = cliente.getTelefono();
            fila[4] = cliente.getPersonaContacto();
            fila[5] = cliente.getActividad();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Método para llenar la tabla de agentes.
     *
     * @param listaAgentes lista de agentes para llenar la tabla.
     */
    private void llenarTablaAgentes(List<Agente> listaAgentes) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblAgentes.getModel();
        modeloTabla.setRowCount(0);
        listaAgentes.forEach(agente -> {
            Object[] fila = new Object[5];
            fila[0] = agente.getNumEmpleado();
            fila[1] = agente.getNombre();
            fila[2] = agente.getDireccion();
            fila[3] = agente.getCurp();
            fila[4] = agente.getRfc();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Método para agregar una fecha a una fase.
     *
     * @param fecha fecha a agregar.
     */
    private void agregarFechaFase(Date fecha) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblFases.getModel();
        Object[] fila = new Object[2];
        fila[0] = modeloTabla.getRowCount() + 1;
        fila[1] = fecha;
        modeloTabla.addRow(fila);
    }

    /**
     * Método para verificar la existencia de una fase con la misma fecha.
     *
     * @param fecha fecha a verificar.
     */
    private void verificarExsitenciaFase(Date fecha) {
        int columnaFecha = 1;
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblFases.getModel();
        if (modeloTabla.getRowCount() == 0) {
            return;
        }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            Date fechaFase = (Date) modeloTabla.getValueAt((i), columnaFecha);
            if (fechaFase.compareTo(fecha) == 0) {
                throw new FaseConFechaRegistrada("Ya hay una fase registrada con la misma fecha");
            }
        }
    }

    /**
     * Método para limpiar los campos del formulario.
     */
    private void limpiarCampos() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblFases.getModel();
        modeloTabla.setRowCount(0);
        this.tblAgentes.clearSelection();
        this.tblClientes.clearSelection();
        this.dtpFechaFase.setText("");
        this.dtpFechaFase.setEnabled(true);
        this.txtCodigoCasting.setText("");
        this.txtCostoCasting.setText("");
        this.txtNoPersonas.setText("");
        this.txtNombreCasting.setText("");
        this.txtaDescripcion.setText("");
        this.dtpFechaContracion.setText("");
    }

    /**
     * Método para mostrar mensaje de guarado exitoso.
     */
    private void mostrarMensajeGuardadoExitoso() {
        JOptionPane.showMessageDialog(this, "Casting registrado con éxito!! ", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Método para eliminar una fase del casting.
     * @param filaSeleccionada fila seleccionada a eliminar.
     */
    private void eliminarFaseCasting(int filaSeleccionada){
        DefaultTableModel modeloTabla= (DefaultTableModel)this.tblFases.getModel();
        modeloTabla.removeRow(filaSeleccionada);
    }

    /**
     * Método para verificar los datos del casting.
     *
     * @param codigoCasting código del casting.
     * @param nombre nombre del casting.
     * @param descripcion descripción del casting.
     * @param fechaTemporal fecha del casting.
     * @param costo costo del casting.
     * @param noPersonas número de personas del casting.
     */
    private void verificarDatosCasting(String codigoCasting, String nombre, String descripcion, LocalDate fechaTemporal, String costo, String noPersonas) {
        if (codigoCasting.equals("")) {
            throw new DatosCastingIncorrectosException("El código del casting está vacío");
        }
        if (nombre.equals("")) {
            throw new DatosCastingIncorrectosException("El nombre del casting está vacío");
        }
        if (descripcion.equals("")) {
            throw new DatosCastingIncorrectosException("La descripción del casting está vacía");
        }
        if (fechaTemporal == null) {
            throw new DatosCastingIncorrectosException("La fecha del casting está vacía");
        }
        if (costo.equals("")) {
            throw new DatosCastingIncorrectosException("El costo del casting está vacío");
        }
        if (noPersonas.equals("")) {
            throw new DatosCastingIncorrectosException("El número de personas del casting está vacío");
        }
        Pattern patronCodigoNombre = Pattern.compile("^([0-9A-Za-zñÑáéíóúÁÉÍÓÚ]*){1,5}$");
        Matcher matcherCodigo = patronCodigoNombre.matcher(codigoCasting);
        if (!matcherCodigo.matches()) {
            throw new DatosCastingIncorrectosException("El código del casting contiene caracteres no válidos");
        }
        Matcher matcherNombre = patronCodigoNombre.matcher(nombre);
        if (!matcherNombre.matches()) {
            throw new DatosCastingIncorrectosException("El nombre del casting contiene caracteres no válidos");
        }
        int noPersonasInt;
        try {
            noPersonasInt = Integer.parseInt(noPersonas);
        } catch (Exception e) {
            throw new DatosCastingIncorrectosException("El número de personas del casting contiene caracteres no válidos");
        }
        if (noPersonasInt <= 0) {
            throw new DatosCastingIncorrectosException("El número de personas del casting no puede ser menor a 0");
        }
        double costoDouble;
        try {
            costoDouble = Double.parseDouble(costo);
        } catch (Exception e) {
            throw new DatosCastingIncorrectosException("El costo del casting contiene caracteres no válidos");
        }
        if (costoDouble <= 0) {
            throw new DatosCastingIncorrectosException("El costo del casting no puede ser menor a 0");
        }
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
        tblClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAgentes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFases = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        pnlAgregarFase = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dtpFechaFase = new com.github.lgooddatepicker.components.DatePicker();
        btnAgregarFase = new javax.swing.JButton();
        btnEliminarFase = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtaDescripcion = new javax.swing.JTextArea();
        txtCodigoCasting = new javax.swing.JTextField();
        txtNombreCasting = new javax.swing.JTextField();
        dtpFechaContracion = new com.github.lgooddatepicker.components.DatePicker();
        btnRegistrarCasting = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCostoCasting = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNoPersonas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de registro de castings");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código cliente", "Nombre", "Dirección", "Teléfono", "Persona Contacto", "Actividad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblClientes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tblClientes);

        jLabel1.setText("Registro de casting presencial");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tblAgentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número Empleado", "Nombre", "Dirección", "CURP", "RFC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAgentes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(tblAgentes);

        jLabel2.setText("Fases del casting: ");
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setText("Seleccionar agente: ");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tblFases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número Fase", "Fecha Inicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFases.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(tblFases);

        jLabel4.setText("Seleccionar cliente: ");
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel5.setText("Agregar Fase: ");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setText("Fecha inicio: ");
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnAgregarFase.setText("Agregar");
        btnAgregarFase.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAgregarFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAgregarFaseLayout = new javax.swing.GroupLayout(pnlAgregarFase);
        pnlAgregarFase.setLayout(pnlAgregarFaseLayout);
        pnlAgregarFaseLayout.setHorizontalGroup(
            pnlAgregarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarFaseLayout.createSequentialGroup()
                .addGroup(pnlAgregarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarFaseLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlAgregarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAgregarFaseLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(dtpFechaFase, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(pnlAgregarFaseLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btnAgregarFase)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        pnlAgregarFaseLayout.setVerticalGroup(
            pnlAgregarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarFaseLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addGroup(pnlAgregarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dtpFechaFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnAgregarFase)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEliminarFase.setText("Eliminar fase");
        btnEliminarFase.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEliminarFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFaseActionPerformed(evt);
            }
        });

        jLabel7.setText("Datos del casting faltantes: ");
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel8.setText("Código casting: ");
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setText("Nombre: ");
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setText("Descripción: ");
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setText("Fecha contratación: ");
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtaDescripcion.setColumns(20);
        txtaDescripcion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtaDescripcion.setRows(5);
        jScrollPane4.setViewportView(txtaDescripcion);

        txtCodigoCasting.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCodigoCasting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCastingActionPerformed(evt);
            }
        });
        txtCodigoCasting.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoCastingKeyTyped(evt);
            }
        });

        txtNombreCasting.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNombreCasting.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCastingKeyTyped(evt);
            }
        });

        dtpFechaContracion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnRegistrarCasting.setText("Registrar Casting");
        btnRegistrarCasting.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnRegistrarCasting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCastingActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel12.setText("Costo Casting:");
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtCostoCasting.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCostoCasting.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoCastingKeyTyped(evt);
            }
        });

        jLabel13.setText("Número de personas: ");
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtNoPersonas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNoPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoPersonasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlAgregarFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnEliminarFase))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(67, 67, 67)
                                .addComponent(txtCodigoCasting, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreCasting, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtNoPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCostoCasting, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtpFechaContracion, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(btnRegistrarCasting)
                        .addGap(52, 52, 52)
                        .addComponent(btnVolver)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlAgregarFase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnEliminarFase)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigoCasting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(dtpFechaContracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombreCasting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCostoCasting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtNoPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCasting)
                    .addComponent(btnVolver))
                .addContainerGap(20, Short.MAX_VALUE))
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
     * Función del botón agregar fase.
     *
     * @param evt evento al que escucha.
     */
    private void btnAgregarFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFaseActionPerformed
        if (this.dtpFechaFase.isEnabled() == false) {
            this.dtpFechaFase.setEnabled(true);
            return;
        }

        GregorianCalendar fechaActualIncial = new GregorianCalendar();
        GregorianCalendar fechaActual = new GregorianCalendar(fechaActualIncial.get(Calendar.YEAR), fechaActualIncial.get(Calendar.MONTH), fechaActualIncial.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date actual = new Date(fechaActual.getTimeInMillis());
        LocalDate fechaTemporal = this.dtpFechaFase.getDate();
        GregorianCalendar fechaFase;
        try {
            fechaFase = new GregorianCalendar(fechaTemporal.getYear(), (fechaTemporal.getMonthValue() - 1), fechaTemporal.getDayOfMonth(), 0, 0, 0);
        } catch (Exception e) {
            this.mostrarError(e.getMessage());
            return;
        }
        Date fecha = new Date(fechaFase.getTimeInMillis());
        if (fecha.before(actual)) {
            this.mostrarError("La fecha ingresada ya pasó");
            return;
        }
        try {
            this.verificarExsitenciaFase(fecha);
        } catch (FaseConFechaRegistrada ffr) {
            this.mostrarError(ffr.getMessage());
            return;
        }
        this.agregarFechaFase(fecha);

        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Desea agregar otra fase?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcionSeleccionada == JOptionPane.NO_OPTION || opcionSeleccionada == JOptionPane.CLOSED_OPTION) {
            this.dtpFechaFase.setEnabled(false);
        }

        this.dtpFechaFase.setText("");
    }//GEN-LAST:event_btnAgregarFaseActionPerformed
    /**
     * Función del botón eliminar.
     *
     * @param evt evento al que escucha.
     */
    private void btnEliminarFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFaseActionPerformed
        int filaSeleccionada = this.tblFases.getSelectedRow();

        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar la fase?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if ((opcionSeleccionada == JOptionPane.NO_OPTION) || (opcionSeleccionada == JOptionPane.CLOSED_OPTION)) {
            return;
        }

        if (filaSeleccionada == -1) {
            this.mostrarError("Debes seleccionar una fase para poder eliminarla");
            return;
        }

        this.eliminarFaseCasting(filaSeleccionada);
    }//GEN-LAST:event_btnEliminarFaseActionPerformed
    /**
     * Función del botón registrar.
     *
     * @param evt evento al que escucha.
     */
    private void btnRegistrarCastingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCastingActionPerformed
        int indiceSelClientes = this.tblClientes.getSelectedRow();
        int indiceSelAgentes = this.tblAgentes.getSelectedRow();

        if (indiceSelClientes == -1) {
            this.mostrarError("Debes seleccionar un cliente para poder registrar un casting");
            return;
        }
        if (indiceSelAgentes == -1) {
            this.mostrarError("Debes seleccionar un agente para poder registrar un casting");
            return;
        }

        DefaultTableModel modeloTablaFases = (DefaultTableModel) this.tblFases.getModel();
        if (modeloTablaFases.getRowCount() < 2) {
            this.mostrarError("Debes agregar al menos dos fases al casting para poder continuar con el registro");
            return;
        }
        int columnaFecha = 1, columnaNoFase = 0;
        List<Fase> fases = new ArrayList<>();

        for (int i = 0; i < modeloTablaFases.getRowCount(); i++) {
            int noFase = (int) modeloTablaFases.getValueAt(i, columnaNoFase);
            Date fechaFase = (Date) modeloTablaFases.getValueAt(i, columnaFecha);
            Fase fase = new Fase(noFase, fechaFase);
            fase.generarId();
            fases.add(fase);
        }

        String codigoCasting = this.txtCodigoCasting.getText();
        String nombre = this.txtNombreCasting.getText();
        String descripcion = this.txtaDescripcion.getText();
        LocalDate fechaTemporal = this.dtpFechaContracion.getDate();
        String costo = this.txtCostoCasting.getText();
        String noPersonas = this.txtNoPersonas.getText();

        try {
            this.verificarDatosCasting(codigoCasting, nombre, descripcion, fechaTemporal, costo, noPersonas);
        } catch (DatosCastingIncorrectosException dcie) {
            this.mostrarError(dcie.getMessage());
            return;
        }

        double costoDouble = Double.parseDouble(costo);
        int noPersonasInt = Integer.parseInt(noPersonas);
        GregorianCalendar fechaCasting;
        try {
            fechaCasting = new GregorianCalendar(fechaTemporal.getYear(), (fechaTemporal.getMonthValue() - 1), fechaTemporal.getDayOfMonth(), 0, 0, 0);
        } catch (Exception e) {
            this.mostrarError(e.getMessage());
            return;
        }

        int indiceCodCliente = 0, indiceNumEmpleado = 0;
        DefaultTableModel modeloTablaAgentes = (DefaultTableModel) this.tblAgentes.getModel();
        DefaultTableModel modeloTablaClientes = (DefaultTableModel) this.tblClientes.getModel();
        String numEmpleado = (String) modeloTablaAgentes.getValueAt(indiceSelAgentes, indiceNumEmpleado);
        String codigoCliente = (String) modeloTablaClientes.getValueAt(indiceSelClientes, indiceCodCliente);

        Cliente cliente = logica.obtenerCliente(codigoCliente);
        Agente agente = logica.obtenerAgente(numEmpleado);
        ClienteCasting clienteCasting = new ClienteCasting(costoDouble);
        clienteCasting.generarId();
        Date fechaDeCasting = new Date(fechaCasting.getTimeInMillis());
        GregorianCalendar fechaActualIncial = new GregorianCalendar();
        GregorianCalendar fechaActual = new GregorianCalendar(fechaActualIncial.get(Calendar.YEAR), fechaActualIncial.get(Calendar.MONTH), fechaActualIncial.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date actual = new Date(fechaActual.getTimeInMillis());

        if (fechaDeCasting.before(actual)) {
            this.mostrarError("La fecha del casting ingresada ya pasó");
            return;
        }

        Presencial casting = new Presencial(codigoCasting, nombre, descripcion, fechaDeCasting, cliente, clienteCasting, noPersonasInt, agente, fases);
        casting.generarId();
        try {
            logica.registrarCasting(casting);
        } catch (Exception e) {
            this.mostrarError(e.getMessage());
            return;
        }

        this.mostrarMensajeGuardadoExitoso();
        this.limpiarCampos();
    }//GEN-LAST:event_btnRegistrarCastingActionPerformed

    private void txtCodigoCastingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCastingActionPerformed
 
    }//GEN-LAST:event_txtCodigoCastingActionPerformed
    /**
     * Función del campo de texto código casting.
     *
     * @param evt evento al que escucha.
     */
    private void txtCodigoCastingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCastingKeyTyped
     if (this.txtCodigoCasting.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoCastingKeyTyped
    /**
     * Función del campo de texto nombre.
     *
     * @param evt evento al que escucha.
     */
    private void txtNombreCastingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCastingKeyTyped
        if (this.txtNombreCasting.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCastingKeyTyped
    /**
     * Función del campo de texto costo.
     *
     * @param evt evento al que escucha.
     */
    private void txtCostoCastingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoCastingKeyTyped
       if (this.txtCostoCasting.getText().length() >= 15) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoCastingKeyTyped
    /**
     * Función del campo de texto número de personas.
     *
     * @param evt evento al que escucha.
     */
    private void txtNoPersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoPersonasKeyTyped
       if (this.txtNoPersonas.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNoPersonasKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFase;
    private javax.swing.JButton btnEliminarFase;
    private javax.swing.JButton btnRegistrarCasting;
    private javax.swing.JButton btnVolver;
    private com.github.lgooddatepicker.components.DatePicker dtpFechaContracion;
    private com.github.lgooddatepicker.components.DatePicker dtpFechaFase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlAgregarFase;
    private javax.swing.JTable tblAgentes;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblFases;
    private javax.swing.JTextField txtCodigoCasting;
    private javax.swing.JTextField txtCostoCasting;
    private javax.swing.JTextField txtNoPersonas;
    private javax.swing.JTextField txtNombreCasting;
    private javax.swing.JTextArea txtaDescripcion;
    // End of variables declaration//GEN-END:variables
}
