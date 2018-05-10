package com.up.clinica.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Especie;

public class ExibicaoEspecie extends AbstractTableModel
{
	//NUMERO DE COLUNAS QUE A TABELA IRÁ TER
	private static final int NUM_COLUNAS_ESPECIE = 4;
	
	//SETA A LISTA
	private List<Especie> especieTabela;

	public ExibicaoEspecie(){}

	public ExibicaoEspecie(List<Especie> especie)
	{
		especieTabela = especie;
	}
					
	public void setEspecieTabela(List<Especie> especieTabela)
	{
		this.especieTabela = especieTabela;
	}
					
	//PEGA O NOME DAS COLUNAS
	@Override
	public String getColumnName(int coluna)
	{	
		switch(coluna)
			{
			case 0:
				return "Identificador";
			case 1:
				return "Nome";
			case 2:
				return "Descricao";
			case 3:
				return "Tipo_Animal_Acronimo";
			default:
				throw new RuntimeException("Solicitada uma coluna no JTable que não existe!");
		}
	}
	
	//PEGA A QUANTIDADE DE COLUNAS DA TABELA
	@Override
	public int getColumnCount()
	{
		return NUM_COLUNAS_ESPECIE;
	}
	
	//PEGA A QUANTIDADE DE LINHAS DA TABELA
	@Override
	public int getRowCount()
	{
		if(especieTabela != null)
		{
			return especieTabela.size();
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
			return especieTabela.get(linha).getID();
		case 1:
			return especieTabela.get(linha).getNome();
		case 2:
			return especieTabela.get(linha).getDescricao();
		case 3:
			return especieTabela.get(linha).getTipoAnimal().getAcronimo();
		default:
			throw new RuntimeException("Coluna inválida");
		}
	}
}
