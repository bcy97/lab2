package LL1parser;

import java.util.HashMap;

public class PPT {

	public static HashMap<String, HashMap<String, Integer>> createPPT() {

		HashMap<String, HashMap<String, Integer>> PPT = new HashMap<>();

		HashMap<String, Integer> SItem = new HashMap<>();
		SItem.put("id", 0);
		SItem.put("if", 1);
		SItem.put("$", 2);
		PPT.put("S", SItem);
		
		HashMap<String, Integer> EItem = new HashMap<>();
		EItem.put("id", 3);
		EItem.put("(", 3);
		EItem.put("number", 3);
		PPT.put("E", EItem);
		
		HashMap<String, Integer> E_Item = new HashMap<>();
		E_Item.put("+", 4);
		E_Item.put(")", 5);
		E_Item.put(";", 5);
		PPT.put("E'", E_Item);
		
		HashMap<String, Integer> TItem = new HashMap<>();
		TItem.put("id", 6);
		TItem.put("(", 6);
		TItem.put("number", 6);
		PPT.put("T", TItem);
		
		HashMap<String, Integer> T_Item = new HashMap<>();
		T_Item.put("+", 8);
		T_Item.put("*", 7);
		T_Item.put(")", 8);
		T_Item.put(";", 8);
		PPT.put("T'", T_Item);
		
		HashMap<String, Integer> FItem = new HashMap<>();
		FItem.put("id", 10);
		FItem.put("(", 9);
		FItem.put("number", 11);
		PPT.put("F", FItem);
		
		HashMap<String, Integer> CItem = new HashMap<>();
		CItem.put("id", 12);
		CItem.put("(", 12);
		PPT.put("C", CItem);
		
		HashMap<String, Integer> C_Item = new HashMap<>();
		C_Item.put("||", 13);
		C_Item.put(")", 14);
		PPT.put("C'", C_Item);
		
		HashMap<String, Integer> DItem = new HashMap<>();
		DItem.put("id", 16);
		DItem.put("(", 15);
		PPT.put("D", DItem);

		return PPT;

	}
}
