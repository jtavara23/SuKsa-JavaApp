import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class VentPrincipal extends javax.swing.JFrame
{
    private final MySQL conexionMySql;
    private DefaultComboBoxModel<String> comboModel;
    private ResultSet datos;
    DefaultTableModel dtm;
    
    public VentPrincipal() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("SU KSA SOLUCIONES INMOBILIARIA");
        conexionMySql = new MySQL("localhost", "fotocasa", "root", "");
        llenarCombo(getDepartamentos(), jComboBox3);
        
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        this.jComboBox3.setEnabled(false);
    }

    public ArrayList<String> getDepartamentos() throws SQLException {
        ArrayList<String> registro = new ArrayList<String>();
        registro.clear();
        ResultSet datos = conexionMySql.consultar("select distinct nomDepartamento from departamentos");
        registro.add("Todos");
        while (datos.next()) {
            registro.add(datos.getString(1));
        }
        return registro;
    }
    
    private void llenarCombo(ArrayList<String> combo, JComboBox comboTipo) throws SQLException {
            String[] listaTipos = new String[combo.size()+1];
            listaTipos = combo.toArray(listaTipos);
            comboModel = new DefaultComboBoxModel<>(listaTipos);
            comboTipo.setModel(comboModel);
    }
    
    private void getTablaTipo1 () {
        String[] cols = {"Vendedor", "Numero de Ventas", "Dinero en Ventas"};
        dtm = new DefaultTableModel(null, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setModel(dtm);
    }
    
    private void getTablaTipo2 () {
        String[] cols = {"Año", "Numero de Ventas", "Dinero en Ventas"};
        dtm = new DefaultTableModel(null, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setModel(dtm);
    }
    private void getTablaTipo3 () {
        String[] cols = {"Numero de Inmueble", "Año", "Precio Promedio"};
        dtm = new DefaultTableModel(null, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setModel(dtm);
    }
    
    private void getTablaTipo4 () {
        String[] cols = {"Categoria Iinmueble","Departamento", "Numero de Casas Vendidas"};
        dtm = new DefaultTableModel(null, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setModel(dtm);
    }
    
    private void getTablaTipo5 () {
        String[] cols = {"Estados de Casas", "Numero de Casas"};
        dtm = new DefaultTableModel(null, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setModel(dtm);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        panelGrafico = new javax.swing.JPanel();
        lblGrafico = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jRadioButton5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        tabla1.setAutoCreateRowSorter(true);
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla1.getTableHeader().setResizingAllowed(false);
        tabla1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla1);

        panelGrafico.setBackground(new java.awt.Color(255, 255, 255));

        lblGrafico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoLayout.createSequentialGroup()
                .addComponent(lblGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Obtener por vendedor el número de ventas y el monto total recaudado.");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Obtener por año el número de ventas y el monto total recaudado.");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Obtener los precios que tuvo y tiene una casa.");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Obtener por categoría el número total de casas vendidas por departamento.");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Numero de Ventas", "Dinero en Ventas" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Numero de Ventas", "Dinero en Ventas" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Obtener el número total de casas vendidas y no vendidas.");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton4)
                                .addGap(29, 29, 29)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        consulta1();
        this.jComboBox1.setEnabled(true);
        this.jComboBox2.setEnabled(false);
        this.jComboBox3.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        consulta2();
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(true);
        this.jComboBox3.setEnabled(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        consulta3();
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        this.jComboBox3.setEnabled(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        consulta4();
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        this.jComboBox3.setEnabled(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        consulta5();
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        this.jComboBox3.setEnabled(false);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       consulta1();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        consulta2();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        consulta4();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    public void consulta1()
    {
        getTablaTipo1();
        datos = conexionMySql.consultar(""+
        "SELECT  CONCAT(vendedor.nombre,CONCAT(' ',vendedor.apellidos)) AS Vendedor, COUNT(*) AS Numero_de_Ventas, \n" +
        "        SUM(costo_casa.precio) AS Dinero_en_Ventas\n" +
        "FROM	 central\n" +
        "JOIN    (\n" +
        "	    SELECT   inmueble.idInmueble, MIN(tabla1.dias) AS dias, tabla1.precio\n" +
        "	    FROM     inmueble\n" +
        "	    JOIN     (\n" +
        "		       SELECT   inm.idInmueble, DATEDIFF(inm.fechaCompra,precio.fechaPrecio) AS dias, precio\n" +
        "		       FROM     precio\n" +
        "		       JOIN     (\n" +
        "				   SELECT  idInmueble, fechaCompra\n" +
        "				   FROM    inmueble\n" +
        "				   WHERE   fechaCompra IS NOT NULL\n" +
        "			         ) AS inm ON inm.idInmueble = precio.inmueble_idInmueble\n" +
        "		       WHERE    precio.fechaPrecio <= inm.fechaCompra\n" +
        "		       ORDER BY inm.idInmueble, dias\n" +
        "		     ) AS tabla1 ON tabla1.idInmueble = inmueble.idInmueble\n" +
        "	     GROUP BY  inmueble.idInmueble\n" +
        "	   ) AS costo_casa ON costo_casa.idInmueble = central.inmueble_idInmueble\n" +
        "JOIN      vendedor ON vendedor.idVendedor = central.vendedor_idVendedor\n" +
        "GROUP BY  central.vendedor_idVendedor;");
        if (datos != null) {
            try {
                while (datos.next()) {
                    Object [] o = {datos.getString(1), datos.getString(2), datos.getString(3)};
                    dtm.addRow(o);
                }
            } catch (SQLException ex) {
            }
        }
        if(jComboBox1.getSelectedIndex()==0)
            asignar("CONSULTA 1", "Vendedores", "Numero de Ventas", obtenerDatos(0,1));
        else
            asignar("CONSULTA 2", "Vendedores", "Dinero en Ventas", obtenerDatos(0,2));
    }
    
    public void consulta2()
    {
        getTablaTipo2();
        datos = conexionMySql.consultar(""+
        "SELECT  fecha.Anio AS Anio_de_Compra, COUNT(*) AS Cantidad_de_Ventas, SUM(fecha.precio) AS Dinero_en_Ventas\n" +
        "FROM    inmueble\n" +
        "JOIN    (\n" +
        "          SELECT   inmueble.idInmueble, MIN(tabla1.dias) AS dias, tabla1.precio, YEAR(fechaCompra) AS Anio\n" +
        "          FROM	    inmueble\n" +
        "	   JOIN     (\n" +
        "		      SELECT    inm.idInmueble, DATEDIFF(inm.fechaCompra,precio.fechaPrecio) AS dias, precio\n" +
        "                     FROM      precio\n" +
        "		      JOIN      (\n" +
        "				  SELECT   idInmueble, fechaCompra\n" +
        "				  FROM 	   inmueble\n" +
        "				  WHERE    fechaCompra IS NOT NULL\n" +
        "			        ) AS inm ON inm.idInmueble = precio.inmueble_idInmueble\n" +
        "		      WHERE     precio.fechaPrecio <= inm.fechaCompra\n" +
        "		      ORDER BY  inm.idInmueble, dias\n" +
        "		    ) AS tabla1 ON tabla1.idInmueble = inmueble.idInmueble\n" +
        "	   GROUP BY inmueble.idInmueble\n" +
        "	  ) AS fecha ON fecha.idInmueble = inmueble.idInmueble															\n" +
        "GROUP BY fecha.Anio;");
        if (datos != null) {
            try {
                while (datos.next()) {
                    Object [] o = {datos.getString(1), datos.getString(2), datos.getString(3)};
                    dtm.addRow(o);
                }
            } catch (SQLException ex) {
            }
        }
        if(jComboBox2.getSelectedIndex()==0)
            asignar("CONSULTA 3", "Año", "Numero de Ventas", obtenerDatos(0,1));
        else
            asignar("CONSULTA 4", "Año", "Dinero en Ventas", obtenerDatos(0,2));
    }
    
    public void consulta3()
    {
        getTablaTipo3();
        
        String msm = "";
        JTextField JT_Textfield = new JTextField("");
        
        int rpta = JOptionPane.showConfirmDialog(this, JT_Textfield, "Ingrese Direccion de Casa:", 
                                                 JOptionPane.OK_CANCEL_OPTION);
        
        if (rpta == JOptionPane.OK_OPTION) 
            msm = JT_Textfield.getText();
        else
            msm = "";
        
        if(!msm.equals(""))
        {
            datos = conexionMySql.consultar(""+
            "SELECT 	 direccion, YEAR(fechaPrecio) AS anio, ROUND(SUM(precio)/COUNT(*)) AS Promedio_Anual\n" +
            "FROM        precio\n" +
            "JOIN        inmueble ON inmueble.idInmueble = precio.inmueble_idInmueble\n" +
            "WHERE 	 inmueble.direccion  = '"+msm+"'\n" +
            "GROUP BY    anio;");
            if (datos != null) {
                try {
                    while (datos.next()) {
                        Object [] o = {datos.getString(1), datos.getString(2), datos.getString(3)};
                        dtm.addRow(o);
                    }
                } catch (SQLException ex) {
                }
            }
            asignar("CONSULTA 5", "Año", "Precio de Casa", obtenerDatos(1,2));
        }
    }
    
    public void consulta4()
    {
        getTablaTipo4();
        
        if(!jComboBox3.getSelectedItem().toString().equals("Todos"))
        {
            datos = conexionMySql.consultar(""+
            "SELECT    tipo_nomTipo, nomDepartamento, COUNT(*) AS Cantidad_Casas_Vendidas\n" +
            "FROM      central\n" +
            "JOIN      distritos ON distritos.idDistrito = central.distritos_idDistrito\n" +
            "JOIN      provincias ON provincias.idProvincia = distritos.idProvincia\n" +
            "JOIN      departamentos ON departamentos.idDepartamento = provincias.idDepartamento\n" +
            "WHERE     cliente_email IS NOT NULL AND nomDepartamento = '"+jComboBox3.getSelectedItem().toString()+"'\n" +
            "GROUP BY  tipo_nomTipo, nomDepartamento;");
        }
        else
        {
            datos = conexionMySql.consultar(""+
            "SELECT    tipo_nomTipo, nomDepartamento, COUNT(*) AS Cantidad_Casas_Vendidas\n" +
            "FROM      central\n" +
            "JOIN      distritos ON distritos.idDistrito = central.distritos_idDistrito\n" +
            "JOIN      provincias ON provincias.idProvincia = distritos.idProvincia\n" +
            "JOIN      departamentos ON departamentos.idDepartamento = provincias.idDepartamento\n" +
            "WHERE     cliente_email IS NOT NULL\n" +
            "GROUP BY  tipo_nomTipo, nomDepartamento;");
        }    
        if (datos != null) {
            try {
                while (datos.next()) {
                    Object [] o = {datos.getString(1), datos.getString(2), datos.getString(3)};
                    dtm.addRow(o);
                }
            } catch (SQLException ex) {
            }
        }
        asignar("CONSULTA 6", "Categoria de Inmueble", "Cantidad de Casas Vendidas", obtenerDatos(0,2));
    }
    
    public void consulta5()
    {
        getTablaTipo5();
        
        datos = conexionMySql.consultar(""+
        "SELECT      COUNT(*) AS Numero_Casas\n" +
        "FROM	     central\n" +
        "WHERE       cliente_email IS NOT NULL\n" +
        "UNION ALL\n" +
        "SELECT      COUNT(*) AS Numero_Casas\n" +
        "FROM        central\n" +
        "WHERE       cliente_email IS NULL;");
        
        if (datos != null) {
            try {
                    datos.next();
                    Object [] o = {"Casas Vendidas",datos.getString(1)};
                    dtm.addRow(o);
                    datos.next();
                    Object [] o1 = {"Casas No Vendidas",datos.getString(1)};
                    dtm.addRow(o1);
            } catch (SQLException ex) {
            }
        }
        
        asignar2("CONSULTA 7", obtenerDatos(0,1));
    }
    
    public ArrayList<ArrayList<Object>> obtenerDatos(int num_fila, int num_column)
    {
        ArrayList<Object> al = new ArrayList<>();
        ArrayList<ArrayList<Object>> datos = new ArrayList<>();
        for (int i = 0 ; i < dtm.getRowCount() ; i++) {
            al.add(dtm.getValueAt(i, num_fila).toString());
            al.add(dtm.getValueAt(i, num_column));
            datos.add(new ArrayList<>(al));
            al.clear();
        }
        return datos;
    }
    
    public void asignar(String title, String ejeX, String ejeY, ArrayList<ArrayList<Object>> data)
    {
        JFreeChart barra;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        DefaultPieDataset  datos2 = new DefaultPieDataset();
        
        for (ArrayList<Object> o : data) {
            datos.setValue(Integer.parseInt(o.get(1).toString()), o.get(0).toString(), "");
        }
        ChartFactory.createPieChart3D(title, datos2);
        barra = ChartFactory.createBarChart3D(title, ejeX, ejeY, datos, PlotOrientation.VERTICAL, true, true, true);
        BufferedImage graficoBarra = barra.createBufferedImage(lblGrafico.getWidth(), lblGrafico.getHeight());
        lblGrafico.setSize(lblGrafico.getSize());
        lblGrafico.setIcon(new ImageIcon(graficoBarra));
        panelGrafico.updateUI();
    }
    
    public void asignar2(String title, ArrayList<ArrayList<Object>> data)
    {
        JFreeChart barra;
        DefaultPieDataset  datos2 = new DefaultPieDataset();
        
        for (ArrayList<Object> o : data) {
            datos2.setValue(o.get(0).toString(), Integer.parseInt(o.get(1).toString()));
        }
        barra = ChartFactory.createPieChart3D(title,datos2, true, true, true);
        BufferedImage graficoBarra = barra.createBufferedImage(lblGrafico.getWidth(), lblGrafico.getHeight());
        lblGrafico.setSize(lblGrafico.getSize());
        lblGrafico.setIcon(new ImageIcon(graficoBarra));
        panelGrafico.updateUI();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VentPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGrafico;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
