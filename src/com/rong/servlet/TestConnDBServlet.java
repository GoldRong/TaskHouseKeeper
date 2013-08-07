package com.rong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.rong.util.ConnectDBTools;

public class TestConnDBServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		ConnectDBTools conn=ConnectDBTools.getInstance();
		if(conn.getConnection()==null){
			pw.println("connect error");
		}else{
			String sql="select * from userinfo";
			ResultSet rs=conn.getResultSet(sql);
			List<String> list=new ArrayList<String>();
			try{
				while(rs.next()){
					list.add("uname:"+rs.getString("uname")+"=upass:"+rs.getString("upass"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			pw.println("connect success");
			
			JSONObject jsonObject=new JSONObject();
			for(int i=0;i<list.size();i++){
				jsonObject.put(""+i, list.get(i));
			}
			pw.println("jsonObject:"+jsonObject.toString());

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
