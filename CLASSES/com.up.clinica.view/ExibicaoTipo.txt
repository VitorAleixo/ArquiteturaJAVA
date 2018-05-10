package com.up.clinica.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.up.clinicavet.model.Tipo_Animal;

public class ExibicaoTipo extends AbstractTableModel
{
	//NUMERO DE COLUNAS QUE A TABELA IRÁ TER
	private static final int NUM_COLUNAS_TIPO = 3;
	
	//SETA A LISTA
	private List<Tipo_Animal> tipoTabela;

	public ExibicaoTipo(){}

	public ExibicaoTipo(List<Tipo_Animal> tipo)
	{
		tipoTabela = tipo;
	}
					
	public void setTipoTabela(List<Tipo_Animal> tipoTabela)
	{
		this.tipoTabela= tipoTabela;
	}
					
	//PEGA O NOME DAS COLUNAS
	@Override
	public String getColumnName(int coluna)
	{	
		switch(coluna)
			{
			case 0:
				return "Acronimo";
			case 1:
				return "Nome";
			case 2:
				return "Descricao";
			default:
				throw new RuntimeException("Solicitada uma coluna no JTable que não existe!");
		}
	}
	
	//PEGA A QUANTIDADE DE COLUNAS DA TABELA
	@Override
	public int getColumnCount()
	{
		return NUM_COLUNAS_TIPO;
	}
	
	//PEGA A QUANTIDADE DE LINHAS DA TABELA
	@Override
	public int getRowCount()
	{
		if(tipoTabela!= null)
		{
			return tipoTabela.size();
		}
		else
		{
			return 0;
		}
	}
	@Override
	public Object getValueAt(int linha, int coluna)
	{
		switch(coluna)
		{
		case 0:
			return tipoTabela.get(linha).getAcronimo();
		case 1:
			return tipoTabela.get(linha).getNome();
		case 2:
			return tipoTabela.get(linha).getDescricao();
		default:
			throw new RuntimeException("Coluna inválida");
		}
	}
}
