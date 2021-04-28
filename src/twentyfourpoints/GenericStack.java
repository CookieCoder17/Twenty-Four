
import java.util.ArrayList;

/**
 * Implements the GenericStack Interface
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class GenericStack<E> implements GenericStackInterface<E> {

	/**
	 * The list of objects of this stack
	 */
	private java.util.ArrayList<E> list;

	/**
	 * Constructs an empty stack
	 */
	public GenericStack() {
		list = new ArrayList<E>();
	}

	/**
	 * Returns the number of objects of this stack
	 * 
	 * @return integer of the number of objects in the stack
	 */
	public int getSize() {
		return list.size();
	}

	/**
	 * Returns a reference to the top element of this stack
	 * @return E that is the reference to the top element
	 * @throws StackException Thrown when their is a stack underflow
	 */
	public E peek() throws StackException {
		if (!this.isEmpty()) {
			return list.get(list.size() - 1);
		} else {
			throw new StackException("Stack Underflow: Stack is empty!");
		}

	}

	/**
	 * Adds an object to the top of this stack
	 * 
	 * @param object A reference to the element to be added
	 */
	public void push(E object) {
		list.add(object);

	}

	/**
	 * Removes from the top of this stack
	 * @return E a reference to the element that is removed
	 * @throws StackException Thrown when their is a stack underflow
	 */
	public E pop() throws StackException {
		if (!this.isEmpty()) {
			return list.remove(list.size() - 1);
		} else {
			throw new StackException("Stack Underflow: Stack is empty!");
		}
	}

	/**
	 * Indicates whether this stack is empty
	 * 
	 * @return A boolean value of whether the stack is empty or not
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
