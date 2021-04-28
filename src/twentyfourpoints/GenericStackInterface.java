

/**
 * Specifications on the desgin of the operations of the ADT Stack
 * @author Adam Khoukhi
 * @version 1.0
 */
public interface GenericStackInterface<E>{
	/**
	 * Returns the number of objects of this stack
	 * @return integer of the number of objects in the stack
	 */
	public int getSize();

	/**
	 * Returns a reference to the top element of this stack
	 * @return E that is the reference to the top element
	 * @throws StackException Thrown when their is a stack underflow
	 */
	public E peek() throws StackException;

	/**
	 * Adds an object to the top of this stack
	 * @param object A reference to the element to be added
	 */
	public void push(E object);

	/**
	 * Removes from the top of this stack
	 * @return E a reference to the element that is removed
	 * @throws StackException Thrown when their is a stack underflow
	 */
	public E pop() throws StackException;	

	/**
	 * Indicates whether this stack is empty
	 * @return A boolean value of whether the stack is empty or not
	 */
	public boolean isEmpty();
}
