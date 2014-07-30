package br.ufes.inf.nemo.nom.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class DataViewerRDFServlet extends HttpServlet{
	
	public static String URI, URIPath;

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
    	
    	URIPath = uriPath;
    	URI = "http://localhost:8080" + URIPath.replace(".rdf", "");;
    	
    	//System.out.println(URI);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/resource/responseRDF.faces");
        rd.forward(request, response);
    	
    }

}
