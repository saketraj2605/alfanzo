package com.cts.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PharmacyService {
boolean validate(HttpServletRequest request, HttpServletResponse response);
public String getById (HttpServletRequest request,
		HttpServletResponse response);
public void update(HttpServletRequest request,HttpServletResponse response);
}
