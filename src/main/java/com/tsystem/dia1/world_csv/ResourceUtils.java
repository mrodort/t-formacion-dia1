package com.tsystem.dia1.world_csv;

import java.io.File;

public class ResourceUtils {
    public static File getResourceByName(String fileName) {
	final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

	return new File(systemClassLoader.getResource(fileName).getFile());
    }
}
