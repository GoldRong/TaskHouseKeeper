package com.rong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rong.util.ConnectDBTools;

public class AddData2DBServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String data=req.getParameter("data");
		String time=req.getParameter("time");
		String uname=req.getParameter("uname");
		PrintWriter pw=resp.getWriter();
		
		System.out.println(data+"==="+time+"==="+uname);
		ConnectDBTools tools=ConnectDBTools.getInstance();
		String sql="INSERT INTO `userdata` (`uname`, `utime`, `udata`) VALUES ('"+uname+"', '"+time+"', '"+data+"')"; 
		try{
			if(tools.getStatement().executeUpdate(sql)==1){
				pw.print("add success");
			}else{
				pw.print("add error");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.flush();
			pw.close();
			tools.close();
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
