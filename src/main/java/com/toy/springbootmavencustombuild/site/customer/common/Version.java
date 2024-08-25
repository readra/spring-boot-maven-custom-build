package com.toy.springbootmavencustombuild.site.customer.common;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class Version {
	public static final String VERSION = com.toy.springbootmavencustombuild.common.Version.VERSION + ".1";

	public static void main(String[] args) throws IOException {
		Files.writeString(Path.of(System.getProperty("user.dir") + "\\build.version.properties"), "VERSION=" + VERSION);
	}
}
