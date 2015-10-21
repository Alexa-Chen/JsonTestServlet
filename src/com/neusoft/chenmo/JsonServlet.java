package com.neusoft.chenmo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.JSONObject;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JsonServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		json.put("Name", "Using GCC");
		json.put("Date", "1999-1-1");
		json.put("Press", "The GNU Press");
		json.put("Price", "$10");
		JSONObject other = new JSONObject();
		other.put("License", "GNU FDL 1.3");
		other.put("Target", "Developer");
		json.put("Other", other);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String query = request.getQueryString();
		
		try {
			JSONObject json = new JSONObject(query);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
