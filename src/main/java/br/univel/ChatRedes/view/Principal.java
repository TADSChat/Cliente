package br.univel.ChatRedes.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import br.univel.ChatRedes.comum.MeuModelo;
import common.Arquivo;
import common.EntidadeUsuario;
import common.InterfaceServidor;
import common.InterfaceUsuario;
import common.Status;

public class Principal extends JFrame implements InterfaceUsuario {

	private JPanel contentPane;
	private Registry registryConexaoCliente;
	private InterfaceServidor conexaoCliente;
	private JTextField field_pesquisa_contato;
	private JTable tableContatos;
	private JTabbedPane tabbedConversas;
	private EntidadeUsuario user;
	
	private static Principal global;

	
	/**
	 * Create the frame.
	 * 
	 * @param nome
	 * @param string4
	 * @param string3
	 * @param string2
	 * @param string
	 */
	public Principal(String email, char[] senha, String porta, String servidor, String nome) {
		
		user = new EntidadeUsuario();
		
		String pass = String.copyValueOf(senha);
		
		user.setEmail(email);
		user.setNome(nome);
		user.setSenha(pass);
		user.setStatus(Status.ONLINE);
		
		iniciaRMI(porta, servidor);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TadsZap");
		setBounds(100, 100, 350, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnConexo = new JMenu("Conexão");
		menuBar.add(mnConexo);

		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mnConexo.add(mntmConectar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Alterar Dados");
		mnConexo.add(mntmNewMenuItem);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnConexo.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 324, 0 };
		gbl_contentPane.rowHeights = new int[] { 531, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNomeLogado = new JLabel(nome);
		lblNomeLogado.setFont(new Font("Tahoma", Font.PLAIN, 21));
		GridBagConstraints gbc_lblNomeLogado = new GridBagConstraints();
		gbc_lblNomeLogado.insets = new Insets(0, 0, 5, 0);
		gbc_lblNomeLogado.gridwidth = 4;
		gbc_lblNomeLogado.gridx = 0;
		gbc_lblNomeLogado.gridy = 0;
		panel.add(lblNomeLogado, gbc_lblNomeLogado);

		JRadioButton rdbtnOnline = new JRadioButton("Online");
		GridBagConstraints gbc_rdbtnOnline = new GridBagConstraints();
		gbc_rdbtnOnline.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnOnline.gridx = 0;
		gbc_rdbtnOnline.gridy = 2;
		panel.add(rdbtnOnline, gbc_rdbtnOnline);

		JRadioButton rdbtnOffline = new JRadioButton("Offline");
		GridBagConstraints gbc_rdbtnOffline = new GridBagConstraints();
		gbc_rdbtnOffline.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnOffline.gridx = 1;
		gbc_rdbtnOffline.gridy = 2;
		panel.add(rdbtnOffline, gbc_rdbtnOffline);

		JRadioButton rdbtnOcupado = new JRadioButton("Ocupado");
		GridBagConstraints gbc_rdbtnOcupado = new GridBagConstraints();
		gbc_rdbtnOcupado.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnOcupado.gridx = 2;
		gbc_rdbtnOcupado.gridy = 2;
		panel.add(rdbtnOcupado, gbc_rdbtnOcupado);

		JRadioButton rdbtnAusente = new JRadioButton("Ausente");
		GridBagConstraints gbc_rdbtnAusente = new GridBagConstraints();
		gbc_rdbtnAusente.gridx = 3;
		gbc_rdbtnAusente.gridy = 2;
		panel.add(rdbtnAusente, gbc_rdbtnAusente);

		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 322, 0 };
		gbl_panel_1.rowHeights = new int[] { 405, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel_1.add(tabbedPane, gbc_tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Contatos", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);

		tableContatos = new JTable();
		scrollPane_1.setViewportView(tableContatos);

		field_pesquisa_contato = new JTextField();
		GridBagConstraints gbc_field_pesquisa_contato = new GridBagConstraints();
		gbc_field_pesquisa_contato.insets = new Insets(0, 0, 0, 5);
		gbc_field_pesquisa_contato.fill = GridBagConstraints.HORIZONTAL;
		gbc_field_pesquisa_contato.gridx = 0;
		gbc_field_pesquisa_contato.gridy = 1;
		panel_2.add(field_pesquisa_contato, gbc_field_pesquisa_contato);
		field_pesquisa_contato.setColumns(10);

		JButton btnPesquisaContato = new JButton("Pesquisar");
		GridBagConstraints gbc_btnPesquisaContato = new GridBagConstraints();
		gbc_btnPesquisaContato.gridx = 1;
		gbc_btnPesquisaContato.gridy = 1;
		panel_2.add(btnPesquisaContato, gbc_btnPesquisaContato);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Chat", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		tabbedConversas = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 0;
		panel_3.add(tabbedConversas, gbc_tabbedPane_1);
		
		JPanel panel_4 = new Conversa();
		tabbedConversas.addTab("Público", null, panel_4, null);

		
		global = this;
	}
	
	public static EntidadeUsuario getUser(){
		return global.user;
	}
	
	public static void enviaArq(Arquivo arquivo){
		global.enviarArquivo(arquivo);
	}
	
	public static void enviaMsg(String msg){
		global.enviarMensagem(msg);
	}
	
	public void enviarArquivo(Arquivo arquivo){
		String titleAt = tabbedConversas.getTitleAt(tabbedConversas.getSelectedIndex());
		
		try {
		if(titleAt.equals("Público")){
			JOptionPane.showMessageDialog(null, "Voçe não pode enviar arquivo para todos");
		}else{
			EntidadeUsuario destinatario = new EntidadeUsuario();
			destinatario.setNome(titleAt);
				conexaoCliente.enviarArquivo(user, destinatario, arquivo);
		}
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarMensagem(String mensagem){
		
		String titleAt = tabbedConversas.getTitleAt(tabbedConversas.getSelectedIndex());
		
		try {
		if(titleAt.equals("Público")){
			conexaoCliente.enviarMensagem(user, mensagem);
		}else{
			EntidadeUsuario destinatario = new EntidadeUsuario();
			destinatario.setNome(titleAt);
				conexaoCliente.enviarMensagem(user, destinatario, mensagem);
		}
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

	private void iniciaRMI(String porta, String servidor) {
		int portaCon = Integer.valueOf(porta);
		try {
			registryConexaoCliente = LocateRegistry.getRegistry(servidor, portaCon);
			conexaoCliente = (InterfaceServidor) registryConexaoCliente.lookup(InterfaceServidor.NOME);

		} catch (Exception e) {
			System.out.println("\n\n-------------------------------------------------------\n"
					+ "ERRO: VERIFIQUE SE O SERVIDOR ESTÃO RODANDO, SE O IP E PORTA ESTÃO"
					+ " CORRETOS, SE NÃO HÁ BLOQUEIO DE FIREWALL OU ANTIVIRUS.\n"
					+ "-------------------------------------------------------------------\n\n");

		}
	}

	public void receberContatosOnline(List<EntidadeUsuario> lista) throws RemoteException {
		List<EntidadeUsuario> listaOnline = new ArrayList<>();
		
		lista.forEach(e -> {
			if(e.getStatus().equals(Status.ONLINE)){
				listaOnline.add(e);
			}
		});
		
		TableModel tb = new MeuModelo(listaOnline);
		tableContatos.setModel(tb);

	}

	public void receberListaParticipantes(ArrayList<EntidadeUsuario> lista) throws RemoteException {
		//???????????????????
	}

	public void receberMensagem(EntidadeUsuario remetente, String mensagem) throws RemoteException {
		int totaltabs = tabbedConversas.getTabCount();
		boolean ativo = false;
		if (totaltabs != 0) {
			for (int i = 0; i < totaltabs; i++) {
				String titulo = tabbedConversas.getTitleAt(i);
				if (titulo.equalsIgnoreCase(remetente.getNome())) {
					ativo = true;
					Conversa conversa = (Conversa) tabbedConversas.getComponentAt(i);
					conversa.mostrar(remetente, mensagem);
					tabbedConversas.setSelectedIndex(i);
				}
			}
		}

		if (!ativo) {
			
			Conversa conversa = new Conversa();
			tabbedConversas.add(remetente.getNome(), conversa);
			conversa.mostrar(remetente,mensagem);
			
		}
	}

	@Override
	public void receberArquivo(EntidadeUsuario remetente, Arquivo arquivo) throws RemoteException {
		new FileTransfer(remetente, arquivo);
	}
}