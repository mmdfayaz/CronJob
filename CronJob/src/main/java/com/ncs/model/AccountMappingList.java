package com.ncs.model;

import java.util.ArrayList;
import java.util.List;

public class AccountMappingList {
	private List<AccountMapping> obj;
	AccountMappingList(){
		obj=new ArrayList<AccountMapping>();
	}
	public List<AccountMapping> getObj() {
		return obj;
	}
	public void setObj(List<AccountMapping> obj) {
		this.obj = obj;
	}
}
