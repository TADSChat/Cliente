package br.univel.ChatRedes.controller;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.ChatRedes.newview.Login;
import br.univel.ChatRedes.newview.Principal;
import common.Arquivo;
import common.EntidadeServidor;
import common.EntidadeUsuario;
import common.InterfaceServidor;
import common.InterfaceUsuario;
import common.Status;
import common.exceptions.NoServerException;

public class Usuario implements InterfaceUsuario{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InterfaceServidor servidor;
	private InterfaceUsuario interfaceUsuario;
	private Registry registry;
	private EntidadeUsuario usuario;
	private Login login;
	private Principal principal;
	private static InetAddress IP;
	
	public static void main(String[] args){
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Usuario();
	}
	
	public Usuario(){
		login = new Login(this);
		login.setVisible(true);
	}

	@Override
	public void receberMensagem(EntidadeUsuario remetente, String mensagem) throws RemoteException {
		principal.receberMensagem(remetente, mensagem);
	}

	@Override
	public void receberArquivo(EntidadeUsuario remetente, Arquivo arquivo) throws RemoteException {
		if(JOptionPane.showConfirmDialog(principal, "Deseja receber o arquivo " +arquivo.getNome()+"."+arquivo.getExtensao()+"?") == 0){
			servidor.enviarMensagem(usuario, remetente, "O arquivo "+arquivo.getNome()+"."+arquivo.getExtensao()+" foi aceito.");
			File share = new File("share");
			if(!share.exists()){
				share.mkdir();
			}
			if(arquivo.getDados() != null){				
				try {
					String path = "share"+File.separatorChar+arquivo.getNome()+"."+arquivo.getExtensao();
					File file = new File(path);
					
					if(file.exists()){
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						path = "share"+File.separatorChar+ timestamp.getTime() + "_" + arquivo.getNome();
					}
					Files.write(Paths.get(path), arquivo.getDados(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				servidor.enviarMensagem(usuario, remetente, "ERRO: O arquivo "+arquivo.getNome()+"."+arquivo.getExtensao()+" não possui dados.");
				JOptionPane.showMessageDialog(principal, "ERRO: O arquivo "+arquivo.getNome()+"."+arquivo.getExtensao()+" não possui dados.");
			}
			
		}else{
			servidor.enviarMensagem(usuario, remetente, "O arquivo "+arquivo.getNome()+"."+arquivo.getExtensao()+" não foi aceito.");
		}
	}

	@Override
	public void receberListaParticipantes(List<EntidadeUsuario> arrayList) throws RemoteException {
		principal.setUsuarios(arrayList);
	}
	
	public void enviarArquivo(EntidadeUsuario destinatario, Arquivo arquivo) throws NoServerException{
		if(servidor != null){
			try {
				InterfaceUsuario usuarioDestino = servidor.buscarDestinatario(usuario, destinatario);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new NoServerException();
		}
	}
	
	public void receberArquivo() throws NoServerException{
		if(servidor != null){
			
		}else{
			throw new NoServerException();
		}
		
	}
	
	public void enviarMensagem(EntidadeUsuario destinatario, String mensagem) throws NoServerException{
		if(servidor != null){
			try {
				servidor.enviarMensagem(usuario, destinatario, mensagem);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new NoServerException();
		}
	}
	
	public void enviarMensagemPublica(String mensagem) throws NoServerException{
		if(servidor != null){
			try {
				servidor.enviarMensagem(usuario, mensagem);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new NoServerException();
		}
	}
	
	public void conectar(String email, String password, String servidor, int porta){
		try {
			principal = new Principal(Usuario.this);
			if(interfaceUsuario == null){
				interfaceUsuario = (InterfaceUsuario) UnicastRemoteObject.exportObject(this, 0);
			}
			registry = LocateRegistry.createRegistry(1819);
			registry.rebind(InterfaceServidor.NOME, interfaceUsuario);
			
			registry = LocateRegistry.getRegistry(servidor, porta);
			this.servidor = (InterfaceServidor) registry.lookup(InterfaceServidor.NOME);
			usuario = new EntidadeUsuario();
			usuario.setEmail(email);
			usuario.setSenha(password);
			
			Thread.sleep(100);
			
			usuario = this.servidor.conectarChat(usuario, interfaceUsuario);
			if(usuario == null){
				JOptionPane.showMessageDialog(login, "ERRO: Login não efetuado.");
			}else{
				login.setVisible(false);
				principal.updateItens();
				principal.setVisible(true);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void desconectar() throws NoServerException{
		if(servidor != null){
			try {
				servidor.desconectarChat(usuario);
				servidor = null;
				principal.setVisible(false);
				login = new Login(this);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new NoServerException();
		}
	}
	
	public final EntidadeUsuario getEntidadeUsuario(){
		return usuario;
	}
	
	public void setStatus(Status status){
		try {
			usuario.setStatus(status);
			servidor.atualizarStatus(usuario);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
