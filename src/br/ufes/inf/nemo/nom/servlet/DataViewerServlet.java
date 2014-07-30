package br.ufes.inf.nemo.nom.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class DataViewerServlet extends HttpServlet{
	
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
    
    	//String uri = request.getAttribute("javax.servlet.forward.request_uri").toString();
    	String uriPath = request.getParameter("uri");
    	
    	URI = "http://localhost:8080" + uriPath;
    	
    	//System.out.println(URL);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/resource/response.faces");
        rd.forward(request, response);
    	
    }

}
