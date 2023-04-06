package infrastructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.model.Participante;
import domain.portsout.InscripcionAlmacenamiento;

public class AgregarParticipante extends JFrame {

	private static final long serialVersionUID = 1L;
	private InscripcionAlmacenamiento almacenamiento;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;

	public AgregarParticipante(InscripcionAlmacenamiento almacenamiento) throws SQLException {
		this.almacenamiento = almacenamiento;
		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(e -> onBotonCargar());
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() {

		try {
			Participante participante = new Participante(nombre.getText(), telefono.getText(), region.getText(),
					this.almacenamiento);
			participante.inscribir();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		dispose();
	}

}
