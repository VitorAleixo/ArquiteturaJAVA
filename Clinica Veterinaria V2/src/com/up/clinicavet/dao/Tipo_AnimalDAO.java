package com.up.clinicavet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Especie;
import com.up.clinicavet.model.Tipo_Animal;

public class Tipo_AnimalDAO implements IGenericDAO<Tipo_Animal, Long> {
	Connection con = null;
	PreparedStatement statement = null;
	List<Tipo_Animal> lista = null;
	List<String> nomeAcronimo = new ArrayList<>();
	@Override
	public boolean salvar(Tipo_Animal obj) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		boolean verificacao = false;
		ResultSet rs = null;
		try 
		{
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT ACRONIMO FROM TIPO_ANIMAL WHERE ACRONIMO = ?");
			statement.setString(1, obj.getAcronimo());
			rs = statement.executeQuery();
			String acronimo = "";
			while(rs.next())
			{
				acronimo = (rs.getString(1));
			}
			statement = con.prepareStatement("SELECT NOME FROM TIPO_ANIMAL WHERE NOME = ?");
			statement.setString(1, obj.getNome());
			rs = statement.executeQuery();
			String nome = "";
			while(rs.next())
			{
				nome = (rs.getString(1));
			}
			if (acronimo.isEmpty() && nome.isEmpty())
			{
			statement = con.prepareStatement("INSERT INTO TIPO_ANIMAL (ACRONIMO,NOME,DESCRICAO) VALUES (?,?,?);");
			statement.setString(1, obj.getAcronimo());
			statement.setString(2, obj.getNome());
			statement.setString(3,obj.getDescricao());
			statement.executeUpdate();
			verificacao = true;
			}
			else
			{
				acronimo = "";
				verificacao = false;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con != null) 
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if(rs != null) 
				{
					rs.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return verificacao;
	
	}

	@Override
	public void atualizar(Tipo_Animal obj) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		
	}

	@Override
	public Tipo_Animal buscar(Long id) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		
		return null;
	}
	
	public Tipo_Animal buscarTipoPorNome(String desc) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		ResultSet rs = null;
		String tipo_animal_acronimo = "";
		Tipo_Animal tipo = null;
		try 
		{
			con = ConnectionFactory.getConnection();
			
			statement = con.prepareStatement("SELECT ACRONIMO FROM TIPO_ANIMAL WHERE ACRONIMO = ?");
			statement.setString(1, desc);

			rs = statement.executeQuery();
			while(rs.next())
			{
				tipo = new Tipo_Animal();
				tipo.setAcronimo(rs.getString(1));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con != null) 
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (rs != null)
				{
					rs.close();
				}
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return tipo;
		}		

	}


	public boolean excluirAcronimo(String acronimo) {
		ResultSet rs = null;
		boolean validacao = false;
		try 
		{
			con = ConnectionFactory.getConnection();
			
			statement = con.prepareStatement("SELECT TIPO_ANIMAL_ACRONIMO FROM ESPECIE WHERE TIPO_ANIMAL_ACRONIMO = ?");
			statement.setString(1, acronimo);
			String tipo_animal_acronimo = "";
			rs = statement.executeQuery();
			while(rs.next())
			{
				tipo_animal_acronimo = rs.getString(1);
			}
			
			if(tipo_animal_acronimo.isEmpty())
			{
				statement = con.prepareStatement("DELETE FROM TIPO_ANIMAL WHERE ACRONIMO = ?");
				statement.setString(1, acronimo);
				
				statement.executeUpdate();
				validacao = true;
			}
			else 
			{
				tipo_animal_acronimo = "";
				
				validacao = false;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con != null) 
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (rs != null)
				{
					rs.close();
				}
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return validacao;
		}		
}
	public List<String> NomeLista() throws Exception {
		Connection con = null;
		nomeAcronimo = new ArrayList<String>();
		PreparedStatement statement = null;
		
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT ACRONIMO FROM TIPO_ANIMAL");
			rs = statement.executeQuery();

			while (rs.next()) {
				String nome = null;
				nome = rs.getString("ACRONIMO");
				nomeAcronimo.add(nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return nomeAcronimo;
	}
	
	@Override
	public List<Tipo_Animal> listar() throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
	    ResultSet rs = null;
	    
		try 
		{
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT ACRONIMO, NOME, DESCRICAO FROM TIPO_ANIMAL;");
			rs = statement.executeQuery();
			lista = new ArrayList<Tipo_Animal>();
			while(rs.next())
			{	
				Tipo_Animal tipo = new Tipo_Animal();
				tipo.setAcronimo(rs.getString(1));
				tipo.setNome(rs.getString(2));
				tipo.setDescricao(rs.getString(3));
				
				lista.add(tipo);
			
			}

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con != null) 
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (rs != null)
				{
					rs.close();
				}
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return lista;
	}

	@Override
	public boolean excluir(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}



