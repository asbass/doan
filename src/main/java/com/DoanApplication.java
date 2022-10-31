package com;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoanApplication.class, args);
		Runtime rt = Runtime.getRuntime();
	      try {
	    	  rt.exec("cmd /c start chrome.exe http://localhost:8080/home/index");
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
}
