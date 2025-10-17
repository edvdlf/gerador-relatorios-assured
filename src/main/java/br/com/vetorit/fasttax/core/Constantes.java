package br.com.vetorit.fasttax.core;

import io.restassured.http.ContentType;

public interface Constantes {
	String APP_BASE_URL = "http://localhost:8080";
	
	String APP_BASE_URL_AUTH = "http://localhost:8099";
	
	String TOKEN_TEMP = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2ZXRvciIsImlzcyI6InRlc3RlIiwiaWF0IjoxNzYwNzA4NTQ3LCJhbWJpZW50ZSI6ImxvY2FsIiwiZXhwIjoxNzYwNzk0OTQ3fQ.Symj9ReD2rmgkJ2Qr4zkiBrF_Oqt0fOoyU6Yfa_Q8BivV2UrHMhXw-U0jVF_u8YgeVjuQoOcMogvWlUnAIzAJw";
			
	String TOKEN_TEMP_ADMIN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImFkbWluIiwiaWF0IjoxNzYwNzA4NTQ3LCJhbWJpZW50ZSI6ImxvY2FsIiwiZXhwIjoxNzYwNzk0OTQ3fQ.CxAIS0W94USz0gPQzcci8qRksyIOYAHozIpfY9qGf3tGaQhAe97cj7tDb0BBKRM13URyq86nttQI7otaxb76Rw";
					
	
	
	Integer APP_PORT = 8090;
	
	String APP_BASE_PATH = "";
	ContentType APP_CONTENT_TYPE= ContentType.JSON;
	Long MAX_TIME_OUT = 50000l;
}
