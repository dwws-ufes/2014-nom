<%@ page import="br.ufes.inf.nemo.nom.models.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

</head>
<body>

	<input type="hidden" value="" id="in1" name="test" />  

	<script type="text/javascript">
			document.write(document.URL);
			document.getElementsByID('in1').value = document.URL;
	</script>
	
	<jsp:forward page="../dataViewer">
		<jsp:param name="uri" value="${requestScope['javax.servlet.forward.request_uri']}"/> 
	</jsp:forward>
	
  	
</body>
</html>