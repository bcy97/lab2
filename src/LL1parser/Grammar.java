package LL1parser;

import java.util.ArrayList;
import java.util.HashMap;

public class Grammar {

	public static String getGrammar(int i) {
		String[] grammars = { "S->id=E;S", "S->if(C){S}else{S}S", "S->e", "E->TE'", "E'->+TE'", "E'->e", "T->FT'",
				"T'->*FT'", "T'->e", "F->(E)", "F->id", "F->number", "C->DC'", "C'->||DC'", "C'->e", "D->(C)",
				"D->id==number" };

		return grammars[i];
	}
	
	public static HashMap<Integer, ArrayList<String>> getGram(){
		HashMap<Integer, ArrayList<String>> grammars=new HashMap<>();
		ArrayList<String> item1=new ArrayList<>();
		item1.add("id");
		item1.add("=");
		item1.add("E");
		item1.add(";");
		item1.add("S");
		grammars.put(0, item1);
		ArrayList<String> item2=new ArrayList<>();
		item2.add("id");
		item2.add("=");
		item2.add("E");
		item2.add(";");
		item2.add("S");
		grammars.put(0, item2);
		ArrayList<String> item3=new ArrayList<>();
		item3.add("id");
		item3.add("=");
		item3.add("E");
		item3.add(";");
		item3.add("S");
		grammars.put(0, item3);
		ArrayList<String> item4=new ArrayList<>();
		item4.add("id");
		item4.add("=");
		item4.add("E");
		item4.add(";");
		item4.add("S");
		grammars.put(0, item4);
		ArrayList<String> item5=new ArrayList<>();
		item1.add("id");
		item1.add("=");
		item1.add("E");
		item1.add(";");
		item1.add("S");
		grammars.put(0, item1);
		ArrayList<String> item6=new ArrayList<>();
		item1.add("id");
		item1.add("=");
		item1.add("E");
		item1.add(";");
		item1.add("S");
		grammars.put(0, item1);
		ArrayList<String> item7=new ArrayList<>();
		item1.add("id");
		item1.add("=");
		item1.add("E");
		item1.add(";");
		item1.add("S");
		grammars.put(0, item1);
		ArrayList<String> item8=new ArrayList<>();
		item1.add("id");
		item1.add("=");
		item1.add("E");
		item1.add(";");
		item1.add("S");
		grammars.put(0, item1);
		return null;
	}

	public static ArrayList<String> getTerminal() {
		
		ArrayList<String> Vt = new ArrayList<>();
		Vt.add("id");
		Vt.add("if");
		Vt.add("+");
		Vt.add("*");
		Vt.add("(");
		Vt.add(")");
		Vt.add("{");
		Vt.add("}");
		Vt.add("else");
		Vt.add("number");
		Vt.add("||");
		Vt.add("==");
		Vt.add(";");
		Vt.add("$");
		
		return Vt;
	}
	
public static ArrayList<String> getNoTerminal() {
		
		ArrayList<String> Vn = new ArrayList<>();
		Vn.add("S");
		Vn.add("E");
		Vn.add("E'");
		Vn.add("T");
		Vn.add("T'");
		Vn.add("F");
		Vn.add("C'");
		Vn.add("C");
		Vn.add("D");
		
		return Vn;
	}

}
