package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.InsumoAction;
import entidad.insumo;

public class Insumos_Botella extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable table;

	DefaultTableModel model = new DefaultTableModel();
	InsumoAction obj = new InsumoAction();
	private ArrayList<insumo> lista;
	private int cod_insumo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Insumos_Botella frame = new Insumos_Botella();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Insumos_Botella() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(113, 58, 163, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(10, 100, 109, 23);
		contentPane.add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(167, 100, 109, 23);
		contentPane.add(btnCancelar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 266, 204);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setBounds(10, 61, 93, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Adicionar Nuevo Insumo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 266, 36);
		contentPane.add(lblNewLabel_1);

		this.llenarCabecera();
		this.llenarDatosTabla();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			dispose();
		}
		if (e.getSource() == btnRegistrar) {
			int grabo = grabar();
			if (grabo == 1)
				mostrarmensaje("si grabo");
			this.llenarDatosTabla();
			this.txtDescripcion.setText("");
		}
	}

	protected int grabar() {
		int grabo = 0;

		insumo p = new insumo(cod_insumo, null);
		p.setDescripcion(this.txtDescripcion.getText());

		if (txtDescripcion.getText().length() != 0) {
			grabo = obj.ingresarInsumo(p);
		} else {
			mostrarmensaje("ingrese dato");
		}

		return grabo;
	}

	private void llenarCabecera() {
		model.addColumn("codigo");
		model.addColumn("Descricion");
		table.setModel(model);
	}

	private void llenarDatosTabla() {
		model.setRowCount(0);
		lista = obj.listarInsumo(null);
		for (insumo p : lista) {
			Object Fila[] = { p.getCod_insumo(), p.getDescripcion(), };
			model.addRow(Fila);
		}
	}

	private void mostrarmensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

}
