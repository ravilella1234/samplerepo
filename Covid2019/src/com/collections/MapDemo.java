package com.collections;

import java.util.Set;
import java.util.TreeMap;

public class MapDemo 
{

	public static void main(String[] args) 
	{
		//HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		//LinkedHashMap<Integer, Integer> h = new LinkedHashMap<Integer, Integer>();
		TreeMap<Integer, Integer> h = new TreeMap<Integer, Integer>();
		
		h.put(100, 100);
		h.put(120, 200);
		h.put(30, 300);
		h.put(5, 400);
		h.put(10, 200);
		
		System.out.println(h);
		System.out.println(h.get(20));
		
		Set<Integer> keys = h.keySet();
		
		for(Integer key : keys)
		{
			System.out.println(key + "---" + h.get(key));
		}
		
		h.clear();
		System.out.println(h);

	}

}
