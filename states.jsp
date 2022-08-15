<%@ page import="java.sql.*"%>
<%@ page import="org.json.simple.*"%>
<%
	try
	{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded...");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","sarvesh123");
		System.out.println("Connected...");
		
		PreparedStatement ps=con.prepareStatement("select * from state");
		ResultSet rs=ps.executeQuery();
		System.out.println("Query fired..got the result.....");
		
		JSONArray jsarr = new JSONArray();
		while(rs.next())
		{
			JSONObject obj=new JSONObject();    
			obj.put("stateID",rs.getInt(1));
			obj.put("stateName", rs.getString(2));
			jsarr.add(obj);
		}
		String jsonText = JSONValue.toJSONString(jsarr);  
		out.print(jsonText);  
		
		System.out.println("ResultSet is sent....");
		
		con.close();
		System.out.println("Connection closed.......");
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
%>