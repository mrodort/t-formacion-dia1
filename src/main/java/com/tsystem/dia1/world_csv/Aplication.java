package com.tsystem.dia1.world_csv;

import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;

public class Aplication {

    public static void main(final String args[]) {

	if (args.length < 1) {
	    throw new IllegalArgumentException("Debe al menos indicar un parametro para el comando.");
	}

	CommandSwitcher commadSwitcher = new CommandSwitcher();

	try {
	    commadSwitcher.executeCommand(args);
	} catch (RepositoryConnectionExpection e) {
	    System.err.println("Error al acceder al repositorio");
	    e.printStackTrace();
	}
    }
}
