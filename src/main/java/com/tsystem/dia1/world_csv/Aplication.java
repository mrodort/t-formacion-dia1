package com.tsystem.dia1.world_csv;

import com.tsystem.dia1.world_csv.configuration.HibernateUtil;
import com.tsystem.dia1.world_csv.error.ElementNotFoundExpection;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;

public class Aplication {

    public static void main(final String args[]) {

	HibernateUtil.getSession();

	if (args.length < 1) {
	    throw new IllegalArgumentException("Debe al menos indicar un parametro para el comando.");
	}

	CommandSwitcher commadSwitcher = new CommandSwitcher();

	try {
	    commadSwitcher.executeCommand(args);
	} catch (RepositoryConnectionExpection e) {
	    System.err.println("Error al acceder al repositorio");
	    e.printStackTrace();
	} catch (ElementNotFoundExpection e) {
	    System.out.println("No existe ningun elemente con ese identificador.");
	}
    }
}
