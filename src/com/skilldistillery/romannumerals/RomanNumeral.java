package com.skilldistillery.romannumerals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RomanNumeral {

	static Scanner kb = new Scanner(System.in);
	Map<Integer, String> numerals = new HashMap<>();
	List<Integer> keys = new ArrayList<>();
	int newNum;

	public static void main(String[] args) {
		RomanNumeral rn = new RomanNumeral();
		rn.run();
	}

	private void run() {

		numerals.put(1, "I");
		numerals.put(4, "IV");
		numerals.put(5, "V");
		numerals.put(9, "IX");
		numerals.put(10, "X");
		numerals.put(40, "XL");
		numerals.put(50, "L");
		numerals.put(90, "XC");
		numerals.put(100, "C");
		numerals.put(400, "CD");
		numerals.put(500, "D");
		numerals.put(900, "CM");
		numerals.put(1000, "M");
		numerals.put(4000, "IV_");
		numerals.put(5000, "V_");
		numerals.put(9000, "IX_");
		numerals.put(10000, "X̅");
		numerals.put(40000, "XL_");
		numerals.put(50000, "L_");
		numerals.put(90000, "XC_");
		numerals.put(100000, "C_");
		numerals.put(400000, "CD_");
		numerals.put(500000, "D_");
		numerals.put(900000, "CM_");
		numerals.put(1000000, "M_");

		getKeys();

		System.out.print("Please enter a number between 1 and 1_000_000: ");
		int num = kb.nextInt();
		convertNumeral(num, "");
	}

	private void getKeys() {
		Set<Integer> s = numerals.keySet();
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			keys.add(it.next());
		}
		Collections.sort(keys);
	}

	private void convertNumeral(int num, String val) {
		int decX = num;
		newNum = 0;
		String numeral = val;
		for (int i = 0; i < keys.size(); i++) {
			if (keys.get(i) == decX) {
				numeral += numerals.get(keys.get(i));
				System.out.println("The roman numeral is " + numeral);
			} else if (keys.get(i) > decX) {
				numeral += numerals.get(keys.get(i - 1));
				newNum = num - keys.get(i - 1);
				if (newNum <= 0) {
					return;
				} else if (newNum == 1) {
					numeral += numerals.get(keys.get(0));
					System.out.println("The roman numeral is " + numeral);
					return;
				} else {
					convertNumeral(newNum, numeral);
					return;
				}
			}
		}
		return;
	}
}
