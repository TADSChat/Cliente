package br.univel.ChatRedes.view;

<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> refs/remotes/origin/master
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
=======
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
>>>>>>> refs/remotes/origin/master
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
<<<<<<< HEAD
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.univel.ChatRedes.model.JNumberField;
=======
import javax.swing.border.EmptyBorder;

import common.EntidadeUsuario;
import common.InterfaceServidor;
import common.Status;
import javax.swing.JTextArea;
>>>>>>> refs/remotes/origin/master

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField field_email;
	private JTextField field_servidor;
	
	private JPasswordField field_senha;
<<<<<<< HEAD
	
	private JNumberField field_porta;
=======
	private JTextField field_nome;
	private EntidadeUsuario user;
	private Registry registryConexaoCliente;
	private InterfaceServidor conexaoCliente;
>>>>>>> refs/remotes/origin/master

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
<<<<<<< HEAD
		gbl_contentPane.columnWidths = new int[]{198, 119, 141, 143, 193, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
=======
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
>>>>>>> refs/remotes/origin/master
		contentPane.setLayout(gbl_contentPane);
		
		Icon logo = new ImageIcon("user.png");
		JLabel lblNewLabel = new JLabel(logo);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
<<<<<<< HEAD
=======
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
		gbc_field_nome.insets = new Insets(0, 0, 5, 0);
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
		
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
				new Principal(field_email.getText(),
								field_senha.getPassword(),
								field_porta.getText(),
								field_servidor.getText()).setVisible(true);
				dispose();
=======
				
				user = new EntidadeUsuario();

				String pass = String.copyValueOf(field_senha.getPassword());

				user.setEmail(field_email.getText());
				user.setNome(field_nome.getText());
				user.setSenha(pass);
				user.setStatus(Status.ONLINE);
				
				int porta = Integer.valueOf(field_porta.getText());
					try {
						registryConexaoCliente = LocateRegistry.getRegistry(field_servidor.getText(), porta);
						conexaoCliente = (InterfaceServidor) registryConexaoCliente.lookup(InterfaceServidor.NOME);
						System.out.println("OPA");
//						conexaoCliente.conectarChat(user, this);
						new Principal(user, conexaoCliente).setVisible(true);
						dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "\n\n-------------------------------------------------------\n"
								+ "ERRO: VERIFIQUE SE O SERVIDOR ESTÃO RODANDO, SE O IP E PORTA ESTÃO"
								+ " CORRETOS, SE NÃO HÁ BLOQUEIO DE FIREWALL OU ANTIVIRUS.\n"
								+ "-------------------------------------------------------------------\n\n");

					}
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
		gbc_btnConectar.gridwidth = 3;
		gbc_btnConectar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConectar.fill = GridBagConstraints.BOTH;
		gbc_btnConectar.gridx = 1;
=======
		gbc_btnConectar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConectar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConectar.gridx = 2;
>>>>>>> refs/remotes/origin/master
		gbc_btnConectar.gridy = 11;
		contentPane.add(btnConectar, gbc_btnConectar);
		
<<<<<<< HEAD
		
=======
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.insets = new Insets(0, 0, 5, 0);
		gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSair.gridx = 3;
		gbc_btnSair.gridy = 11;
		contentPane.add(btnSair, gbc_btnSair);
>>>>>>> refs/remotes/origin/master
	}
	
}
