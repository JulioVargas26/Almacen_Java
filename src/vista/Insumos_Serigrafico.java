package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.InsumoAction;
import controlador.SerigrafiadoAction;
import entidad.insumo;
import entidad.serigrafiado;

public class Insumos_Serigrafico implements ActionListener {

	private JFrame frame;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JButton btnExportar;
	private JTextField txtGuiaIngreso;
	private JTextField txtGuiaSalida;
	private JTextField txtIngreso;
	private JTextField txtSalida;
	private JTable tbRegistro;
	private JComboBox cboBotella;
	private JButton btnAdicionar;
	
	DefaultTableModel model=new DefaultTableModel();
	SerigrafiadoAction obj= new SerigrafiadoAction();
	private ArrayList<insumo> lista; 
	private int cod_insumo;

	Insumos_Botella Ib = new Insumos_Botella();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insumos_Serigrafico window = new Insumos_Serigrafico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Insumos_Serigrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 641, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Tipo de Botella : ");
		lblNewLabel.setBounds(27, 88, 101, 21);
		frame.getContentPane().add(lblNewLabel);

		cboBotella = new JComboBox();
		cboBotella.addActionListener(this);
		cboBotella.setModel(new DefaultComboBoxModel(new String[] { "Seleccione ...", "botella 350 ml",
				"botella 500 ml", "botella 700 ml", "botella 1.0 Lt", "botella 1.4 Lt" }));
		cboBotella.setBounds(134, 87, 333, 22);
		frame.getContentPane().add(cboBotella);

		JLabel lblNewLabel_1 = new JLabel("Cantidad de Salidad");
		lblNewLabel_1.setBounds(27, 136, 120, 21);
		frame.getContentPane().add(lblNewLabel_1);

		txtSalida = new JTextField();
		txtSalida.setBounds(157, 135, 150, 22);
		frame.getContentPane().add(txtSalida);
		txtSalida.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Cantidad de  Ingreso ");
		lblNewLabel_2.setBounds(27, 180, 120, 21);
		frame.getContentPane().add(lblNewLabel_2);

		txtIngreso = new JTextField();
		txtIngreso.setBounds(157, 180, 150, 21);
		frame.getContentPane().add(txtIngreso);
		txtIngreso.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("N\u00BA de guia");
		lblNewLabel_3.setBounds(317, 139, 120, 18);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("N\u00BA de guia");
		lblNewLabel_3_1.setBounds(317, 183, 120, 18);
		frame.getContentPane().add(lblNewLabel_3_1);

		txtGuiaSalida = new JTextField();
		txtGuiaSalida.setBounds(447, 136, 150, 20);
		frame.getContentPane().add(txtGuiaSalida);
		txtGuiaSalida.setColumns(10);

		txtGuiaIngreso = new JTextField();
		txtGuiaIngreso.setBounds(447, 180, 150, 20);
		frame.getContentPane().add(txtGuiaIngreso);
		txtGuiaIngreso.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 279, 571, 177);
		frame.getContentPane().add(scrollPane);

		tbRegistro = new JTable();
		scrollPane.setViewportView(tbRegistro);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(78, 228, 120, 23);
		frame.getContentPane().add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(259, 228, 120, 23);
		frame.getContentPane().add(btnCancelar);

		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(this);
		btnExportar.setBounds(427, 228, 120, 23);
		frame.getContentPane().add(btnExportar);

		JLabel lblNewLabel_4 = new JLabel("Control de Insumos Serigrafiados");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 11, 605, 37);
		frame.getContentPane().add(lblNewLabel_4);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(477, 87, 120, 22);
		frame.getContentPane().add(btnAdicionar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			Ib.show();
		}

		if (e.getSource() == cboBotella) {
			cboBotellaActionPerformed(e);
		}
		if (e.getSource() == btnExportar) {
			btnExportarActionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			
		}
		if (e.getSource() == btnRegistrar) {

			int grabo = grabar();
			if (grabo == 1)
				mostrarmensaje("si registro");
			else
				mostrarmensaje("que pena");
			this.llenarDatosTabla();
			this.limpiarFormulario();
		}

	}

	protected void cboBotellaActionPerformed(ActionEvent e) {

	}

	protected int grabar() {

		int cantSalida = Integer.parseInt(txtSalida.getText());
		int cantIngreso = Integer.parseInt(txtIngreso.getText());

		int merma = cantSalida - cantIngreso;
		JOptionPane.showMessageDialog(null, merma + " de merma");
		return merma;

	}

	protected void limpiarFormulario() {

		cboBotella.setSelectedIndex(0);
		txtSalida.setText("");
		txtGuiaSalida.setText("");
		txtIngreso.setText("");
		txtGuiaIngreso.setText("");

	}

	protected void btnExportarActionPerformed(ActionEvent e) {

	}

	private void listar() {
		List<serigrafiado> lista = new ArrayList<serigrafiado>();
		SerigrafiadoAction action = new SerigrafiadoAction();

		lista = action.listar();

		// Agregar la lista al JTable
		// Obtener el modelo de la tabla
		DefaultTableModel modelo = (DefaultTableModel) tbRegistro.getModel();

		// Limpiamos los datos del modelo
		modelo.getDataVector().clear();

		// Agregar datos
		for (serigrafiado serigrafiado : lista) {
			Object[] row = { serigrafiado.getFecha(), serigrafiado.getCantSalida(), serigrafiado.getGuiaSalida(),
					serigrafiado.getCantSalida(), serigrafiado.getGuiaIngreso(), serigrafiado.getMerma() };

			modelo.addRow(row);
		}

	}

	private void llenarCabecera() {
		model.addColumn("Fecha");
		model.addColumn("Cantidad Salida");
		model.addColumn("Guia Salida");
		model.addColumn("Cantidad Ingreso");
		model.addColumn("Guia Ingreso");
		model.addColumn("Merma");
		tbRegistro.setModel(model);
	}

	private void llenarDatosTabla() {
		model.setRowCount(0);
		lista = obj.listarInsumo(null);
		for (insumo p : lista) {
			Object Fila[] = { p.getCod_insumo(), p.getDescripcion(),

			};
			model.addRow(Fila);
		}
	}

	private void mostrarmensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
}
