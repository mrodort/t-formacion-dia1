package com.tsystem.dia1.world_csv.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;

public class MySQLConnectionFactory {

    private final static String URL = "jdbc:mysql://192.168.1.30:3306/world?serverTimezone=UTC&useSSL=false";
    private final static String USUARIO = "curso";
    private final static String CLAVE = "curso";

    private static Connection mysqlConnection = null;

    public Connection getInstance() throws RepositoryConnectionExpection {
	if (mysqlConnection == null) {
	    mysqlConnection = connect();
	}

	return mysqlConnection;
    }

    public Connection connect() throws RepositoryConnectionExpection {

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    return DriverManager.getConnection(URL, USUARIO, CLAVE);
	} catch (SQLException e) {
	    throw new RepositoryConnectionExpection("Error al conectarme al servidor MySQL. ", e);
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
	    throw new RepositoryConnectionExpection("Error al cargar el driver. ", e);
	}
    }
}
