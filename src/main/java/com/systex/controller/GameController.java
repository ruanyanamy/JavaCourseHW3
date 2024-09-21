package com.systex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;

import com.systex.model.GuessGame;

/**
 * Servlet implementation class GameController
 */
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameController() {
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
		HttpSession session = request.getSession();
				
		GuessGame guessg = new GuessGame(10 , 3);
		session.setAttribute("range", 10);
		session.setAttribute("guessg", guessg);
		session.setAttribute("remainchance", guessg.getRemains());
		
		RequestDispatcher view = request.getRequestDispatcher("guess.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		LinkedList<String> ErrorMsgs = new LinkedList<>();
		request.setAttribute("error", ErrorMsgs);
		RequestDispatcher view;
		HttpSession session = request.getSession();
		
		String number = request.getParameter("getnum");
		boolean guessrw;
		int remainchance , luckynum;
		
		if (number == null || number.trim().isEmpty()) {
			ErrorMsgs.add("請輸入您要猜的數字");
		}else {
			if ( number.trim().equals("0")) {
			    ErrorMsgs.add("請輸入大於1的數字");
			}
			if (Integer.parseInt(number.trim()) > 10) {
				ErrorMsgs.add("請輸入小於10的數字");
			}
		}
		if (!ErrorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
			return;
		}
		
		try {
			GuessGame guessg = (GuessGame)session.getAttribute("guessg");
			guessrw = guessg.guess(Integer.parseInt(number));
			remainchance = guessg.getRemains();
			luckynum = guessg.getLuckyNumber();
			
			request.setAttribute("guessnum", number);
			request.setAttribute("guessrw", guessrw);
			session.setAttribute("remainchance", remainchance);
			request.setAttribute("luckynum", luckynum);
			
			if (guessrw) {
	            view = request.getRequestDispatcher("youWin.jsp");
	        }else if (remainchance <= 0) {
	            view = request.getRequestDispatcher("youLose.jsp");
	        }else {
	            view = request.getRequestDispatcher("guess.jsp");
	        }
	        view.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			ErrorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
		}
	}

}
