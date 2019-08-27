package com.sts3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	// @Autowired : setter 기능 대행
	@Autowired
	public Chef chef = null;
}
