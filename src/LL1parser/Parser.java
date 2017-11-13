package LL1parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import LL1parser.PPT;
import lex.LEX;

public class Parser {

	public static void main(String[] args) {

		// 初始化已经计算好的PPT
		HashMap<String, HashMap<String, Integer>> ppt = PPT.createPPT();

		// 获取token
		ArrayList<String> tokens = LEX.getTokens();
		
		grammarParse(tokens, ppt);

	}

	public static void grammarParse(ArrayList<String> tokens, HashMap<String, HashMap<String, Integer>> ppt) {

		// 初始化stack存放状态
		Stack<String> stack = new Stack<>();

		ArrayList<String> Vt = Grammar.getTerminal();
		ArrayList<String> Vn = Grammar.getNoTerminal();

		// 开始时将$和S压入栈
		stack.push("$");
		stack.push("S");

		String X = stack.peek();
		int ip = 0;

		while (X != "$") {
			if (tokens.get(ip) == X) {
				stack.pop();
				ip++;
			} else if (Vt.contains(X)) {
				System.out.println("error");
				return;
			} else if (ppt.get(X).get(tokens.get(ip)) == null) {
				System.out.println("error");
				return;
			} else {
				String gen = Grammar.getGrammar(ppt.get(X).get(tokens.get(ip)));
				System.out.println(gen);
				stack.pop();
				
			}
			X = stack.peek();
		}

		return;
	}

}
