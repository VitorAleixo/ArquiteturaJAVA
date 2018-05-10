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



public class EspecieDAO implements IGenericDAO<Especie, Long> {
    List<Especie> lista = null;
    List<String> nomeEspecie = new ArrayList<>();
	Connection con = null;
	PreparedStatement statement = null;
	@Override
	public boolean salvar(Especie obj) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		boolean verificacao = false;
		ResultSet rs = null;
		try 
		{
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT NOME FROM ESPECIE WHERE NOME = ?");
			statement.setString(1, obj.getNome());
			rs = statement.executeQuery();
			String nome = "";
			while(rs.next())
			{
				nome = (rs.getString(1));
			}
			if (nome.isEmpty())
			{
			statement = con.prepareStatement("INSERT INTO ESPECIE (NOME,DESCRICAO,TIPO_ANIMAL_ACRONIMO) VALUES (?,?,?);");
			statement.setString(1, obj.getNome());
			statement.setString(2, obj.getDescricao());
			statement.setString(3,obj.getTipoAnimal().getAcronimo());
			statement.executeUpdate();
			verificacao = true;
			}
			else
			{
				nome = "";
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
	public void atualizar(Especie obj) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		
	}

	@Override
	public Especie buscar(Long id) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		
		return null;
	}

	@Override
	public boolean excluir(Long id)
	{
		 ResultSet rs = null;
		 boolean verificacao = false;
		try 
		{
			con = ConnectionFactory.getConnection();
			
			statement = con.prepareStatement("SELECT ESPECIE_ID FROM ANIMAL WHERE ESPECIE_ID = ?");
			statement.setLong(1, id);
			String nome = "";
			rs = statement.executeQuery();
			while(rs.next())
			{		
				nome = rs.getString(1);
			}
			
			if(nome.isEmpty())
			{
				statement.close();
				rs.close();
				nome = "";
				verificacao = true;
				statement = con.prepareStatement("DELETE FROM ESPECIE WHERE ID = ?");
				statement.setLong(1, id);
				
				statement.executeUpdate();
				
			}
			else 
			{
				statement.close();
				rs.close();
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
		return verificacao;	
		}
		
	}


	@Override
	public List<Especie> listar() throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
	    ResultSet rs = null;
	    Especie especie = null;
		try 
		{
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT ID, NOME, DESCRICAO, TIPO_ANIMAL_ACRONIMO FROM ESPECIE;");
			rs = statement.executeQuery();
			lista = new ArrayList<Especie>();
			while(rs.next())
			{	
				especie = new Especie();
				Tipo_Animal tipoAnimal = new Tipo_Animal();
				especie.setID(rs.getInt(1));
				especie.setNome(rs.getString(2));
				especie.setDescricao(rs.getString(3));
				tipoAnimal.setAcronimo(rs.getString(4));
				especie.setTipoAnimal(tipoAnimal);

				
				lista.add(especie);
			
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
	
	public List<String> NomeLista() throws Exception {
		Connection con = null;
		nomeEspecie = new ArrayList<String>();
		PreparedStatement statement = null;
		
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT nome FROM especie");
			rs = statement.executeQuery();

			while (rs.next()) {
				String nome = null;
				nome = rs.getString("nome");
				nomeEspecie.add(nome);
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
		return nomeEspecie;
	}
	
	public Especie buscarEspeciePorNome(String nome) throws Exception {
		Connection con = null;
		Especie especie = null;
		lista = new ArrayList<Especie>();
		PreparedStatement statement = null;
		
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT ID FROM ESPECIE WHERE NOME = (?);");
			statement.setString(1, nome);
			rs = statement.executeQuery();

			while(rs.next()) {
				especie = new Especie();
				especie.setID(rs.getInt(1));

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
		return especie;
	}

}

