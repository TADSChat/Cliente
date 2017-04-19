package br.univel.ChatRedes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField field_email;
	private JTextField field_servidor;
	private JTextField field_porta;
	private JPasswordField field_senha;
	private JTextField field_nome;

	/**
	 * Create the frame.
	 */
	public Login() {
		setVisible(true);
		setTitle("TadsZap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("TadsZap");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);
		
		field_nome = new JTextField();
		GridBagConstraints gbc_field_nome = new GridBagConstraints();
		gbc_field_nome.fill = GridBagConstraints.HORIZONTAL;
		gbc_field_nome.gridwidth = 4;
		gbc_field_nome.insets = new Insets(0, 0, 5, 5);
		gbc_field_nome.gridx = 0;
		gbc_field_nome.gridy = 2;
		contentPane.add(field_nome, gbc_field_nome);
		field_nome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		field_email = new JTextField();
		GridBagConstraints gbc_field_email = new GridBagConstraints();
		gbc_field_email.insets = new Insets(0, 0, 5, 0);
		gbc_field_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_field_email.gridwidth = 4;
		gbc_field_email.gridx = 0;
		gbc_field_email.gridy = 4;
		contentPane.add(field_email, gbc_field_email);
		field_email.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.WEST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 5;
		contentPane.add(lblSenha, gbc_lblSenha);
		
		field_senha = new JPasswordField();
		GridBagConstraints gbc_field_senha = new GridBagConstraints();
		gbc_field_senha.gridwidth = 4;
		gbc_field_senha.insets = new Insets(0, 0, 5, 0);
		gbc_field_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_field_senha.gridx = 0;
		gbc_field_senha.gridy = 6;
		contentPane.add(field_senha, gbc_field_senha);
		
		JLabel lblServidor = new JLabel("Servidor:");
		GridBagConstraints gbc_lblServidor = new GridBagConstraints();
		gbc_lblServidor.anchor = GridBagConstraints.WEST;
		gbc_lblServidor.insets = new Insets(0, 0, 5, 5);
		gbc_lblServidor.gridx = 0;
		gbc_lblServidor.gridy = 7;
		contentPane.add(lblServidor, gbc_lblServidor);
		
		field_servidor = new JTextField();
		GridBagConstraints gbc_field_servidor = new GridBagConstraints();
		gbc_field_servidor.insets = new Insets(0, 0, 5, 0);
		gbc_field_servidor.gridwidth = 4;
		gbc_field_servidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_field_servidor.gridx = 0;
		gbc_field_servidor.gridy = 8;
		contentPane.add(field_servidor, gbc_field_servidor);
		field_servidor.setColumns(10);
		
		JLabel lblSenha_1 = new JLabel("Porta:");
		GridBagConstraints gbc_lblSenha_1 = new GridBagConstraints();
		gbc_lblSenha_1.anchor = GridBagConstraints.WEST;
		gbc_lblSenha_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha_1.gridx = 0;
		gbc_lblSenha_1.gridy = 9;
		contentPane.add(lblSenha_1, gbc_lblSenha_1);
		
		field_porta = new JTextField();
		GridBagConstraints gbc_field_porta = new GridBagConstraints();
		gbc_field_porta.insets = new Insets(0, 0, 5, 0);
		gbc_field_porta.fill = GridBagConstraints.HORIZONTAL;
		gbc_field_porta.gridwidth = 4;
		gbc_field_porta.gridx = 0;
		gbc_field_porta.gridy = 10;
		contentPane.add(field_porta, gbc_field_porta);
		field_porta.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Principal(field_email.getText(),
								field_senha.getPassword(),
								field_porta.getText(),
								field_servidor.getText(),
								field_nome.getText()).setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnConectar = new GridBagConstraints();
		gbc_btnConectar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConectar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConectar.gridx = 2;
		gbc_btnConectar.gridy = 11;
		contentPane.add(btnConectar, gbc_btnConectar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSair.gridx = 3;
		gbc_btnSair.gridy = 11;
		contentPane.add(btnSair, gbc_btnSair);
	}

}