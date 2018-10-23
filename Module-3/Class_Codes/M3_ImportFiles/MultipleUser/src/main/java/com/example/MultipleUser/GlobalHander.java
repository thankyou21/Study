package com.example.MultipleUser;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHander 
{
	@ExceptionHandler(Exception.class)
	public void handler(HttpServletResponse res)
	{
		try {
			res.sendRedirect("http://google.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
