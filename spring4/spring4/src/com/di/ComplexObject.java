package com.di;

import java.util.Map;

public class ComplexObject {
	private Map<String, Object> someMap = null;

	public void setSomeMap(Map<String, Object> someMap) {
		this.someMap = someMap;
	}
	
	public Map<String, Object> COMap() {
		return someMap;
	}
}
