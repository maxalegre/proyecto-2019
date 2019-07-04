package uy.edu.ucu.jsonql2019;

import uy.edu.ucu.jsonql2019.parser.*;

import java.io.FileReader;
import java.util.Scanner;
import java_cup.runtime.*;

public class Driver {

	public static void parseFile(String file) throws Exception {
//		JSONQLParser parser = new JSONQLParser(new JSONQLLexer(new FileReader(file)));
//		Symbol result = parser.parse();
//		System.out.println(result.sym + ": " + result.value);
	}

	public static void main(String[] args) throws Exception {
		try {
			parseFile("input.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
