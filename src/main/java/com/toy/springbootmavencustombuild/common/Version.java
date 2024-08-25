package com.toy.springbootmavencustombuild.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Version {
	public static final String VERSION = "v1";

	public static void main(String[] args) throws IOException {
		Files.writeString(Path.of(System.getProperty("user.dir") + "\\build.version.properties"), "VERSION=" + VERSION);
	}
}
