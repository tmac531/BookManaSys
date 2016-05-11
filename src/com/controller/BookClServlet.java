package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;


public class BookClServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//解决接受jsp传来参数不能正常显示中文的问题
		request.setCharacterEncoding("UTF-8"); 
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String flag=request.getParameter("flag");
		
		if(flag.equals("fenye")){
			
			
			try {
				String pageNow_1 =request.getParameter("pageNow");
				 int pageNow=Integer.parseInt(pageNow_1);
				BookBeanCl bbc=new BookBeanCl();
				ArrayList al=bbc.getBookByPage(pageNow);
				int pageCount=bbc.getPageCount();
				request.setAttribute("result", al);
				request.setAttribute("pageNow", pageNow+"");
				request.setAttribute("pageCount", pageCount+"");
				request.getRequestDispatcher("Wel.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
		}
			
		else if(flag.equals("addbook")){
			try {
				
				String bookName=request.getParameter("bookname");
				String bookAuthor=request.getParameter("bookauthor");
				//System.out.println(bookName);
				//System.out.println(bookAuthor);
				
				BookBeanCl bbc=new BookBeanCl();
				if(bbc.addBook(bookName, bookAuthor)){
					
				request.getRequestDispatcher("Main.jsp").forward(request, response);
					
					
				}
					
					
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		else if(flag.equals("delBook")){
			
		try {
			
			int bookId=Integer.parseInt(request.getParameter("bookId"));
			BookBeanCl bbc=new BookBeanCl();
			if(bbc.delBook(bookId))
				//System.out.println("删除成功");
				request.getRequestDispatcher("Main.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		}
		
		else if(flag.equals("updatebook"))
			
		//	System.out.println("更新完成");
			try {
				String bookName=request.getParameter("bookname");
				String bookAuthor=request.getParameter("bookauthor");
				int bookId=Integer.parseInt(request.getParameter("bookid"));
				BookBeanCl bbc=new BookBeanCl();
				if(bbc.updateBook(bookId, bookName, bookAuthor))
				request.getRequestDispatcher("Main.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		//response.setContentType("text/html");
	//	PrintWriter out = response.getWriter();
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
