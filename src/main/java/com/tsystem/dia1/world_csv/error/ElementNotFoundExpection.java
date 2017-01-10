package com.tsystem.dia1.world_csv.error;

public class ElementNotFoundExpection extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ElementNotFoundExpection(String message) {
	super(message);
    }
}
