package com.student.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.student.model.Cla;
import com.student.service.ClassService;

@SuppressWarnings("serial")
public class ClassAction extends ActionSupport
{
	protected ClassService classService;
	protected Cla cla;

	public Cla getCla()
	{
		return cla;
	}

	public void setCla(Cla cla)
	{
		this.cla = cla;
	}

	public ClassService getClassService()
	{
		return classService;
	}

	public void setClassService(ClassService classService)
	{
		this.classService = classService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String clalist() throws Exception
	{
		List classes = classService.findallcla(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("class", classes);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String deletecla() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String checkTnum = new String(request1.getParameter("checkTnum").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(checkTnum);
		String [] checkedNums = checkTnum.split(",");
		for(int i=0;i<checkedNums.length;i++)
		{
			System.out.println(checkedNums[i]);
			classService.deletecla(checkedNums[i]);
		}
		List classes = classService.findallcla(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("class");
		request.put("class", classes);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String addcla() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String cid = new String(request1.getParameter("cid").getBytes("ISO-8859-1"),"UTF-8");
		String cname = new String(request1.getParameter("cname").getBytes("ISO-8859-1"),"UTF-8");
		classService.addcla(cid,cname);
		List classes = classService.findallcla(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("class");
		request.put("class", classes);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String searchcla() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String sort = new String(request1.getParameter("sort").getBytes("ISO-8859-1"),"UTF-8");
		String menuname = new String(request1.getParameter("menuname").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(sort);
		System.out.println(menuname);
		if(sort.equals("cid"))
		{
			List classes = classService.findbyid(menuname);
			Map request = (Map) ActionContext.getContext().get("request");
			request.remove("class");
			request.put("class", classes);
		}
		else if(sort.equals("cname"))
		{
			List classes = classService.findbyname(menuname); 
			Map request = (Map) ActionContext.getContext().get("request");
			request.remove("class");
			request.put("class", classes);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String savecla() throws Exception
	{
		HttpServletRequest request1 = ServletActionContext.getRequest();
		request1.setCharacterEncoding("utf-8");
		String cid = new String(request1.getParameter("cid").getBytes("ISO-8859-1"),"UTF-8");
		String cname = new String(request1.getParameter("cname").getBytes("ISO-8859-1"),"UTF-8");
		classService.updatecla(cid,cname);
		List classes = classService.findallcla(); 
		Map request = (Map) ActionContext.getContext().get("request");
		request.remove("class");
		request.put("class", classes);
		return SUCCESS;
	}
	
	public void showclass() throws Exception
	{
		List<Cla> cla = classService.findallcla();
		String arrCF="";
		for(int i=0;i<cla.size();i++)
		{
			arrCF +=cla.get(i).getId()+","+cla.get(i).getName()+",";
		}
		arrCF = arrCF.substring(0,arrCF.length()-1);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().write(arrCF);
	}
}
