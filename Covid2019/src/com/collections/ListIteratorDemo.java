package com.collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo 
{

	public static void main(String[] args) 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.add("oracle");
		l.add("oaktech");
		l.add("carrier");
		l.add("bi-labs");
		
		System.out.println(l);
		
		ListIterator<String> var = l.listIterator();
		while(var.hasNext())
		{
			String val = var.next();
			if(val.equals("oracle"))
				var.set("colabra consultansing");
			else
				var.remove();
		}
		System.out.println(l);
	}

}
