package com.systex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import com.systex.model.LotteryService;

/**
 * Servlet implementation class LotteryController
 */
public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LotteryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher view;
		LinkedList<String> ErrorMsgs = new LinkedList<>();
		request.setAttribute("error", ErrorMsgs);
		
		// 1. retrieve form data
		String group = request.getParameter("group");
		String[] excludes = request.getParameterValues("excludenumber");
		
		// 2. convert form data
		//N/A
		
		// 3. validate form data
		if (group == null || group.trim().isEmpty()) {
			ErrorMsgs.add("請填寫需要生出的樂透組數");
		}
		if (excludes == null || excludes.length == 0 || (excludes.length == 1 && excludes[0].trim().isEmpty())) {
			ErrorMsgs.add("請填寫至少一個不想包含的樂透號碼");
		}
		if (!ErrorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
			return;
		}
		
		// 4. invoke business logic
		try {
			LotteryService ls = new LotteryService();
			ArrayList<String> result = new ArrayList<>();
			LinkedList<String> exclude = new LinkedList<String>(Arrays.asList(excludes));
			Set<Integer> exclude2 = new TreeSet<>();
			
			for (String exc : excludes) {
				String[] e = exc.trim().split("\\s+");
				for (String num : e) {
					if (Integer.parseInt(num) > 0 && Integer.parseInt(num) <= 49) {
			            exclude2.add(Integer.parseInt(num));
					}
		        }
			}
			
			result = ls.getNumber(Integer.parseInt(group), exclude);
			request.setAttribute("res", result);
		    request.setAttribute("group", group);
		    request.setAttribute("exclude", exclude2);
			
			view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			ErrorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("main.jsp"); 
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
