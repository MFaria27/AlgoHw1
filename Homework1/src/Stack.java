import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push (Item item) {
		if (N == a.length)
			resize(2*a.length);
		a[N++] = item;

	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && a.length / 4 == N) {
			resize(a.length/2);
		}
		return item;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item>{
		private int i = 0;
		@Override
		public boolean hasNext() {
			return i < a.length-1;
		}
		@Override
		public Item next() {
			return a[i++];
		}
		@Override
		public void remove() {

		}
	}

}
