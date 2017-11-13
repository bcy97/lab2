package lex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import dfa.DFA;
import dfa.DFABulider;
import dfa.DFANode;
import dfa.MinimizeDFA;
import nfa.NFA;
import nfa.NFABuilder;

public class LEX {

	public static ArrayList<String> getTokens() {

		HashMap<String, DFA> dfas = init();

		File inFile = new File(System.getProperty("user.dir") + "/file/input.txt");

		ArrayList<String> tokens = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inFile));
			String string = reader.readLine();

			// 不停的读入字�?
			while (string != null) {
				String[] strs = string.split(" ");

				for (String str : strs) {
					if (str.equals("")) {
						continue;
					}
					String result = judgeToken(str, dfas);
					tokens.add(result);
				}

				string = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tokens;

	}

	public static HashMap<String, DFA> init() {

		HashMap<String, DFA> dfas = new HashMap<>();

		ArrayList<String> reStrings = new ArrayList<>();
		ArrayList<String> tokens = new ArrayList<>();
		File file = new File(System.getProperty("user.dir") + "/file/re.txt");

		String s = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while (!(s = reader.readLine()).equals("end")) {

				String[] token = s.split(" ");

				tokens.add(token[0]);
				reStrings.add(token[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < reStrings.size(); i++) {

			NFABuilder nfaBuilder = new NFABuilder();
			NFA nfa = nfaBuilder.createNFA(reStrings.get(i));

			DFABulider bulider = new DFABulider();
			DFA dfa = bulider.createDFA(nfa);

			MinimizeDFA minimize = new MinimizeDFA();
			DFA minDfa = minimize.minimizeDFA(dfa);

			dfas.put(tokens.get(i), minDfa);

		}

		return dfas;

	}

	public static String judgeToken(String string, HashMap<String, DFA> dfas) {

		// 先判断是否有保留�?
		DFA dfa = dfas.get("reserve");
		if (dfa != null) {
			// 从dfa的初状�?�开�?
			DFANode state = dfa.getStartNodes().get(0);
			int i = 0;
			for (i = 0; i < string.length(); i++) {
				DFANode node = state.getNextDFA(string.charAt(i));
				if (node != null) {
					state = node;
				} else {
					break;
				}
			}
			if (i == string.length() && dfa.getEndNodes().contains(state)) {
				return "reserve," + string;
			}
		}

		// 遍历�?有的dfa，寻找匹配的dfa
		for (String token : dfas.keySet()) {

			// 判断是否为保留字
			String newString = string;
			newString = CharHandler.change(string);

			dfa = dfas.get(token);

			// 从dfa的初状�?�开�?
			DFANode state = dfa.getStartNodes().get(0);
			int i = 0;
			for (i = 0; i < newString.length(); i++) {
				DFANode node = state.getNextDFA(newString.charAt(i));
				if (node != null) {
					state = node;
				} else {
					break;
				}
			}
			if (i == string.length() && dfa.getEndNodes().contains(state)) {
				// System.out.println(string + " " + token);
				return token + "," + string;
			}
		}

		return "null," + string;
	}
}
