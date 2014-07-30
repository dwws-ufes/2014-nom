package br.ufes.inf.nemo.nom.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

import br.ufes.inf.nemo.nom.ConnectionFactory;
import br.ufes.inf.nemo.nom.servlet.DataViewerGraphServlet;

@ManagedBean (name="GraphDataController")
public class GraphDataController {

	private MindmapNode subject;
	
    private MindmapNode selectedNode;
     
    public GraphDataController() throws ClassNotFoundException, SQLException {
    	
    	String uri = DataViewerGraphServlet.URI;
    	
    	subject = new DefaultMindmapNode(uri, uri, "FFCC00", false);
		
		String query = "sparql SELECT * from <http://localhost:8080/NOM/resource#> where { <" + uri + "> ?p ?o .}";
		
		//System.out.println(query);
		
		ResultSet rs = executeQuery(query);
		
		while(rs.next()){
			
			//MindmapNode p = new DefaultMindmapNode(rs.getString("p"), rs.getString("o"), "ff5858", true);
			
			if(rs.getString("o").contains("http")){
				MindmapNode object = new DefaultMindmapNode(rs.getString("o"), rs.getString("o"), "6e9ebf", true);	
				subject.addNode(object);
			}
			else{
				MindmapNode object = new DefaultMindmapNode(rs.getString("o"), rs.getString("o"), "97ff4a", true);
				subject.addNode(object);
			}


		}
		
		rs.close();
    	
    }
 
    public MindmapNode getSubject() {
        return subject;
    }
 
    public MindmapNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }
 
    public void onNodeSelect(SelectEvent event) throws IOException {
        MindmapNode node = (MindmapNode) event.getObject();
         
        String url = "http://localhost:8080";
        
        //populate if not already loaded
        if(node.getChildren().isEmpty()) {
            Object label = node.getLabel();
            if(label.toString().contains(url)){
            	FacesContext.getCurrentInstance().getExternalContext().redirect(label.toString() + ".graph"); 
            }else if (label.toString().contains("http")){
            	FacesContext.getCurrentInstance().getExternalContext().redirect(label.toString());
            }
        }   
    }
     
    public void onNodeDblselect(SelectEvent event) {
        this.selectedNode = (MindmapNode) event.getObject();    
        
    }
    
    public ResultSet executeQuery (String query) throws SQLException, ClassNotFoundException{
		
		Connection connection = new ConnectionFactory().getConnection();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
				
		return rs;
		
	}
	
}
