package br.com.vetorit.fasttax.core;

import io.restassured.http.ContentType;

public interface Constantes {
	String APP_BASE_URL = "http://localhost:8080";
	
	String APP_BASE_URL_AUTH = "http://localhost:8099";
	
	String TOKEN_TEMP = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2ZXRvciIsImlzcyI6InRlc3RlIiwiaWF0IjoxNzYxMjI0NTAyLCJhbWJpZW50ZSI6ImxvY2FsIiwiZXhwIjoxNzYxMzEwOTAyfQ.kI7U4RiZi6l5Y5IOxFN75wrsT9wqqtbb-oxOBolr8NVdByxc3yCV1-DeQiNQtbG_MMA-FTuPpxDzYmOnMWJVIA";
			
	String TOKEN_TEMP_ADMIN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImFkbWluIiwiaWF0IjoxNzYxMjI0NTAyLCJhbWJpZW50ZSI6ImxvY2FsIiwiZXhwIjoxNzYxMzEwOTAyfQ.ZwFRcECg4eAtk1GPXEXYJhKpUCKqKQU6NWFNLxz2qsvcON5BMEMU-s0oTJaspYxzHS0pNZUAV0KI61RXIP-0HQ";
					
	
	
	Integer APP_PORT = 8090;
	
	String APP_BASE_PATH = "";
	ContentType APP_CONTENT_TYPE= ContentType.JSON;
	Long MAX_TIME_OUT = 50000l;
}
