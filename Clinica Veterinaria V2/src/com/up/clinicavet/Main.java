package com.up.clinicavet;
import java.util.Scanner;

import com.up.clinica.controller.PrincipalController;
import com.up.clinica.view.ViewPrincipal;
import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.dao.EspecieDAO;
import com.up.clinicavet.dao.IGenericDAO;
import com.up.clinicavet.dao.Tipo_AnimalDAO;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Especie;
import com.up.clinicavet.model.Tipo_Animal;

public class Main {

	public static void main (String[] args) throws Exception
	{		
		ViewPrincipal view = new ViewPrincipal();
		PrincipalController controller = new PrincipalController(view);
		view.setVisible(true);		
	}
}
