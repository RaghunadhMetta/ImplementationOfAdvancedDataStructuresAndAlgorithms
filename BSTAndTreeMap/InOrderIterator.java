import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

// BST Iterator class

public class InOrderIterator<T> implements Iterator<T> {
	ArrayDeque<BST.Entry<T>> stack = new ArrayDeque<>();

	public InOrderIterator (BST.Entry<T> root) {
		populateStack(root);
	}

	public void populateStack(BST.Entry<T> node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public T next() {
		if (stack.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			BST.Entry<T> top = stack.pop();
			populateStack(top.right);
			return top.element;
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
