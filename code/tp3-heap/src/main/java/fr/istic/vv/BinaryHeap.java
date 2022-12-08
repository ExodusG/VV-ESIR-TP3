package fr.istic.vv;

import java.util.Comparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class BinaryHeap<T> {

	private Comparator<T> cmp;

	private ArrayList<T> list;
	public BinaryHeap(Comparator<T> comparator) {
		if(comparator ==null) throw new IllegalArgumentException("comparator is null");
		this.cmp=comparator;
		this.list=new ArrayList<T>();
	}

    public T pop() {
    	if(this.list.isEmpty()) throw new NoSuchElementException("the heap is Empty");
    	T out=this.list.get(0);
    	T last=this.list.remove(this.list.size() -1);
    	if(!this.list.isEmpty()) {
    		this.list.set(0, last);
        	monter(0);
    	}

    	return out;
    }

    private void monter(int i){
	    int smallest = i; // Initialize smallest as root
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;


	    if (left < this.list.size() && cmp.compare(this.list.get(left), this.list.get(smallest))<0) {
	    	smallest = left;
	    }


	    if (right < this.list.size() && cmp.compare(this.list.get(right), this.list.get(smallest))<0) {
	    	smallest= right;
	    }

	    if (smallest != i) {
		   T swap = this.list.get(i);
		   this.list.set(i, this.list.get(smallest));
		   this.list.set(smallest, swap);
		   this.monter(smallest);
	    }
    }

    public T peek() {
    	if(this.list.isEmpty()) throw new NoSuchElementException("the heap is Empty");
    	return this.list.get(0);
    }

    public void push(T element) {

    	int index=this.list.size();
    	this.list.add(element);

    	while(cmp.compare(this.list.get((index-1)/2), element)>0) {
    		int parent=(index -1)/2;
    		T tmp=this.list.get(parent);
    		this.list.set(parent, this.list.get(index));
    		this.list.set(index, tmp);
    		index=parent;
    	}
    }


    public T get(int index) {
    	T t=null;
    	if(index >-1 && index<this.list.size()) {
    		t=this.list.get(index);
    	}
    	return t;
    }

}
