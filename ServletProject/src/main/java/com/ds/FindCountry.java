package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class FindCountry
 */
@WebServlet("/FindCountry")
public class FindCountry extends GenericServlet {
	private static final long serialVersionUID = 1L;
	TreeMap<String,Country> countryMap;
    /**
     * @see GenericServlet#GenericServlet()
     */
    public FindCountry() {
        super();
        Country c1 = new Country("India", "New Delhi", "Mr. Narendra Modi", "136.64 Crores", "Rs");
		Country c2 = new Country("Pakistan", "Islamabad", "Mr. Imran Khan", "21.66 Crores", "Pakistani Rupee");
		Country c3 = new Country("China", "Beijing", "Mr. Xi Jinping", "139.77 Crores", "Yuan");
		Country c4 = new Country("England", "London", "Mr. Boriss Johnson", "6.66 Crores", "Pound Sterling");
		Country c5 = new Country("America", "Washington DC", "Mr. Joe Biden", "32.82 Crores", "USD");
		
		countryMap = new TreeMap<String,Country>();
		System.out.println("Map is ready....");
		
		countryMap.put("IND", c1);
		countryMap.put("PAK", c2);
		countryMap.put("CHI", c3);
		countryMap.put("UK", c4);
		countryMap.put("US", c5);
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service 123");
		response.setContentType("text/html");
		String country = request.getParameter("countryName");
		PrintWriter pw  = response.getWriter();
		if(countryMap.containsKey(country)) {
			Country foundCountry = countryMap.get(country);
			pw.println("<h2> The capital of " + foundCountry.name + " is " + foundCountry.capital);
		}
	}

}
