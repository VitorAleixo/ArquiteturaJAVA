package com.up.clinicavet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Especie;

public class AnimalDAO implements IGenericDAO<Animal, Long>
{
	Connection con = null;
	PreparedStatement statement = null;
	List<Animal> lista = null;
	
	@Override
	public boolean salvar(Animal obj) {
		// TODO Auto-generated method stub
		boolean verificacao = false;
		ResultSet rs = null;
		try 
		{
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT NOME FROM ANIMAL WHERE NOME = ?");
			statement.setString(1, obj.getNome());
			rs = statement.executeQuery();
			String nome = "";
			while(rs.next())
			{
				nome = (rs.getString(1));
			}
			if (nome.isEmpty())
			{
			statement = con.prepareStatement("INSERT INTO ANIMAL (NOME, NASCIMENTO, ESPECIE_ID) VALUES(?,?,?)");
			statement.setString(1, obj.getNome());
			statement.setDate(2, obj.getNascimento());
			statement.setLong(3,obj.getEspecie().getID());
			String datanascimento = obj.getNascimento().toString();
			if (datanascimento.length() > 10)
			{
			     verificacao = false;
			}
			else {
			statement.executeUpdate();
			verificacao = true;
			}
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
	public void atualizar(Animal obj) {
		// TODO Auto-generated method stub
		ConnectionFactory.getConnection();
		
	}

	@Override
	public Animal buscar(Long id) {
		// TODO Auto-generated method stub
		
		try 
		{
			con = ConnectionFactory.getConnection();
			
			statement = con.prepareStatement("SELECT ID, NOME, NASCIMENTO, ESPECIE_ID FROM ANIMAL WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeQuery();
			
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
			
		}
		return null;
	}

	@Override
public boolean excluir(Long id)
{
	ResultSet rs = null;
	boolean validacao = false;
	try 
	{
		con = ConnectionFactory.getConnection();
		int idLer = 0;
		
		statement = con.prepareStatement("SELECT ID FROM ANIMAL WHERE ID = ?");
		statement.setLong(1, id);
		rs = statement.executeQuery();
		while(rs.next())
		{
			idLer = rs.getInt(1);
		}
		
		if(idLer == 0)
		{
			validacao = false;
		}
		else {
		statement = con.prepareStatement("DELETE FROM ANIMAL WHERE ID = ?");
		statement.setLong(1, id);
		statement.executeUpdate();
		validacao = true;
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
		
	}
	return validacao;	
}

	@Override
	public List<Animal> listar() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement statement = null;
	    ResultSet rs = null;
		try 
		{
			con = ConnectionFactory.getConnection();
			statement = con.prepareStatement("SELECT ID, a.NOME, a.NASCIMENTO, e.TIPO_ANIMAL_ACRONIMO FROM ANIMAL a "
					+ "INNER JOIN ESPECIE e ON a.ESPECIE_ID = e.ID");
			lista = new ArrayList<Animal>();
			rs = statement.executeQuery();
			while(rs.next())
			{		
				Animal animal = new Animal();
				Especie especie = new Especie();
				animal.setID(rs.getInt(1));
				animal.setNome(rs.getString(2));
				animal.setNascimento(rs.getDate(3));
				especie.setNome(rs.getString(4));
				animal.setEspecie(especie);
				lista.add(animal);
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

}
