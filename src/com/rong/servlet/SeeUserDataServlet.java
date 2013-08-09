package com.rong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.rong.util.ConnectDBTools;

public class SeeUserDataServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String time=req.getParameter("time");
		String uname=req.getParameter("uname");
		ConnectDBTools tools=ConnectDBTools.getInstance();
		String sql="SELECT * FROM userdata WHERE uname='"+uname+"' AND utime='"+time+"'";
		PrintWriter pw=resp.getWriter();
		try{
			ResultSet rs=tools.getResultSet(sql);
			JSONObject json=new JSONObject();
			while(rs.next()){
				json.put("udata", rs.getString("udata"));
			}
			pw.print(json);
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
