package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.User;
import cn.itcast.entity.Visit;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	private Visit visit=new Visit();
	public Visit getModel() {
		return visit;
	}
	private VisitService visitService;
	private UserService userService;
	private CustomerService customerService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	public String toAddPage() {
		List<User> listUser= userService.findAll();
		List<Customer> listCustomer=customerService.findAll();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listUser",listUser);
		request.setAttribute("listCustomer",listCustomer);

		return "toAddPage";
	}
	//
	public String addVisit() {
		visitService.addVisit(visit);
		return "addVisit";
	}
	
	//
	public String listVisit() {
		List<Visit> list= visitService.findAll();
		ServletActionContext.getRequest().setAttribute("list",list);
		return "listVisit";
	}
    //
	public String toSelectCustomerPage() {
		List<Customer> listcus = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listcus", listcus);
		List<User> listuser = userService.findAll();
		ServletActionContext.getRequest().setAttribute("listuser", listuser);
		
		return "toSelectCustomerPage";
	}
	//
	public String moreCondition() {  
		List<Visit> list=  visitService.findMoreCondition(visit);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	//
   public String delete() {
	   int vid=visit.getVid();
	   Visit v=visitService.findOne(vid);
		if(v != null) {
			visitService.delete(v);
		
		}return "delete";

   }
   //
   public String showVisit() {
	   int vid=visit.getVid();
	   Visit v=visitService.findOne(vid);
	    List<Customer> listcus = customerService.findAll();
		
		List<User> listuser = userService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("visit", v);
		request.setAttribute("listcus", listcus);
		request.setAttribute("visit", v);
		request.setAttribute("listuser", listuser);
	   
	   return"showVisit";
   }
   public String update() {
	   visitService.update(visit);
	   return"update";
   }

}
