package com.eg.web;

public interface EnvironmentVariable {
	
	String host=System.getenv("DATABASE_HOST");
	String port=System.getenv("DATABASE_PORT");
	String user=System.getenv("DATABASE_USERNAME");
	String password=System.getenv("DATABASE_PASSWORD");

}
