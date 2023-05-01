package com.bs.map.controller;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import com.bs.map.model.vo.*;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String, Member>();
	
	public boolean joinMembership(String id, Member memeber) {
		if(!map.containsKey(id)) {
			map.put(id, memeber);
			return true;
		} return false;
	}
	
	public String logIn(String id, String password) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(password)) {
			return map.get(id).getName();
		} return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(oldPw)) {
			map.get(id).setPassword(newPw);
			return true;
		} return false;
	}
	
	public void changeName(String id, String newName) {
		if(map.containsKey(id)) {
			map.get(id).setName(newName);
		}
	}
	
	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> mapTree = new TreeMap<String, String>();
		Set<String> keys = map.keySet();
		
		for(String k : keys) {
			if(map.get(k).getName().equals(name)) {
				mapTree.put(k, map.get(k).getName());
			}
		}
		
		return mapTree;
	}
}
