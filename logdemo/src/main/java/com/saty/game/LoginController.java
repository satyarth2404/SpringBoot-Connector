package com.saty.game;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@GetMapping("login")
	public ModelAndView login( @RequestParam(name="name",required = false) String name, @RequestParam(name="pass",required=false) String password) throws ClassNotFoundException, SQLException {
			ModelAndView mv = new ModelAndView("result");
			ModelAndView mv2 = new ModelAndView("error");
			mv.addObject("name",name);
			mv2.addObject("error","login error");
			
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
	        Statement st = con.createStatement();	        
	        String select="select * from DEMO where NAME='"+name+"' and PASSWORD='"+password+"'";
	        ResultSet rs = st.executeQuery(select);
	        
	        if(rs.next()) {
			System.out.println("Login Successful");
	        return mv;
	        }
	        else {
	        	System.out.println("Wrong username or password");
	        	return mv2;
	        }
			}
			catch(Exception e) {
				System.out.println("Wrong username or password");
				return mv2;
			}
	}
}
