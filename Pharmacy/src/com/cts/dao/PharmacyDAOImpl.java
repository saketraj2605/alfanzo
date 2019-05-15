package com.cts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.model.Login;
import com.cts.model.Medicine;

public class PharmacyDAOImpl implements PharmacyDAO {
	
	private String jdbcDriver;	
	private String jdbcPassword;
	 private String jdbcURL;
	 private String jdbcUsername;
	 Connection jdbcConnection = null;

	public PharmacyDAOImpl() {
		super();
		
	
	}
	
	
	public PharmacyDAOImpl(String jdbcDriver, String jdbcUsername, String jdbcPassword, String jdbcURL) {
		
		this.jdbcDriver = jdbcDriver;
		this.jdbcPassword = jdbcPassword;
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
	}
	
	
	@Override
	public void connect() throws SQLException {
		try {
	
		if(jdbcConnection == null || jdbcConnection.isClosed()){
				Class.forName("com.mysql.jdbc.Driver");
				jdbcConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","root");
				
			}
		}  catch (ClassNotFoundException e) {
				System.out.println(" Driver not");
				e.printStackTrace();
			}
	}

	@Override
	public boolean validate(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			String uname = (String)request.getParameter("uname");
			String pswd =  (String)request.getParameter("psw");
			System.out.println(uname);
			System.out.println(pswd);

			connect();
			String getLoginQuery = "select * from login";
			PreparedStatement ps= jdbcConnection.prepareStatement(getLoginQuery);
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				Login login = new Login();
				login.setUserId(rs.getInt("user_id"));
				login.setUserName(rs.getString("user_name"));
				login.setPassword(rs.getString("user_password"));
				login.setRole(rs.getString("user_role"));
				System.out.println(login.getUserName());
				System.out.println(login.getPassword());

				if(login.getUserName().equals(uname) && login.getPassword().equals(pswd)){
					request.setAttribute("user", login);
					System.out.println("inside if");
					return true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public ArrayList<Medicine> listAllMedicine() throws SQLException {
		ArrayList<Medicine> medicineList= new ArrayList<>();
		try{
				connect();
				String getBookQuery = "select * from medicine";
				PreparedStatement ps= jdbcConnection.prepareStatement(getBookQuery);
				ResultSet rs = ps.executeQuery();
				System.out.println(jdbcConnection);
				
				while(rs.next()) {
					Medicine medicine = new Medicine();
					medicine.setId(rs.getInt("medicine_id"));
					medicine.setName(rs.getString("medicine_name"));
					medicine.setType(rs.getString("medicine_type"));
					medicine.setUnit(rs.getString("medicine_unit"));
					medicine.setUnitValue(rs.getString("medicine_unit_value"));
					medicine.setUnitPrice(rs.getInt("medicine_unit_price"));
					medicine.setExpDate(rs.getDate("medicine_expiry"));
					medicine.setStockStatus(rs.getString("medicine_stock"));
					medicineList.add(medicine);
				}
		} catch (SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return medicineList;
	
	}


	@Override
	public Medicine getById(HttpServletRequest request,
			HttpServletResponse response) {
		Medicine medicine = new Medicine();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			
			connect();
		String getMedicineByIdQuery = "select * from medicine where medicine_id=?";
		java.sql.PreparedStatement ps = jdbcConnection.prepareStatement(getMedicineByIdQuery);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			medicine.setId(Integer.parseInt(rs.getString("medicine_id")));
			medicine.setName(rs.getString("medicine_name"));
			medicine.setType(rs.getString("medicine_type"));
			medicine.setUnit(rs.getString("medicine_unit"));
			medicine.setUnitValue(rs.getString("medicine_unit_value"));
			medicine.setUnitPrice(rs.getInt("medicine_unit_price"));
			medicine.setExpDate(rs.getDate("medicine_expiry"));
			medicine.setStockStatus(rs.getString("medicine_stock"));
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicine;
	}


	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			connect();
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("+++++++++++++++++"+id);
		String name = (String)request.getParameter("name");
		String type = (String)request.getParameter("type");
		String unit = (String)request.getParameter("unit");
		String unit_value = (String)request.getParameter("unitValue");
		int price = Integer.parseInt(request.getParameter("price"));
		SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date sqlStartDate = simpledate.parse(request.getParameter("expiryDate"));
		java.sql.Date expiry_Date = new java.sql.Date(sqlStartDate.getTime());  
		String stock = (String)request.getParameter("inStock");
		
		String getMedicineByIdQuery = "update medicine set medicine_name=?,medicine_type=?,medicine_unit=?,medicine_unit_value=?,medicine_unit_price=?,medicine_expiry=?,medicine_stock=? where medicine_id=?";
		
		java.sql.PreparedStatement ps = jdbcConnection.prepareStatement(getMedicineByIdQuery);
		ps.setInt(1,id);
		ps.setString(2,type);
		ps.setString(3, unit);
		ps.setString(4,unit_value);
		ps.setInt(5, price);
		ps.setDate(6, expiry_Date);
		ps.setString(7, stock);
		ps.setInt(8,id);
		ResultSet rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}










