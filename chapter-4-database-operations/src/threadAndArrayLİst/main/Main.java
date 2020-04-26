package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import management.lists.ListOperation;


public class Main {

	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {

		ListOperation.createList(list);

		List<Integer> list1 = list.subList(0, 2500);
		Collections.sort(list1);
		System.out.println("List 1 :" + list1);
		List<Integer> list2 = list.subList(2501, 5000);
		Collections.sort(list2);
		System.out.println("List 2 :" + list2);
		List<Integer> list3 = list.subList(5001, 7500);
		Collections.sort(list3);
		System.out.println("List 3 :" + list3);
		List<Integer> list4 = list.subList(7501, 10000);
		Collections.sort(list4);
		System.out.println("List 4 :" + list4);

		ListOperation listop1 = new ListOperation(list1);
		ListOperation listop2 = new ListOperation(list2);
		ListOperation listop3 = new ListOperation(list3);
		ListOperation listop4 = new ListOperation(list4);

		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.execute(listop1);
		executor.execute(listop2);
		executor.execute(listop3);
		executor.execute(listop4);

		List<Integer> evenList = new ArrayList<Integer>();
		evenList = listop1.getEvenList();
		evenList.addAll(listop2.getEvenList());
		evenList.addAll(listop3.getEvenList());
		evenList.addAll(listop4.getEvenList());
		System.out.println("Even List: " + evenList);

		List<Integer> oddList = new ArrayList<Integer>();
		oddList = listop1.getOddList();
		oddList.addAll(listop2.getOddList());
		oddList.addAll(listop3.getOddList());
		oddList.addAll(listop4.getOddList());
		System.out.println("Odd List: " + oddList);
	}

}
