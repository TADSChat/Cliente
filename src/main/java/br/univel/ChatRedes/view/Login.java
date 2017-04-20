package br.univel.ChatRedes.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.univel.ChatRedes.model.JNumberField;

public class Login extends JFrame {

	private JPanel contentPane;
	
	private JTextField field_email;
	private JTextField field_servidor;
	
	private JPasswordField field_senha;
	
	private JNumberField field_porta;

	/**
	 * Create the frame.
	 */
	public Login() {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		setTitle("TadsZap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 387);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{198, 119, 141, 143, 193, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Icon logo = new ImageIcon("user.png");
		JLabel lblNewLabel = new JLabel(logo);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		field_email = new JTextField();
		field_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field_email.setForeground(Color.GRAY);
		field_email.setText("Email");
		field_email.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				field_email.setForeground(Color.BLACK);
				field_email.setText("");
			}
		});
		GridBagConstraints gbc_field_email = new GridBagConstraints();
		gbc_field_email.gridwidth = 3;
		gbc_field_email.gridheight = 2;
		gbc_field_email.insets = new Insets(0, 0, 5, 5);
		gbc_field_email.fill = GridBagConstraints.BOTH;
		gbc_field_email.gridx = 1;
		gbc_field_email.gridy = 6;
		contentPane.add(field_email, gbc_field_email);
		field_email.setColumns(10);
		
		field_senha = new JPasswordField("Senha");
		field_senha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field_senha.setForeground(Color.GRAY);
		field_senha.setToolTipText("");
		field_senha.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				field_senha.setForeground(Color.BLACK);
				field_senha.setText("");
			}
		});
		GridBagConstraints gbc_field_senha = new GridBagConstraints();
		gbc_field_senha.gridwidth = 3;
		gbc_field_senha.gridheight = 2;
		gbc_field_senha.insets = new Insets(0, 0, 5, 5);
		gbc_field_senha.fill = GridBagConstraints.BOTH;
		gbc_field_senha.gridx = 1;
		gbc_field_senha.gridy = 8;
		contentPane.add(field_senha, gbc_field_senha);
		
		field_servidor = new JTextField();
		field_servidor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field_servidor.setForeground(Color.GRAY);
		field_servidor.setText("Servidor");
		field_servidor.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				field_servidor.setForeground(Color.GRAY);
				field_servidor.setText("");
			}
		});
		GridBagConstraints gbc_field_servidor = new GridBagConstraints();
		gbc_field_servidor.gridwidth = 2;
		gbc_field_servidor.insets = new Insets(0, 0, 5, 5);
		gbc_field_servidor.fill = GridBagConstraints.BOTH;
		gbc_field_servidor.gridx = 1;
		gbc_field_servidor.gridy = 10;
		contentPane.add(field_servidor, gbc_field_servidor);
		field_servidor.setColumns(10);
		
		JButton btnConectar = new JButton("Login");
		btnConectar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Principal(field_email.getText(),
								field_senha.getPassword(),
								field_porta.getText(),
								field_servidor.getText()).setVisible(true);
				dispose();
			}
		});
		
		field_porta = new JNumberField();
		field_porta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field_porta.setForeground(Color.GRAY);
		field_porta.setText("Porta");
		GridBagConstraints gbc_field_porta = new GridBagConstraints();
		gbc_field_porta.insets = new Insets(0, 0, 5, 5);
		gbc_field_porta.fill = GridBagConstraints.BOTH;
		gbc_field_porta.gridx = 3;
		gbc_field_porta.gridy = 10;
		contentPane.add(field_porta, gbc_field_porta);
		field_porta.setColumns(10);
		GridBagConstraints gbc_btnConectar = new GridBagConstraints();
		gbc_btnConectar.gridwidth = 3;
		gbc_btnConectar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConectar.fill = GridBagConstraints.BOTH;
		gbc_btnConectar.gridx = 1;
		gbc_btnConectar.gridy = 11;
		contentPane.add(btnConectar, gbc_btnConectar);
		
		
	}
	
}
