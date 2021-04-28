
import java.util.ArrayList;
import java.util.StringTokenizer;

//Note: No Static methods. Otherwise, no credits.
public class Expression {

	/**
	 * The content of this expression
	 */
	private String infix;

	/**
	 * Constructs an empty infix String
	 */
	public Expression() {
		this.setInfix("");
	}

	/**
	 * Gets the context of the expression
	 * @return String value that is the context of the expression
	 */
	public String getInfix() {
		return infix;
	}

	/**
	 * Sets the context of the expression
	 * @param infix String value that is the context of the expression
	 */
	public void setInfix(String infix) {
		this.infix = infix;
	}

	/**
	 * Constructs an Expression with a given String
	 * @param infix The context of the expression
	 */
	public Expression(String infix) {
		this.setInfix(infix);
	}

	/**
	 * Converts this infix expression to an equivalent postfix expression
	 * @return A postfix expression as a list of tokens.
	 */
	public ArrayList<String> infixToPostfix() {
		ArrayList<String> postfix = new ArrayList<String>();
		GenericStack<String> stack = new GenericStack<String>();
		StringTokenizer tokens = new StringTokenizer(this.getInfix(), "+-*/()", true);
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (isOperand(token)) {
				postfix.add(token);
			} else if (token.equals("(")) {
				stack.push(token);
			} else if (token.equals(")")) {
				while (!"(".equals(stack.peek())) {
					postfix.add(stack.pop());
				}
				stack.pop();
			} else {
				if (stack.isEmpty()) {
					stack.push(token);
				} else {
					while (!"(".equals(stack.peek()) && !stack.isEmpty()) {
						if (getPrecedence(stack.peek().charAt(0)) >= getPrecedence(token.charAt(0))) {
							postfix.add(stack.pop());
						} else {
							break;
						}
					}
					stack.push(token);
				}
			}
		}
		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
		return postfix;
	}

	/**
	 * Invokes infixToPostfix to convert this infix expression to postfix and
	 * evaluates the postfix expression
	 * @return An integer which is the result of the evaluated postfix expression
	 */
	public int evaluate() {
		ArrayList<String> arr = this.infixToPostfix();
		GenericStack<String> stack = new GenericStack<String>();
		while(!arr.isEmpty()){
			if(isOperand(arr.get(0))){
				stack.push(arr.get(0));
				arr.remove(0);
			}else{
				int val2 = Integer.valueOf(stack.pop());
				int val1 = Integer.valueOf(stack.pop());
				switch(arr.remove(0)){
					case "+":
						stack.push(Integer.toString(val1+val2));
						break;
					case "-":
						stack.push(Integer.toString(val1-val2));
						break;
					case "*":
						stack.push(Integer.toString(val1*val2));	
						break;
					case "/":
						stack.push(Integer.toString(val1/val2));
						break;
					default:
						throw new IllegalArgumentException("Invalid operator");
				}
			}
		}
		return Integer.valueOf(stack.pop());
	}

	/**
	 * Returns whether a given string is an operand or not
	 * @param str A string that will be tested on whether it is an operand
	 * @return Boolean value on whether the string was an operand or not
	 */
	public boolean isOperand(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the precedence level of a given operator
	 * @param operator A char token of an operator
	 * @return An Integer which is the level of precedence for the given operator
	 */
	public int getPrecedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			throw new IllegalArgumentException("Unknown operator, please make sure you only use: + - / *");
		}
	}
}
