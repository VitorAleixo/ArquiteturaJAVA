package com.up.clinica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.up.clinica.view.ViewPrincipal;
import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.dao.EspecieDAO;
import com.up.clinicavet.dao.Tipo_AnimalDAO;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Especie;
import com.up.clinicavet.model.Tipo_Animal;

public class PrincipalController 
{
	private ViewPrincipal  view;
	private AnimalDAO animalDAO = new AnimalDAO();
	private EspecieDAO especieDAO = new EspecieDAO();
	private Tipo_AnimalDAO tipoDAO = new Tipo_AnimalDAO();
	JOptionPane optionPane = null;
	JDialog dialog = null;
	//1 PARA FAZER UM BOTÃO FUNCIONAR, COLOCAR O LISTENER DENTRO DO MÉTODO DO CONTROLLER
	public PrincipalController(ViewPrincipal view) throws Exception 
	{
		this.view = view;
		//PRINCIPAL
		this.view.addBtnAnimaisListener(new BtnAnimaisListener());
		this.view.addBtnEspecieListener(new BtnEspecieListener());
		this.view.addBtnTipoListener(new BtnTipoListener());
		//ANIMAIS
		this.view.addBtnCadastroAnimaisListener(new BtnCadastroAnimaisListener());
		this.view.addBtnVoltarListener(new BtnVoltarListener());
		this.view.addBtnVoltarAnimalListener(new BtnVoltarAnimalListener());
		this.view.addBtnCadastrarAnimais(new BtnCadastrarAnimais());
		this.view.addBtnExcluirAnimal(new btnExcluirAnimal());
		this.view.addBtnAnimalVoltarExcluirListener(new BtnVoltarAnimalListener());
		this.view.addBtnExcluirAnimalAcao(new btnExcluirAnimalAcao());
		//TIPOANIMAL
		this.view.addBtnVoltarTipo(new BtnVoltarTipoListener());
		this.view.addBtnExcluirTipo(new btnExcluirTipo());
		this.view.addBtnTipoVoltarExcluir(new btnTipoVoltarExcluir());
		this.view.addBtnCadastroTipoAnimalListener(new btnTipoAnimalCadastrar());
		this.view.addBtnVoltarTipoAnimal(new btnTipoVoltarExcluir());
		this.view.addBtnExcluirTipoDelete(new BtnExcluirTipoDelete());
		this.view.addBtnCadastrarTipo(new BtnCadastrarTipo());
		//ESPECIE
		this.view.addBtnVoltarEspecie(new BtnVoltarEspecieListener());
		this.view.addBtnEspecieVoltarExcluirEX(new btnEspecieVoltarExcluirEX());
		this.view.addBtnCadastroEspeciesListener(new BtnCadastroEspeciesListener());
		this.view.addBtnVoltarEspecieCadastro(new btnEspecieVoltarExcluirEX());
		this.view.addBtnExcluirEspecie(new btnExcluirEspecie());
		this.view.addBtnExcluirEspecieDelete(new BtnExcluirEspecieDelete());
		this.view.addBtnCadastrarEspecie(new BtnCadastrarEspecie());
	}
	//ISTO E UMA CLASSE ANINHADA! UMA CLASSE DENTRO DE OUTRA CLASSE
	
	//2 CRIAR UM LISTENER PARA O BOTÃO
	private class BtnAnimaisListener implements ActionListener 
	{
		 @Override
		 public void actionPerformed(ActionEvent e) 
		 {
			 try 
			 {
				 List<Animal> animais = animalDAO.listar();
				 view.exibirTelaAnimais(animais);
			 }
			 catch(Exception ex)
				{
					optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
					dialog = optionPane.createDialog("Excluir");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
				}
		 
		 }
	}
	private class BtnEspecieListener implements ActionListener 
	{
		 @Override
		 public void actionPerformed(ActionEvent e) 
		 {
			 try 
			 {
				 List<Especie> especie = especieDAO.listar();
				 view.exibirTelaEspecie(especie);
			 }
			 catch(Exception ex)
				{
					optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
					dialog = optionPane.createDialog("Excluir");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
				}
		 
		 }
	}
	
	private class BtnTipoListener implements ActionListener 
	{
		 @Override
		 public void actionPerformed(ActionEvent e) 
		 {
			 try 
			 {
				 List<Tipo_Animal> tipo = tipoDAO.listar();
				 view.exibirTelaTipo(tipo);
			 }
			 catch(Exception ex)
				{
					optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
					dialog = optionPane.createDialog("Excluir");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
				}
		 
		 }
	}
	
