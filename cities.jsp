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
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","sarvesh123");
			System.out.println("Connected...");
			
			PreparedStatement ps=con.prepareStatement("select * from city where sid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			JSONArray jsarr = new JSONArray();
			while(rs.next())
			{
				JSONObject obj=new JSONObject();    
				obj.put("cityID",rs.getInt(1));
				obj.put("cityName", rs.getString(2));
				obj.put("stateID", rs.getInt(3));
				jsarr.add(obj);
			}
			String jsonText = JSONValue.toJSONString(jsarr);  
			out.print(jsonText);  
	
			con.close();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>