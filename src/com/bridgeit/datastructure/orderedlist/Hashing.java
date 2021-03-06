package com.bridgeit.datastructure.orderedlist;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

import com.Utilpack.Utility;
import com.bridgeit.datastructure.unorderedlist.LinkedList;
public class Hashing {
	public static LinkedList slot[] = new LinkedList[11];

	public static void main(String[] args) throws FileNotFoundException {
		String path = "/home/user/Downloads/JavaProgram/src/filehash.txt";
		for (int i = 0; i < 11; i++) {
			slot[i] = new LinkedList();
		}

		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			String str = br.readLine();

			System.out.println(str);

			String[] strA = str.split(" ");
			for (int i = 0; i < strA.length; i++) {
				int slotNum = hash(strA[i]);
				slot[slotNum].add(strA[i]);
				// System.out.print(slot[slotNum]);
			}

			System.out.println();

			for (int i = 0; i < 2; i++) {
				System.out.print(i + "==> ");
				slot[i].display();
			}
			System.out.println("Enter the String to search:");
			String key = Utility.getString();
			int slotNumber = hash(key);
			boolean value = slot[slotNumber].search(key);
			if (value) {
				System.out.println("\nElement found at slot " + slotNumber + " and deleted\n");
				slot[slotNumber].remove(key);
			} else {
				System.out.println("\nElement not found but added: " + key + " at slot " + slotNumber + "\n");
				slot[slotNumber].add(key);
			}

			System.out.println();
			for (int i = 0; i < 2; i++) {
				System.out.print(i + "==> ");
				slot[i].displayList();
			}

			String s = "";
			for (int i = 0; i < 2; i++) {
				s = s + slot[i].toString();
			}
			//System.out.println("New elements in file:\n" + s);
			//BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			//bw.write(s);

			//bw.close();
			br.close();
		} catch (IOException e) {
		    System.out.println("element is  inserted");
		}
	}

	public static int hash(String str) {
		int index = Integer.parseInt(str) % 11;

		return index;
	}

}
