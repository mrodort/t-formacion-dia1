package com.tsystem.dia1.world_csv.error;

public class RepositoryConnectionExpection extends Exception {

    private static final long serialVersionUID = 1L;

    public RepositoryConnectionExpection() {
	super();
    }

    public RepositoryConnectionExpection(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public RepositoryConnectionExpection(String message, Throwable cause) {
	super(message, cause);
    }

    public RepositoryConnectionExpection(String message) {
	super(message);
    }

    public RepositoryConnectionExpection(Throwable cause) {
	super(cause);
    }

}