	private class BtnVoltarListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//3 CHAMAR A TELA DESEJADA
			
			view.exibirTelaInicial();
		}
	}
	
	private class BtnVoltarEspecieListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			view.exibirTelaInicial();
		}
	}
	
	private class BtnVoltarTipoListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			view.exibirTelaInicial();
		}
	}
	
	private class BtnVoltarAnimalListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			 try 
			 {
				 view.txtNome.setText("");
				 view.txtNascimento.setText("");
				 view.cmbEspecie.setSelectedIndex(0);
				 view.txtExcluirAnimal.setText("");
				 List<Animal> animais = animalDAO.listar();
				 view.exibirTelaAnimais(animais);
			 }
			 catch(Exception ex)
				{
					optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
					dialog = optionPane.createDialog("Excluir");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
				}
		}
	}
	
	private class btnEspecieVoltarExcluirEX implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			 try 
			 {
				 view.txtNomeEspecie.setText("");
				 view.txtDescricaoEspecie.setText("");
				 view.txtExcluirEspecieEX.setText("");
				 view.cmbTipoAnimal.setSelectedIndex(0);
				 List<Especie> especies = especieDAO.listar();
				 view.exibirTelaEspecie(especies);
			 }
			 catch(Exception ex)
				{
					optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
					dialog = optionPane.createDialog("Excluir");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
				}
		}
	}
	
	private class btnTipoVoltarExcluir implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			 try 
			 {
				 view.txtAcronimoTipoAnimal.setText("");
				 view.txtNomeTipoAnimal.setText("");
				 view.txtDescricaoTipoAnimal.setText("");
				 view.txtExcluirTipo.setText("");
				 List<Tipo_Animal> tipo = tipoDAO.listar();
				 view.exibirTelaTipo(tipo);
			 }
			 catch(Exception ex)
				{
					optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
					dialog = optionPane.createDialog("Excluir");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
				}
		}
	}
	
	
	private class BtnCadastroAnimaisListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//3 CHAMAR A TELA DESEJADA
			view.exibirTelaCadastroAnimais();
		}
	}
	
	private class btnTipoAnimalCadastrar implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//3 CHAMAR A TELA DESEJADA
			view.exibirTelaCadastroTipo();
		}
	}
	
	private class BtnCadastroEspeciesListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//3 CHAMAR A TELA DESEJADA
			view.exibirTelaCadastroEspecies();
		}
	}
	
	private class btnExcluirAnimal implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			view.exibirTelaExcluirAnimal();
		}
	}
	
	private class btnExcluirTipo implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			view.exibirTelaExcluirTipo();
		}
	}
	
	private class btnExcluirEspecie implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			view.exibirTelaExcluirEspecie();
		}
	}
	
	private class btnExcluirAnimalAcao implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try {
		AnimalDAO animal2 = new AnimalDAO();
		
		long id = Long.parseLong(ViewPrincipal.txtExcluirAnimal.getText());
		if (animal2.excluir(id) == true)
		{
			view.txtExcluirAnimal.setText("");
			optionPane = new JOptionPane("Animal excluido com sucesso!",JOptionPane.WARNING_MESSAGE);
			dialog = optionPane.createDialog("Excluir");
			dialog.setAlwaysOnTop(true); 
			dialog.setVisible(true);	
			
		}
		else 
		{
			optionPane = new JOptionPane("Animal nao pode ser excluido!",JOptionPane.WARNING_MESSAGE);
			dialog = optionPane.createDialog("Excluir");
			dialog.setAlwaysOnTop(true); 
			dialog.setVisible(true);
		}
			}
			catch(Exception ex)
			{
				optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
		}
	}
	
	private class BtnExcluirEspecieDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try {
		EspecieDAO especie = new EspecieDAO();
		
		long id = Long.parseLong(ViewPrincipal.txtExcluirEspecieEX.getText());
		if (especie.excluir(id)== true)
		{
			 view.txtNomeEspecie.setText("");
			 view.txtDescricaoEspecie.setText("");
			 view.txtExcluirEspecieEX.setText("");
			 view.cmbTipoAnimal.setSelectedIndex(0);
			optionPane = new JOptionPane("Especie excluida com sucesso!",JOptionPane.WARNING_MESSAGE);
			dialog = optionPane.createDialog("Excluir");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true);
		}
		else
		{
			optionPane = new JOptionPane("Especie nao pode ser excluida!",JOptionPane.WARNING_MESSAGE);
			dialog = optionPane.createDialog("Excluir");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true);
		}
			}
			catch(Exception ex)
			{
				optionPane = new JOptionPane("Ocorreu um ERRO!!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
		}
	}
	
	private class BtnExcluirTipoDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try {
		Tipo_AnimalDAO tipo = new Tipo_AnimalDAO();
		
		String nome = ViewPrincipal.txtExcluirTipo.getText();
		if (tipo.excluirAcronimo(nome) == true) 
		{
			view.txtAcronimoTipoAnimal.setText("");
			view.txtNomeTipoAnimal.setText("");
			view.txtDescricaoTipoAnimal.setText("");
			view.txtExcluirTipo.setText("");
			optionPane = new JOptionPane("Tipo_Especie excluida com sucesso!",JOptionPane.WARNING_MESSAGE);
			dialog = optionPane.createDialog("Excluir");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true);
		}
		else 
		{
			optionPane = new JOptionPane("Tipo_Especie nao pode ser excluida!",JOptionPane.WARNING_MESSAGE);
			dialog = optionPane.createDialog("Excluir");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true);
		}
			}
			catch(Exception ex)
			{
				optionPane = new JOptionPane("Ocorreu um ERRO!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
	}
}
	
	private class BtnCadastrarAnimais implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			AnimalDAO animal2 = new AnimalDAO();

			try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date data = new java.sql.Date(format.parse(ViewPrincipal.txtNascimento.getText()).getTime());
			
			Animal obj = new Animal();
			obj.setNome(ViewPrincipal.txtNome.getText());
			
			String desc = ViewPrincipal.cmbEspecie.getSelectedItem().toString();
			obj.setEspecie(especieDAO.buscarEspeciePorNome(desc));
			obj.setNascimento(data); 
			
			
			if (animal2.salvar(obj) == true)
				{
				 view.txtNome.setText("");
				 view.txtNascimento.setText("");
				 view.cmbEspecie.setSelectedIndex(0);
				optionPane = new JOptionPane("Animal salvo com Sucesso!!!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
				}
			else 
			{
				optionPane = new JOptionPane("Nome ja Existente ou DATA incorreta!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
			}
			catch(Exception ex)
			{
				optionPane = new JOptionPane("Ocorreu um ERRO!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Cadastrar");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
		}
	}
	
	private class BtnCadastrarEspecie implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			EspecieDAO especie = new EspecieDAO();

			try {
		
			Especie obj = new Especie();
			obj.setNome(ViewPrincipal.txtNomeEspecie.getText());
			obj.setDescricao(ViewPrincipal.txtDescricaoEspecie.getText());
			String desc = ViewPrincipal.cmbTipoAnimal.getSelectedItem().toString();
			obj.setTipoAnimal(tipoDAO.buscarTipoPorNome(desc));
			
			if (especie.salvar(obj) == true)
				{
				view.txtNomeEspecie.setText("");
				 view.txtDescricaoEspecie.setText("");
				 view.txtExcluirEspecieEX.setText("");
				 view.cmbTipoAnimal.setSelectedIndex(0);
				optionPane = new JOptionPane("Especie salva com Sucesso!!!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
				}
			else 
			{
				optionPane = new JOptionPane("Nome ja Existente!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
			}
			catch(Exception ex)
			{
				optionPane = new JOptionPane("Ocorreu um ERRO!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Cadastrar");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
		}
	}

	private class BtnCadastrarTipo implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Tipo_AnimalDAO tipo = new Tipo_AnimalDAO();

			try {
		
			Tipo_Animal obj = new Tipo_Animal();
			obj.setNome(ViewPrincipal.txtNomeTipoAnimal.getText());
			obj.setDescricao(ViewPrincipal.txtDescricaoTipoAnimal.getText());
			obj.setAcronimo(ViewPrincipal.txtAcronimoTipoAnimal.getText());
			
			if (tipo.salvar(obj) == true)
				{
				view.txtAcronimoTipoAnimal.setText("");
				view.txtNomeTipoAnimal.setText("");
				view.txtDescricaoTipoAnimal.setText("");
				view.txtExcluirTipo.setText("");
				optionPane = new JOptionPane("Tipo Animal salvo com Sucesso!!!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
				}
			else 
			{
				optionPane = new JOptionPane("ACRONIMO ou NOME ja Existente!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Cadastrar");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
			}
			catch(Exception ex)
			{
				optionPane = new JOptionPane("Ocorreu um ERRO!",JOptionPane.WARNING_MESSAGE);
				dialog = optionPane.createDialog("Excluir");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
			}
		}
	}
}
