package com.saty.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegController {
	
	
	@GetMapping("register")
	public ModelAndView register( @RequestParam(name="name",required = false) String name, 
			@RequestParam(name="pass",required=false) String password) throws ClassNotFoundException, SQLException {
			ModelAndView mv = new ModelAndView("regview");
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
	        Statement st = con.createStatement();
	        st.executeQuery("Insert into demo values('"+name+"','"+password+"')");
			}
			catch(Exception e) {
				System.out.println("Database Error, values not inserted");
			}
			mv.addObject("name",name);
			System.out.println("user registered");
			return mv;
	}
}
