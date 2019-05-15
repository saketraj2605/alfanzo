package com.cts.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.cts.dao.PharmacyDAOImpl;
import com.cts.model.Login;
import com.cts.model.Medicine;

public class PharmacyServiceImpl implements PharmacyService {
	
    PharmacyDAOImpl pharmacyDAO;
    
    
	public PharmacyServiceImpl(String jdbcDriver, String jdbcUsername, String jdbcPassword,String jdbcURL) {
		super();
		pharmacyDAO = new PharmacyDAOImpl(jdbcDriver, jdbcUsername, jdbcPassword, jdbcURL);
	}


	@Override
	public boolean validate(HttpServletRequest request,
			HttpServletResponse response) {
		if(pharmacyDAO.validate(request,response)){
			System.out.println("valid login ");
			Login login =(Login)request.getAttribute("user");
			System.out.println("welcome " + login.getRole());			
			List<Medicine> medicineList= new ArrayList<>();
			try {
				medicineList = pharmacyDAO.listAllMedicine();
				for (Medicine m : medicineList) { 		      
			           System.out.print(m.getId()+"    ");
			           System.out.print(m.getName()+"    ");
			           System.out.print(m.getType()+"    ");
			           System.out.print(m.getUnit()+"    ");
			           System.out.print(m.getUnitValue()+"    ");
			           System.out.print(m.getUnitPrice()+"    ");
			           System.out.println(m.getExpDate()+"    ");
			           System.out.print(m.getStockStatus()+"    ");
			      }
				request.setAttribute("list", medicineList);
				RequestDispatcher rd=request.getRequestDispatcher("List.jsp");  
					rd.forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
		}
		return true;
	} else {
		return false;

	}
  
	
}
	
	@Override
	 public String getById (HttpServletRequest request,
			HttpServletResponse response){
		Medicine medicine = new Medicine();
		medicine = pharmacyDAO.getById(request,response);
		
		request.setAttribute("medicine", medicine);
		RequestDispatcher rd=request.getRequestDispatcher("editMedicine.jsp");  
 	     
		try {
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return "edited";
	 }


	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		pharmacyDAO.update(request,response);
	}
}
