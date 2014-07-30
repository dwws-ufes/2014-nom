package br.ufes.inf.nemo.nom.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DataViewerHTMLServlet extends HttpServlet{

	public static String URI;

	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Servlet Ready");
    }

    public void destroy() {
        super.destroy();
        log("Servlet Destroyer");
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
    	String uriPath = request.getParameter("uri");
    	
    	URI = "http://localhost:8080" + uriPath.replace(".html", "");
    	
    	//System.out.println(URL);
    	
    	if(URI.contains("/organization/")){
    		RequestDispatcher rd = request.getRequestDispatcher("/resource/html/organization.faces");
            rd.forward(request, response);
    	}
    	else if(URI.contains("/address/")){
    		RequestDispatcher rd = request.getRequestDispatcher("/resource/html/organizationAddress.faces");
            rd.forward(request, response);
    	}
    	else if(URI.contains("/organization-structure/")){
    		RequestDispatcher rd = request.getRequestDispatcher("/resource/html/organizationStructure.faces");
            rd.forward(request, response);
    	}  	
    	else if(URI.contains("/person/")){
    		RequestDispatcher rd = request.getRequestDispatcher("/resource/html/person.faces");
            rd.forward(request, response);
    	}
    	
    	//RequestDispatcher rd = request.getRequestDispatcher("/resource/responseHTML.faces");
        //rd.forward(request, response);
    	
    }
	
}
