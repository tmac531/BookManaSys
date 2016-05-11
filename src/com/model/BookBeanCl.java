package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BookBeanCl {
	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;
	private int pageSize = 3;
	private int pageNow = 1;
	private int rowCount = 0;
	private int pageCount = 0;

	public void close() {

		try {

			if (rs != null)
				rs.close();
			if (sm != null)
				sm.close();

			if (ct != null)
				ct.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return int 返回总页数
	 */

	public int getPageCount() {
		try {
			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			rs = sm.executeQuery("select count(*) from book");
			if (rs.next())
				rowCount = rs.getInt(1);

			if (rowCount % pageSize == 0)
				pageCount = rowCount / pageSize;
			else
				pageCount = rowCount / pageSize + 1;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.close();

		}
		return pageCount;

	}

	public ArrayList getBookByPage(int pageNow) {
		ArrayList al = new ArrayList();

		try {

			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			rs = sm.executeQuery("select top " + pageSize
					+ " * from book where bookId not in (select top "
					+ pageSize * (pageNow - 1) + " bookId from book) ");

			while (rs.next()) {
				BookBean bb = new BookBean();
				bb.setBookId(rs.getInt(1));
				bb.setBookName(rs.getString(2));
				bb.setBookAuthor(rs.getString(3));
				al.add(bb);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.close();
		}

		return al;

	}

	public boolean addBook(String bookName, String bookAuthor) {

		boolean b = false;

		try {

			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			int i = sm.executeUpdate("insert into book values('" + bookName
					+ "','" + bookAuthor + "')");
			if (i == 1)

				b = true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return b;
	}

	public boolean delBook(int bookid){
		
		boolean b=false;
		try {
			
			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			int i=sm.executeUpdate("delete from book where bookId='"+bookid+"'");
		if(i==1)
			
		b=true;
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return true;
		
		
	}
	
	public boolean updateBook(int bookid,String bookname,String bookauthor){
	
		boolean b=false;
		try {
		
		ct = new ConnDB().getConn();
		sm = ct.createStatement();
		int i=sm.executeUpdate("update book set bookName='"+bookname+"',bookAuthor='"+bookauthor+"' where bookId='"+bookid+"'");
		if(i==1)
			b=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}	
		return b;
		
	}
	
	
}
