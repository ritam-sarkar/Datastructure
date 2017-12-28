package com.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMapByValue {

	public static void main(String[] args) {
		HashMap<String,String> hm=new HashMap<>();
		hm.put("1", "23");
		hm.put("2", "32");
		hm.put("3", "26");
		Set<Entry<String, String>> e=hm.entrySet();
		List<Entry<String,String>> l=new ArrayList<>(e);
		Collections.sort(l,new Comparator<Entry<String,String>>(){

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				
				return o1.getValue().compareTo(o2.getValue());
			}});
		HashMap<String,String> sortedhm=new LinkedHashMap();
		for(Entry<String,String> ee: l){
			sortedhm.put(ee.getKey(),ee.getValue());
			
		}
		System.out.println(sortedhm);
		

	}

}
