package com.eg.web;

public interface EnvironmentVariable {
	
	String host=System.getenv("DATABASE_HOST");
	String port=System.getenv("DATABASE_PORT");
	
	

}
