<%@ page import="java.sql.*"%>
<%@ page import="org.json.simple.*"%>
<%

	String s=request.getParameter("stateid"); // http://ip:port/RestWeb/index.jsp?val1=100&val2=jack&val3=9000

	if(s==null || s.trim().equals(""))
	{
		out.print("Please enter state id");
	}
	else
	{
		int id=Integer.parseInt(s);
		try
		{
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver loaded...");
			
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mdb","root","root");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/get940","root","secondguy");
			System.out.println("Connected...");
			
			PreparedStatement ps=con.prepareStatement("select * from state where stateid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			System.out.println("Query fired..got the result.....");
			
			if(rs.next())
			{
				JSONObject obj=new JSONObject();    
				obj.put("stateID",rs.getInt(1));
				obj.put("stateName", rs.getString(2));
				obj.put("stateCities", rs.getString(3));
				String jsonText = JSONValue.toJSONString(obj);  
				out.print(jsonText);  
			}
			System.out.println("ResultSet is sent....");
			
			con.close();
			System.out.println("Connection closed.......");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>