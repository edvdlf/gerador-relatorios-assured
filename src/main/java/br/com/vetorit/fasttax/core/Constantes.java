package br.com.vetorit.fasttax.core;

import io.restassured.http.ContentType;

public interface Constantes {
	String APP_BASE_URL = "http://localhost:8080";
	
	String APP_BASE_URL_AUTH = "http://localhost:8099";
	
	String TOKEN_TEMP = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2ZXRvciIsImlzcyI6InRlc3RlIiwiaWF0IjoxNzYwNjIxODE5LCJhbWJpZW50ZSI6ImxvY2FsIiwiZXhwIjoxNzYwNzA4MjE5fQ.I2R1663_ELfTs8XuQy_6acEtrcTLtK4B9Gb64rllLvvTLtuitNB6eWer76Zxyj71igCGexJoyS3mdvnsSdCNaw";
			
	String TOKEN_TEMP_ADMIN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImFkbWluIiwiaWF0IjoxNzYwNjIxODE5LCJhbWJpZW50ZSI6ImxvY2FsIiwiZXhwIjoxNzYwNzA4MjE5fQ.NmapwUTaLxt-5OeRBvurPDaugPTgoA9SdJroWqsexvH3EBo-uwReqEEntGTOcQeQHwrM0J7LGhURydezaigkiA";
					
	
	
	Integer APP_PORT = 8090;
	
	String APP_BASE_PATH = "";
	ContentType APP_CONTENT_TYPE= ContentType.JSON;
	Long MAX_TIME_OUT = 50000l;
}
