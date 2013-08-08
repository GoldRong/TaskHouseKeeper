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

public class CheckUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		ConnectDBTools tools=ConnectDBTools.getInstance();
		String sql="SELECT * FROM userinfo WHERE uname='"+uname+"' AND upass='"+upass+"'" ;
		PrintWriter pw=resp.getWriter();
		JSONObject json=new JSONObject();
		try{
			ResultSet rs=tools.getResultSet(sql);
			if(rs!=null){
				rs.last();
				if(rs.getRow()==1){
					json.put("uname", uname);
					json.put("isExist",true);
					pw.print(json);
				}else{
					json.put("isExist",false);
					pw.print(json);
				}
			}else{
				json.put("isExist",false);
				pw.print(json.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
