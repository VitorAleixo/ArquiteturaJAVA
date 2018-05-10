package com.up.clinicavet.dao;

import java.util.List;

public interface IGenericDAO <T,u>
{
	public boolean  salvar(T obj);
	public void atualizar(T obj);
	public  T buscar(u id);
	public  boolean excluir (u id);
	public  List<T> listar() throws Exception;
}

