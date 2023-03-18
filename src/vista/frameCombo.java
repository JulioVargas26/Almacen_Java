package vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class frameCombo extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtNama;
	@SuppressWarnings("rawtypes")
	private JComboBox cbJurusan;
	private JTextArea textAlamat;
	private JButton btnTambah;
	private JTextField txtJurusan;
	private JLabel lblIcon;
	private JLabel lblIcon2;
	private JLabel lblWall;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public frameCombo()
	{
		super("Tambah Item ComboBox");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNama = new JLabel("Nama : ");
		lblNama.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNama.setForeground(new Color(255, 255, 255));
		lblNama.setBounds(12, 12, 70, 15);
		contentPane.add(lblNama);
		
		txtNama = new JTextField();
		txtNama.setBounds(114, 10, 196, 25);
		contentPane.add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblJurusan = new JLabel("Jurusan : ");
		lblJurusan.setFont(new Font("Dialog", Font.BOLD, 13));
		lblJurusan.setForeground(new Color(255, 255, 255));
		lblJurusan.setBounds(12, 49, 70, 15);
		contentPane.add(lblJurusan);
		
		cbJurusan = new JComboBox();
		cbJurusan.setModel(new DefaultComboBoxModel(new String[] {"TI", "SI", "Ekonomi"}));
		cbJurusan.setBounds(114, 44, 181, 30);
		contentPane.add(cbJurusan);
		
		JLabel lblAlamat = new JLabel("Alamat : ");
		lblAlamat.setFont(new Font("Dialog", Font.BOLD, 13));
		lblAlamat.setForeground(new Color(255, 255, 255));
		lblAlamat.setBounds(12, 102, 70, 15);
		contentPane.add(lblAlamat);
		
		textAlamat = new JTextArea();
		textAlamat.setBounds(115, 97, 232, 130);
		contentPane.add(textAlamat);
		
		btnTambah = new JButton("");
		btnTambah.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent act)
			{
				if(!txtJurusan.getText().equals(""))
				{
					int i = 0;
					for(int a=0;a<cbJurusan.getItemCount(); a++)
					{
						if(cbJurusan.getItemAt(a).equals(txtJurusan.getText()))
						{
							i = 1;
							break;
						}
					}
					if(i == 1)
					{
						JOptionPane.showMessageDialog(null, "Jurusan sudah tersedia");
					}
					else
					{
						cbJurusan.addItem(txtJurusan.getText());
						JOptionPane.showMessageDialog(null, "Jurusan baru telah ditambahkan");
					}
				}
			}
		});
		btnTambah.setBounds(461, 46, 70, 28);
		contentPane.add(btnTambah);
		
		txtJurusan = new JTextField();
		txtJurusan.setBounds(307, 47, 142, 25);
		contentPane.add(txtJurusan);
		txtJurusan.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setBounds(419, 97, 128, 152);
		contentPane.add(lblIcon);
		
		lblIcon2 = new JLabel("");
		lblIcon2.setBounds(447, 241, 83, 72);
		contentPane.add(lblIcon2);
		
		lblWall = new JLabel("");
		lblWall.setBounds(0, 0, 604, 351);
		contentPane.add(lblWall);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					frameCombo frame = new frameCombo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
