package management.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOperation implements Runnable {

	private Object LOCK = new Object();

	private List<Integer> list;
	volatile List<Integer> oddList;
	volatile List<Integer> evenList;

	public ListOperation() {

	}

	public ListOperation(List<Integer> list) {
		this.list = list;
		this.oddList = new ArrayList<>();
		this.evenList = new ArrayList<>();
	}

	public static void createList(List<Integer> list) {

		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}

		System.out.println("List :" + list);

	}

	public void OddorEvenList(List<Integer> list1) {

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) % 2 == 0) {
				evenList.add(list1.get(i));
			} else {
				oddList.add(list1.get(i));
			}

		}

		Collections.sort(evenList);
		Collections.sort(oddList);

	}

	public List<Integer> getOddList() {
		return oddList;
	}

	public List<Integer> getEvenList() {
		return evenList;
	}

	public void setOddList(List<Integer> oddList) {
		this.oddList = oddList;
	}

	public void setEvenList(List<Integer> evenList) {
		this.evenList = evenList;
	}

	@Override
	public void run() {
		synchronized (LOCK) {
			System.out.println(Thread.currentThread().getName());
			OddorEvenList(this.list);

		}

	}

}
