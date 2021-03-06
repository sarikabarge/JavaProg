package com.bridgeit.oops.commercialprogram;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LinkedList<T> {
	Node head; // declaring head node

	public class Node {
		T data;
		public Node next;
	}

	/**
	 * @param T : It takes generic data type as command line argument
	 * @purpose : This method is used to add String data to a Linked list
	 * @return : void
	 **/
	public void add(T data) {
		Node node = new Node(); // creating nodes
		node.data = data;// adding data

		if (head == null) {
			head = node; // make head as a first node
		} else {
			Node n = head;

			while (n.next != null) // take reference values
			{
				n = n.next; // changing reference values
			}
			n.next = node;
		}

	}

	/**
	 * @purpose : This method is used to display the data which is in linked list
	 *          object
	 * @return : void
	 **/

	public void display() {
		// making n as head node
		Node n = head;
		while (n.next != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println(n.data); // retrieving last element
	}

	/**
	 * @param T : It takes generic data type as command line argument
	 * @purpose : This method is used to search a specific element in a linkedlist
	 * @return : boolean
	 **/

	public boolean search(T word)

	{
		Node n = head; // making n as head node

		while (n.next != null)// next reference value
		{
			if (n.data.equals(word)) // comparing data with user search value
			{
				return true;
			}

			if (n.next == null) // checking last element of object
			{
				n.data.equals(word); // comparing data with user search value
				return true;
			}
			n = n.next;
		}
		return false;
	}

	/**
	 * @param T : It takes generic data type as command line arugument
	 * @purpose : This method is used to delete a specific element in a linkedlist
	 * @return : void
	 **/

	public void delete(T ele)

	{
		Node n = head;
		Node n1 = head;

		if (n.data.equals(ele)) // checking head element with user search element to delete
		{
			head = head.next; // changing reference value
		}
		while (n != null) {
			if (n.data.equals(ele)) // checking for the element in list
			{
				n1.next = n.next; // changing reference value
			}
			n1 = n;
			n = n.next;
		}
	}

	/**
	 * @param T : It takes generic data type as command line argument
	 * @purpose : This method is used to add element at first position of linkedlist
	 * @return : void
	 **/
	public void addFirst(T data) {
		Node node = new Node(); // creating object
		node.data = data; // adding data to first node
		node.next = head;
		head = node;

	}

	/**
	 * @purpose : This method is used to covert words in a list to string
	 * @return : string
	 **/

	public String getString() {
		String output = " ";
		Node n = head; // making n as head node

		while (n.next != null) {
			output += n.data + " "; // adding all values to output variable
			n = n.next;
		}
		output += n.data; // adding last element
		return output;
	}

	/**
	 * @purpose : This method is used delete element in frist in a list to
	 * @return : string
	 **/

	public T deletefirst() {
		T item;
		Node n = head;
		head = n.next;
		item = n.data;
		return item;
	}

	/**
	 * @purpose : This method is used to delete element at last in a list to T
	 * @return : T
	 **/

	public T deleteAtlast() {
		if (head == null)
			return null;
		else {
			Node n = head;
			Node prev = head;
			while (n.next != null) {
				prev = n;
				n = n.next;
			}

			T data = (T) n.data;
			prev.next = null;
			return data;
		}
	}

	/**
	 * @purpose : This method is used to add element at last in a list
	 * @return : T
	 **/
	public void insertAtLast(T data) {
		Node node = new Node();
		node.data = data;
		if (head == null) {
			head = node;
			node.next = null;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			node.next = null;
			n.next = node;
		}
	}

	/**
	 * @purpose : This method is used to get last element at last in a list
	 * @return : T
	 **/
	public T getlast() {
		Node temp = head;
		while (temp.next == null) {
			temp = temp.next;
		}
		System.out.println(temp.data + "Returning");
		return (T) temp.data;
	}

	/**
	 * @purpose : This method is used to check element in a list
	 * @return : boolean
	 **/
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * @purpose : This method is used to add element(STACK) in a list
	 * @return : T
	 **/

	public T push(T newData) {
		Node new_node = new Node();

		new_node.next = head;
		head = new_node;
		return newData;
	}
	public T print()
	{
		Node temp=head;

		while(temp!=null)
		{
			System.out.println(temp.data);

			temp=temp.next;	
		}		
		return null;

	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public T last(T data) {
		Node n = new Node();
		n.data = data;
		if (head == null) {
			head = n;
			n.next=null;
			return data;
		} else {
			n.next = null;
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = n;
		}
		return data;
	}
	
	/**
	 * @ purpose to write user details into file
	 */

	public void writeOnFile() {
		String frist = "";
		Node temp = head;
		while (temp != null) {
			frist = frist.trim() + " " + temp.data.toString().trim();
			temp = temp.next;
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/admin1/Desktop/first"))) {
			bw.write(frist);		
			bw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param key
	 */
	public void remove(String key) {
		if (isEmpty()) {
			System.out.println("can not delete empty list");
		} else {
			Node p, q;
			p = head;
			q = head;
			int count = 1;
			while (((String) p.data).compareTo(key) != 0) {
				p = p.next;
				count++;
				if (p.next == null) {
					break;
				}
			}
			if (((String) p.data).compareTo(key) == 0) {
				System.out.println("Element found at node " + count);
				if (count == 1) {
					head = p.next;
					p.next = null;
					System.out.println("Element deleted: " + p.data);
					count--;
				} else {
					while (q.next != p) {
						q = q.next;
					}
					q.next = p.next;
					p.next = null;
					System.out.println("\nElement deleted: " + p.data);
					count--;
				}
			}
		}
	}
}
