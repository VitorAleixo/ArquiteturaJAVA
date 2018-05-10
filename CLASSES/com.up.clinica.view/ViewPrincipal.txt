package com.up.clinica.view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.dao.EspecieDAO;
import com.up.clinicavet.dao.Tipo_AnimalDAO;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Especie;
import com.up.clinicavet.model.Tipo_Animal;

public class ViewPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	//TELA PRINCIPAL
	private JButton btnAnimais = new JButton ("Animais");
	private JButton btnEspecies = new JButton("Especies");
	private JButton btnTipoAnimal = new JButton("Tipo_Animal");
	private JLabel lblInicio = new JLabel("Clinica Veterinária - UP");
	private JPanel conteudoMenuPrincipal;
	//TELA ANIMAIS
	private JButton btnVoltar = new JButton("Voltar");
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnExcluir = new JButton("Excluir");
	private JLabel lblAnimais = new JLabel("Lista de Animais");
	private JPanel conteudoManutencaoAnimais;
	private ExibicaoAnimais modeloExibicaoAnimaisTabela;
	private JTable tabelaAnimais;
	//TELA CADASTRO ANIMAIS
	public static JTextField txtNome = new JTextField(8);
	public static JTextField txtNascimento= new JTextField(8);
	private List<String> Especie = null;
	public static JComboBox cmbEspecie = new JComboBox();
	private JLabel lblNome = new JLabel("Nome:");
	private JLabel lblNascimento = new JLabel("Nascimento:");
	private JLabel lblEspecieID = new JLabel("Especie:");
	private JButton btnCadastrarAcao = new JButton("Cadastrar");
	private JButton btnVoltarAnimal = new JButton("Voltar");
	private JPanel conteudoCadastroAnimais;
	//TELA CADASTRO TIPO_ANIMAL
	public static JTextField txtAcronimoTipoAnimal = new JTextField(8);
	public static JTextField txtNomeTipoAnimal = new JTextField(8);
	public static JTextField txtDescricaoTipoAnimal = new JTextField(8);
	private JLabel lblAcronimoTipoAnimal = new JLabel("Acronimo:");
	private JLabel lblNomeTipoAnimal = new JLabel("Nome:");
	private JLabel lblDescricaoTipoAnimal = new JLabel("Descricao:");
	private JButton btnCadastrarTipoAnimalAcao = new JButton("Cadastrar");
	private JButton btnVoltarTipoAnimal = new JButton("Voltar");
	private JPanel conteudoCadastroTipoAnimal = new JPanel();
	//TELA CADASTRO ESPECIE
	public static JTextField txtNomeEspecie = new JTextField(8);
	public static JTextField txtDescricaoEspecie = new JTextField(8);
	private List<String> TipoAnimal = null;
	public static JComboBox cmbTipoAnimal = new JComboBox();
	private JLabel lblNomeEspecie = new JLabel("Nome:");
	private JLabel lblDescricaoEspecie = new JLabel("Descricao:");
	private JLabel lblAcronimoEspecie = new JLabel("Acronimo:");
	private JButton btnCadastrarEspecieAcao = new JButton("Cadastrar");
	private JButton btnVoltarEspecieAnimal = new JButton("Voltar");
	private JLabel lblEspecie = new JLabel("Lista de Especies");
	private Tipo_AnimalDAO tip = new Tipo_AnimalDAO();
	private JPanel conteudoCadastroEspecie = new JPanel();
	//TELA EXCLUSAO ANIMAIS
	private JLabel lblNomeAnimal = new JLabel("ID:");
	private JButton btnExcluirAnimal = new JButton("Excluir");
	private JButton btnAnimalVoltarExcluir = new JButton("Voltar");
	public static JTextField txtExcluirAnimal = new JTextField(11);
	private JPanel conteudoExcluirAnimais;
	private EspecieDAO esp = new EspecieDAO();
	//TELA ESPECIE
	private JButton btnVoltarEspecie = new JButton("Voltar");
	private JButton btnCadastrarEspecie = new JButton("Cadastrar");
	private JButton btnExcluirEspecie = new JButton("Excluir");
	private JPanel conteudoEspecie;
	private ExibicaoEspecie modeloExibicaoEspecieTabela;
	private JTable tabelaEspecie;
	//TELA TIPO_ANIMAL
	private JButton btnVoltarTipo = new JButton("Voltar");
	private JButton btnCadastrarTipo= new JButton("Cadastrar");
	private JButton btnExcluirTipo = new JButton("Excluir");
	private JLabel lblTipo = new JLabel("Lista de Tipos de Animais");
	private JPanel conteudoTipo;
	private ExibicaoTipo modeloExibicaoTipoTabela;
	private JTable tabelaTipo;
	//TELA EXCLUIR TIPO
	private JLabel lblNomeTipo = new JLabel("Acronimo:");
	private JButton btnExcluirTipoAnimal = new JButton("Excluir");
	private JButton btnTipoVoltarExcluir = new JButton("Voltar");
	private JPanel conteudoExcluirTipoAnimal;
	public static JTextField txtExcluirTipo = new JTextField(9);
	//TELA EXCLUIR ESPECIE
	private JLabel lblNomeEspecieEX = new JLabel("ID:");
	private JButton btnExcluirEspecieEX = new JButton("Excluir");
	private JButton btnEspecieVoltarExcluirEX = new JButton("Voltar");
	private JPanel conteudoExcluirEspecieEX;
	public static JTextField txtExcluirEspecieEX = new JTextField(11);
	
	public ViewPrincipal() throws Exception 
	{
		//MENU PRINCIPAL
		conteudoMenuPrincipal = new JPanel();
		SpringLayout layout = new SpringLayout();
		conteudoMenuPrincipal.setLayout(layout);
		conteudoMenuPrincipal.add(btnAnimais);
		conteudoMenuPrincipal.add(btnEspecies);
		conteudoMenuPrincipal.add(btnTipoAnimal);
		conteudoMenuPrincipal.add(lblInicio);
		lblInicio.setForeground(new Color(255,0,0));
		
		layout.putConstraint(SpringLayout.NORTH, lblInicio, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.EAST, lblInicio, 230, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.WEST, btnAnimais, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnAnimais, 65, SpringLayout.NORTH, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.EAST, btnEspecies, 200, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnEspecies, 65, SpringLayout.NORTH, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.EAST, btnTipoAnimal, 325, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnTipoAnimal, 65, SpringLayout.NORTH, conteudoMenuPrincipal);
		this.setTitle("Clínica Veterinária UP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.exibirTelaInicial();
		
		//EXIBICAO ANIMAIS
		modeloExibicaoAnimaisTabela = new ExibicaoAnimais();
		tabelaAnimais = new JTable(modeloExibicaoAnimaisTabela);
		conteudoManutencaoAnimais = new JPanel();
		SpringLayout layoutManutencaoAnimais = new SpringLayout();
		conteudoManutencaoAnimais.setLayout(layoutManutencaoAnimais);
		conteudoManutencaoAnimais.add(tabelaAnimais);
		conteudoManutencaoAnimais.add(btnVoltar);
		conteudoManutencaoAnimais.add(btnCadastrar);
		conteudoManutencaoAnimais.add(btnExcluir);
		conteudoManutencaoAnimais.add(lblAnimais);
		lblAnimais.setForeground(new Color(100,150,0));
		layoutManutencaoAnimais.putConstraint(SpringLayout.EAST, lblAnimais, 240, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, lblAnimais,20, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, tabelaAnimais, 40, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, tabelaAnimais, 50, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, btnVoltar, 5, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.SOUTH, btnVoltar, 350, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.EAST, btnCadastrar, 380, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.SOUTH, btnCadastrar, 350, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.EAST, btnExcluir, 280, SpringLayout.WEST,conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.SOUTH, btnExcluir, 350, SpringLayout.WEST,conteudoManutencaoAnimais);
		
		//CADASTRO ANIMAIS
		cmbEspecie.setPreferredSize(new Dimension(92,20));
		conteudoCadastroAnimais = new JPanel();
		SpringLayout layoutCadastro = new SpringLayout();
		conteudoCadastroAnimais.setLayout(layoutCadastro);
		conteudoCadastroAnimais.add(txtNome);
		conteudoCadastroAnimais.add(txtNascimento);
		conteudoCadastroAnimais.add(cmbEspecie);
		conteudoCadastroAnimais.add(lblNome);
		conteudoCadastroAnimais.add(lblNascimento);
		conteudoCadastroAnimais.add(lblEspecieID);
		conteudoCadastroAnimais.add(btnCadastrarAcao);
		conteudoCadastroAnimais.add(btnVoltarAnimal);
		Especie = esp.NomeLista();
		for(String especie : Especie) {
			cmbEspecie.addItem(especie);
		}
		layoutCadastro.putConstraint(SpringLayout.EAST, txtNome, 200, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.SOUTH, lblEspecieID, 80, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.EAST, txtNascimento, 200, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.SOUTH, txtNascimento, 50, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.SOUTH, lblNascimento, 48, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.EAST, cmbEspecie, 200, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.SOUTH, cmbEspecie, 80, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.SOUTH, btnCadastrarAcao, 110, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.EAST, btnCadastrarAcao, 200, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutCadastro.putConstraint(SpringLayout.SOUTH, btnVoltarAnimal, 110, SpringLayout.WEST, conteudoCadastroAnimais);
		
		//EXCLUIR ANIMAIS
		conteudoExcluirAnimais = new JPanel();
		SpringLayout layoutExcluir = new SpringLayout();
		conteudoExcluirAnimais.setLayout(layoutExcluir);
		conteudoExcluirAnimais.add(lblNomeAnimal);
		conteudoExcluirAnimais.add(btnExcluirAnimal);
		conteudoExcluirAnimais.add(btnAnimalVoltarExcluir);
		conteudoExcluirAnimais.add(txtExcluirAnimal);
		layoutExcluir.putConstraint(SpringLayout.WEST, lblNomeAnimal, 0, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutExcluir.putConstraint(SpringLayout.EAST, txtExcluirAnimal, 180, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutExcluir.putConstraint(SpringLayout.SOUTH, btnExcluirAnimal, 95, SpringLayout.EAST, conteudoCadastroAnimais);
		layoutExcluir.putConstraint(SpringLayout.EAST, btnExcluirAnimal, 180, SpringLayout.EAST, conteudoCadastroAnimais);
		layoutExcluir.putConstraint(SpringLayout.SOUTH, btnAnimalVoltarExcluir, 95, SpringLayout.WEST, conteudoCadastroAnimais);
		layoutExcluir.putConstraint(SpringLayout.EAST, btnAnimalVoltarExcluir, 73, SpringLayout.WEST, conteudoCadastroAnimais);
		
		//EXIBICAO ESPECIE
		conteudoEspecie = new JPanel();
		modeloExibicaoEspecieTabela = new ExibicaoEspecie();
		tabelaEspecie = new JTable(modeloExibicaoEspecieTabela);
		SpringLayout layoutEspecie = new SpringLayout();
		conteudoEspecie.setLayout(layoutEspecie);
		conteudoEspecie.add(btnCadastrarEspecie);
		conteudoEspecie.add(btnExcluirEspecie);
		conteudoEspecie.add(btnVoltarEspecie);
		conteudoEspecie.add(tabelaEspecie);
		conteudoEspecie.add(lblEspecie);
		lblEspecie.setForeground(new Color(100,150,0));
		layoutEspecie.putConstraint(SpringLayout.EAST, lblEspecie, 240, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.NORTH, lblEspecie, 20, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.WEST, tabelaEspecie, 40, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.NORTH, tabelaEspecie, 50, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.WEST, btnVoltarEspecie, 5, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.SOUTH, btnVoltarEspecie, 350, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.EAST, btnCadastrarEspecie, 380, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.SOUTH, btnCadastrarEspecie, 350, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.EAST, btnExcluirEspecie, 280, SpringLayout.WEST,conteudoEspecie);
		layoutEspecie.putConstraint(SpringLayout.SOUTH, btnExcluirEspecie, 350, SpringLayout.WEST,conteudoEspecie);
		
		//EXIBICAO TIPO_ANIMAL
		conteudoTipo = new JPanel();
		modeloExibicaoTipoTabela = new ExibicaoTipo();
		tabelaTipo = new JTable(modeloExibicaoTipoTabela);
		SpringLayout layoutTipo = new SpringLayout();
		conteudoTipo.setLayout(layoutTipo);
		conteudoTipo.add(btnCadastrarTipo);
		conteudoTipo.add(btnExcluirTipo);
		conteudoTipo.add(btnVoltarTipo);
		conteudoTipo.add(tabelaTipo);
		conteudoTipo.add(lblTipo);
		lblTipo.setForeground(new Color(100,150,0));
		layoutTipo.putConstraint(SpringLayout.EAST, lblTipo, 270, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.NORTH, lblTipo, 20, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.EAST, tabelaTipo, 310, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.NORTH, tabelaTipo, 50, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.WEST, btnVoltarTipo, 5, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.SOUTH, btnVoltarTipo, 350, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.EAST, btnCadastrarTipo, 380, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.SOUTH, btnCadastrarTipo, 350, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.EAST, btnExcluirTipo, 280, SpringLayout.WEST,conteudoTipo);
		layoutTipo.putConstraint(SpringLayout.SOUTH, btnExcluirTipo, 350, SpringLayout.WEST,conteudoTipo);
		
		//EXCLUIR TIPO ANIMAL
		conteudoExcluirTipoAnimal = new JPanel();
		SpringLayout layoutExcluirTipoAnimal = new SpringLayout();
		conteudoExcluirTipoAnimal.setLayout(layoutExcluirTipoAnimal);
		conteudoExcluirTipoAnimal.add(lblNomeTipo);
		conteudoExcluirTipoAnimal.add(btnExcluirTipoAnimal);
		conteudoExcluirTipoAnimal.add(btnTipoVoltarExcluir);
		conteudoExcluirTipoAnimal.add(txtExcluirTipo);
		layoutExcluirTipoAnimal.putConstraint(SpringLayout.WEST, lblNomeTipo, 0, SpringLayout.WEST, conteudoExcluirTipoAnimal);
		layoutExcluirTipoAnimal.putConstraint(SpringLayout.EAST, txtExcluirTipo, 180, SpringLayout.WEST, conteudoExcluirTipoAnimal);
		layoutExcluirTipoAnimal.putConstraint(SpringLayout.EAST, btnExcluirTipoAnimal, 180, SpringLayout.WEST, conteudoExcluirTipoAnimal);
		layoutExcluirTipoAnimal.putConstraint(SpringLayout.SOUTH, btnExcluirTipoAnimal, 95, SpringLayout.WEST, conteudoExcluirTipoAnimal);
		layoutExcluirTipoAnimal.putConstraint(SpringLayout.SOUTH, btnTipoVoltarExcluir, 95, SpringLayout.WEST, conteudoExcluirTipoAnimal);
		layoutExcluirTipoAnimal.putConstraint(SpringLayout.EAST, btnTipoVoltarExcluir, 75, SpringLayout.WEST, conteudoExcluirTipoAnimal);
		
		//CADASTRO ESPECIE
		conteudoCadastroEspecie = new JPanel();
		SpringLayout layoutCadastroEspecie = new SpringLayout();
		conteudoCadastroEspecie.setLayout(layoutCadastroEspecie);
		conteudoCadastroEspecie.add(txtNomeEspecie);
		conteudoCadastroEspecie.add(txtDescricaoEspecie);
		conteudoCadastroEspecie.add(cmbTipoAnimal);
		conteudoCadastroEspecie.add(lblNomeEspecie);
		conteudoCadastroEspecie.add(lblDescricaoEspecie);
		conteudoCadastroEspecie.add(lblAcronimoEspecie); //
		conteudoCadastroEspecie.add(btnCadastrarEspecieAcao);
		conteudoCadastroEspecie.add(btnVoltarEspecieAnimal);
		TipoAnimal = tip.NomeLista();
		for(String tipo : TipoAnimal) {
			cmbTipoAnimal.addItem(tipo);
		}
		layoutCadastroEspecie.putConstraint(SpringLayout.EAST, txtNomeEspecie, 200, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.SOUTH, lblDescricaoEspecie, 80, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.SOUTH, lblAcronimoEspecie, 75, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.EAST, txtDescricaoEspecie, 200, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.SOUTH, txtDescricaoEspecie, 50, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.SOUTH, lblDescricaoEspecie, 48, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.EAST, cmbTipoAnimal, 200, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.SOUTH, cmbTipoAnimal, 80, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.SOUTH, btnCadastrarEspecieAcao, 110, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.EAST, btnCadastrarEspecieAcao, 200, SpringLayout.WEST, conteudoCadastroEspecie);
		layoutCadastroEspecie.putConstraint(SpringLayout.SOUTH, btnVoltarEspecieAnimal, 110, SpringLayout.WEST, conteudoCadastroEspecie);
		
		//CADASTRO TIPO_ANIMAL
		conteudoCadastroTipoAnimal = new JPanel();
		SpringLayout layoutCadastroTipoAnimal = new SpringLayout();
		conteudoCadastroTipoAnimal.setLayout(layoutCadastroTipoAnimal);
		conteudoCadastroTipoAnimal.add(txtAcronimoTipoAnimal);
		conteudoCadastroTipoAnimal.add(txtNomeTipoAnimal);
		conteudoCadastroTipoAnimal.add(txtDescricaoTipoAnimal);
		conteudoCadastroTipoAnimal.add(lblAcronimoTipoAnimal);
		conteudoCadastroTipoAnimal.add(lblNomeTipoAnimal);
		conteudoCadastroTipoAnimal.add(lblDescricaoTipoAnimal); //
		conteudoCadastroTipoAnimal.add(btnCadastrarTipoAnimalAcao);
		conteudoCadastroTipoAnimal.add(btnVoltarTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.EAST, txtAcronimoTipoAnimal, 200, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.SOUTH, lblNomeTipoAnimal, 75, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.SOUTH, lblAcronimoEspecie, 75, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.EAST, txtNomeTipoAnimal, 200, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.SOUTH, txtNomeTipoAnimal, 80, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.EAST, txtDescricaoTipoAnimal, 200, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.SOUTH, txtDescricaoTipoAnimal, 48, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.SOUTH, lblDescricaoTipoAnimal, 48, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.SOUTH, btnCadastrarTipoAnimalAcao, 110, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.EAST, btnCadastrarTipoAnimalAcao, 200, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		layoutCadastroTipoAnimal.putConstraint(SpringLayout.SOUTH, btnVoltarTipoAnimal, 110, SpringLayout.WEST, conteudoCadastroTipoAnimal);
		
		//EXCLUIR ESPECIE
		conteudoExcluirEspecieEX = new JPanel(); 
		SpringLayout layoutExcluirEspecieEX = new SpringLayout();
		conteudoExcluirEspecieEX.setLayout(layoutExcluirEspecieEX);
		conteudoExcluirEspecieEX.add(lblNomeEspecieEX);	
		conteudoExcluirEspecieEX.add(btnExcluirEspecieEX);	
		conteudoExcluirEspecieEX.add(btnEspecieVoltarExcluirEX);
		conteudoExcluirEspecieEX.add(txtExcluirEspecieEX);
		layoutExcluirEspecieEX.putConstraint(SpringLayout.EAST, txtExcluirEspecieEX, 180, SpringLayout.WEST, conteudoExcluirEspecieEX);
		layoutExcluirEspecieEX.putConstraint(SpringLayout.WEST, lblNomeEspecieEX, 0,SpringLayout.WEST, conteudoExcluirEspecieEX);
		layoutExcluirEspecieEX.putConstraint(SpringLayout.EAST, btnExcluirEspecieEX, 180, SpringLayout.WEST, conteudoExcluirEspecieEX);
		layoutExcluirEspecieEX.putConstraint(SpringLayout.SOUTH, btnExcluirEspecieEX, 95, SpringLayout.WEST, conteudoExcluirEspecieEX);
		layoutExcluirEspecieEX.putConstraint(SpringLayout.SOUTH, btnEspecieVoltarExcluirEX, 95, SpringLayout.WEST, conteudoExcluirEspecieEX);
		layoutExcluirEspecieEX.putConstraint(SpringLayout.EAST, btnEspecieVoltarExcluirEX, 75, SpringLayout.WEST, conteudoExcluirEspecieEX);
		
		
	}
	
	public void exibirTelaInicial() 
	{
		this.setPreferredSize(new Dimension(350,140));
		
		this.setContentPane(conteudoMenuPrincipal);
		this.pack();
		
	}
	
	public void exibirTelaExcluirAnimal() 
	{
		this.setPreferredSize(new Dimension(200,140));
		
		this.setContentPane(conteudoExcluirAnimais);
		this.pack();
		
	}
	
	public void exibirTelaExcluirTipo() 
	{
		this.setPreferredSize(new Dimension(200,140));
		
		this.setContentPane(conteudoExcluirTipoAnimal);
		this.pack();
		
	}
	
	public void exibirTelaExcluirEspecie() 
	{
		this.setPreferredSize(new Dimension(200,140));
		
		this.setContentPane(conteudoExcluirEspecieEX);
		this.pack();
		
	}
	
	public void exibirTelaCadastroAnimais() 
	{
		this.setPreferredSize(new Dimension(225,150));
		
		this.setContentPane(conteudoCadastroAnimais);
		this.pack();
		
	}
	
	public void exibirTelaCadastroTipo() 
	{
		this.setPreferredSize(new Dimension(225,150));
		
		this.setContentPane(conteudoCadastroTipoAnimal);
		this.pack();
		
	}
	
	public void exibirTelaCadastroEspecies() 
	{
		this.setPreferredSize(new Dimension(225,150));
		
		this.setContentPane(conteudoCadastroEspecie);
		this.pack();
		
	}
	
	public void showError(String errMessage)
	{
		JOptionPane.showMessageDialog(this, errMessage);
	}
	
	//2 ADICIONE UM LISTENER ANTES DE FAZER O BOTAO FUNCIONAR NESTA CLASSE
	public void addBtnAnimaisListener(ActionListener animaisListener)
	{
		btnAnimais.addActionListener(animaisListener);
	}
	
	public void addBtnEspecieListener(ActionListener especieListener)
	{
		btnEspecies.addActionListener(especieListener);
	}
	
	public void addBtnTipoListener(ActionListener tipoListener)
	{
		btnTipoAnimal.addActionListener(tipoListener);
	}
	
	public void addBtnVoltarTipo(ActionListener tipoVoltarListener)
	{
		btnVoltarTipo.addActionListener(tipoVoltarListener);
	}
	
	public void addBtnVoltarTipoAnimal(ActionListener tipoanimalVoltarListener)
	{
		btnVoltarTipoAnimal.addActionListener(tipoanimalVoltarListener);
	}
	
	public void addBtnEspecieVoltarExcluirEX(ActionListener especieVoltarListener)
	{
		btnEspecieVoltarExcluirEX.addActionListener(especieVoltarListener);
	}
	
	public void addBtnTipoVoltarExcluir(ActionListener tipoVoltarListener)
	{
		btnTipoVoltarExcluir.addActionListener(tipoVoltarListener);
	}
	
	public void addBtnVoltarEspecie(ActionListener especieVoltarListener)
	{
		btnVoltarEspecie.addActionListener(especieVoltarListener);
	}
	
	public void addBtnCadastroAnimaisListener(ActionListener animaisCadastroListener)
	{
		btnCadastrar.addActionListener(animaisCadastroListener);
	}
	
	public void addBtnCadastroEspeciesListener(ActionListener especieCadastroListener)
	{
		btnCadastrarEspecie.addActionListener(especieCadastroListener);
	}
	
	public void addBtnCadastroTipoAnimalListener(ActionListener tipoanimalCadastroListener)
	{
		btnCadastrarTipo.addActionListener(tipoanimalCadastroListener);
	}
	
	public void addBtnExcluirAnimal(ActionListener excluirAnimalListener)
	{
		btnExcluir.addActionListener(excluirAnimalListener);
	}
	
	public void addBtnExcluirEspecieDelete(ActionListener excluirEspecieDeleteListener)
	{
		btnExcluirEspecieEX.addActionListener(excluirEspecieDeleteListener);
	}
	
	public void addBtnExcluirTipoDelete(ActionListener excluirTipoDeleteListener)
	{
		btnExcluirTipoAnimal.addActionListener(excluirTipoDeleteListener);
	}
	
	public void addBtnVoltarEspecieCadastro(ActionListener voltarAnimalCadastroListener)
	{
		btnVoltarEspecieAnimal.addActionListener(voltarAnimalCadastroListener);
	}
	
	public void addBtnExcluirEspecie(ActionListener excluirEspecieListener)
	{
		btnExcluirEspecie.addActionListener(excluirEspecieListener);
	}
	
	public void addBtnExcluirTipo(ActionListener excluirTipoListener)
	{
		btnExcluirTipo.addActionListener(excluirTipoListener);
	}

	
	//3 ADICIONE A TELA QUE IRÁ SER EXIBIDA
	public void exibirTelaAnimais(List<Animal> animaisParaExibir)
	{
		modeloExibicaoAnimaisTabela.setAnimaisTabela(animaisParaExibir);

		//dimensão da tela
		this.setPreferredSize(new Dimension(400,400));
		//seta o painel
		this.setContentPane(conteudoManutencaoAnimais);
		//empacotando tudo para renderizar
		this.pack();
		
	}
	
	public void exibirTelaTipo(List<Tipo_Animal> tipoParaExibir)
	{
		modeloExibicaoTipoTabela.setTipoTabela(tipoParaExibir);

		//dimensão da tela
		this.setPreferredSize(new Dimension(400,400));
		//seta o painel
		this.setContentPane(conteudoTipo);
		//empacotando tudo para renderizar
		this.pack();
		
	}
	
	public void exibirTelaEspecie(List<Especie> especieParaExibir)
	{
		modeloExibicaoEspecieTabela.setEspecieTabela(especieParaExibir);

		//dimensão da tela
		this.setPreferredSize(new Dimension(400,400));
		//seta o painel
		this.setContentPane(conteudoEspecie);
		//empacotando tudo para renderizar
		this.pack();
		
	}
	public void addBtnVoltarListener(ActionListener voltarListener)
	{
		btnVoltar.addActionListener(voltarListener);
	}
	
	public void addBtnAnimalVoltarExcluirListener(ActionListener voltarListener)
	{
		btnAnimalVoltarExcluir.addActionListener(voltarListener);
	}
	
	public void addBtnVoltarAnimalListener(ActionListener voltarAnimalListener)
	{
		btnVoltarAnimal.addActionListener(voltarAnimalListener);
	}
	
	public void addBtnExcluirAnimalAcao(ActionListener excluirAnimalListener)
	{
		btnExcluirAnimal.addActionListener(excluirAnimalListener);
	}
	
	
	public void addBtnCadastrarAnimais(ActionListener cadastrarAnimalListener)
	{

		btnCadastrarAcao.addActionListener(cadastrarAnimalListener);
	}
	
	public void addBtnCadastrarEspecie(ActionListener cadastrarEspecieListener)
	{

		btnCadastrarEspecieAcao.addActionListener(cadastrarEspecieListener);
	}
	
	public void addBtnCadastrarTipo(ActionListener cadastrarTipoListener)
	{

		btnCadastrarTipoAnimalAcao.addActionListener(cadastrarTipoListener);
	}
	
}
