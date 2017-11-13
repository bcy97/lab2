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
		item1.add("S");
		item1.add(";");
		item1.add("E");
		item1.add("=");
		item1.add("id");
		grammars.put(0, item1);
		ArrayList<String> item2=new ArrayList<>();
		item2.add("S");
		item2.add("}");
		item2.add("S");
		item2.add("{");
		item2.add("else");
		item2.add("}");
		item2.add("S");
		item2.add("{");
		item2.add(")");
		item2.add("C");
		item2.add("(");
		item2.add("if");
		grammars.put(1, item2);
		ArrayList<String> item3=new ArrayList<>();
		item3.add("e");
		grammars.put(2, item3);
		ArrayList<String> item4=new ArrayList<>();
		item4.add("E'");
		item4.add("T");
		grammars.put(3, item4);
		ArrayList<String> item5=new ArrayList<>();
		item5.add("E'");
		item5.add("T");
		item5.add("+");
		grammars.put(4, item5);
		ArrayList<String> item6=new ArrayList<>();
		item6.add("e");
		grammars.put(5, item6);
		ArrayList<String> item7=new ArrayList<>();
		item7.add("T'");
		item7.add("F");
		grammars.put(6, item7);
		ArrayList<String> item8=new ArrayList<>();
		item8.add("T'");
		item8.add("F");
		item8.add("*");
		grammars.put(7, item8);
		ArrayList<String> item9=new ArrayList<>();
		item9.add("e");
		grammars.put(8, item9);
		ArrayList<String> item10=new ArrayList<>();
		item10.add(")");
		item10.add("E");
		item10.add("(");
		grammars.put(9, item10);
		ArrayList<String> item11=new ArrayList<>();
		item11.add("id");
		grammars.put(10, item11);
		ArrayList<String> item12=new ArrayList<>();
		item12.add("number");
		grammars.put(11, item12);
		ArrayList<String> item13=new ArrayList<>();
		item13.add("C'");
		item13.add("D");
		grammars.put(12, item13);
		ArrayList<String> item14=new ArrayList<>();
		item14.add("C'");
		item14.add("D");
		item14.add("||");
		grammars.put(13, item14);
		ArrayList<String> item15=new ArrayList<>();
		item15.add("e");
		grammars.put(14, item15);
		ArrayList<String> item16=new ArrayList<>();
		item16.add(")");
		item16.add("C");
		item16.add("(");
		grammars.put(15, item16);
		ArrayList<String> item17=new ArrayList<>();
		item17.add("number");
		item17.add("==");
		item17.add("id");
		grammars.put(16, item17);
		
		
		return grammars;
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
