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

		HashMap<Integer, ArrayList<String>> gramItems=Grammar.getGram();
		
		// 开始时将$和S压入栈
		stack.push("$");
		stack.push("S");

		String X = stack.peek();
		int ip = 0;

		while (X != "$") {
			String nowToken=tokens.get(ip);
			if (nowToken.equals(X)) {
				stack.pop();
				ip++;
			} else if (Vt.contains(X)) {
				System.out.println("error");
				return;
			} else if (ppt.get(X).get(nowToken) == null) {
				System.out.println("error");
				return;
			} else {
				int num=ppt.get(X).get(nowToken);
				String gen = Grammar.getGrammar(num);
				System.out.println(gen);
				stack.pop();
				ArrayList<String> stackItems=gramItems.get(num);
				for (String item : stackItems) {
					if (!item.equals("e")) {
						stack.push(item);
					}
				}
			}
			X = stack.peek();
		}

		return;
	}

}
