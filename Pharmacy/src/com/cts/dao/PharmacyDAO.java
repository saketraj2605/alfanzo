package com.cts.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.model.Medicine;



public interface PharmacyDAO {
	void connect() throws SQLException;
	boolean validate(HttpServletRequest request, HttpServletResponse response);
    List<Medicine> listAllMedicine() throws SQLException;
    Medicine getById(HttpServletRequest request, HttpServletResponse response);
    public void update(HttpServletRequest request,HttpServletResponse response);
}
