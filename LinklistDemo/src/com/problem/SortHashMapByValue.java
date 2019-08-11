package com.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortHashMapByValue {

	public static void main(String[] args) {
		Map<String,String> hm=new HashMap<>();
		hm.put("1", "23");
		hm.put("2", "32");
		hm.put("3", "26");
		Set<Entry<String, String>> e=hm.entrySet();
		Function<Map.Entry<String, String>, String> keyMapper = (e1)->e1.getKey();
		Function <Map.Entry<String, String>, String> valueMapper = (e2)->e2.getValue();
		Set<Entry<String, String>> sortedEntrySet  = e.stream().sorted((e1,e2)->e1.getValue().compareTo(e2.getValue())).collect(Collectors.toSet());
		sortedEntrySet.stream().forEach((x)->System.out.println(x.getValue()));
		
		
		

	}

}
