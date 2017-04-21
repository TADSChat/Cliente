package br.univel.ChatRedes.comum;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import common.EntidadeUsuario;

public class UsuarioModelo extends AbstractTableModel implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object[][] matriz;
	private int linha;

	public UsuarioModelo(List<EntidadeUsuario> lista) {

		lista.forEach(e -> {
			matriz[linha][0] = e.getNome();
			matriz[linha][1] = e.getStatus();
			matriz[linha][2] = e;

			linha++;
		});

	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return linha;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return matriz[rowIndex][columnIndex];
	}

	public String getColumnName(int i) {

		switch (i) {
			case 0:
				return "Nome";
			case 1:
				return "Status";
		}

		return null;
	}

}