package com.up.clinica.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.up.clinicavet.model.Animal;

public class ExibicaoAnimais extends AbstractTableModel
{
	//NUMERO DE COLUNAS QUE A TABELA IRÁ TER
	private static final int NUM_COLUNAS_ANIMAL = 4;
	
	//SETA A LISTA
	private List<Animal> animaisTabela;

	public ExibicaoAnimais(){}

	public ExibicaoAnimais(List<Animal> animais)
	{
		animaisTabela = animais;
	}
					
	public void setAnimaisTabela(List<Animal> animaisTabela)
	{
		this.animaisTabela = animaisTabela;
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
				return "Nascimento";
			case 3:
				return "Tipo_Animal";
			default:
				throw new RuntimeException("Solicitada uma coluna no JTable que não existe!");
		}
	}
	
	//PEGA A QUANTIDADE DE COLUNAS DA TABELA
	@Override
	public int getColumnCount()
	{
		return NUM_COLUNAS_ANIMAL;
	}
	
	//PEGA A QUANTIDADE DE LINHAS DA TABELA
	@Override
	public int getRowCount()
	{
		if(animaisTabela != null)
		{
			return animaisTabela.size();
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
			return animaisTabela.get(linha).getID();
		case 1:
			return animaisTabela.get(linha).getNome();
		case 2:
			return animaisTabela.get(linha).getNascimento();
		case 3:
			return animaisTabela.get(linha).getEspecie().getNome();
		default:
			throw new RuntimeException("Coluna inválida");
		}
	}
}
