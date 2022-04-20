package com.company.behavioral.interpreter;

/**
 * <b>Context</b> : Contains information that's global to the interpreter
 */

class Context{

    public int add(String input){
        String[] tokens = interpret(input);
        int num1 = Integer.valueOf(tokens[0]);
        int num2 = Integer.valueOf(tokens[1]);
        return (num1 + num2);
    }

    public int subtract(String input){
        String[] tokens = interpret(input);
        int num1 = Integer.valueOf(tokens[0]);
        int num2 = Integer.valueOf(tokens[1]);
        return (num1 - num2);
    }

    public int multiplication(String input){
        String[] tokens = interpret(input);
        int num1 = Integer.valueOf(tokens[0]);
        int num2 = Integer.valueOf(tokens[1]);
        return (num1 * num2);

    }

    private String[] interpret(String input){
        String str = input.replaceAll("[^0-9]", " ");
        str = str.replaceAll("( )+", " ").trim();
        return str.split(" ");
    }

}

/**
 * <b>Abstract Expression</b> : Declares an abstract Interpret operation that is common to all nodes in the abstract syntax tree
 */

interface Expression{
    int interpret(Context context);
}

class AddExpression implements Expression{

    private String expression;

    public AddExpression(String expression){
        this.expression = expression;
    }


    @Override
    public int interpret(Context context) {
        return context.add(expression);
    }
}

class SubtractExpression implements Expression{

    private String expression;

    public SubtractExpression (String expression){
        this.expression = expression;
    }

    @Override
    public int interpret(Context context) {
        return context.subtract(expression);
    }
}

class MultiplicationExpression implements Expression {

    private String expression;

    public MultiplicationExpression (String expression){
        this.expression = expression;
    }

    @Override
    public int interpret(Context context) {
        return context.multiplication(expression);
    }
}

public class InterpreterTest {

    public static void main(String[] args) {
        // write your code here

        System.out.println("1 cộng 1 = " + interpret("1 cộng 1"));

    }

    /**
     * <b>Client</b> : Builds an abstract syntax tree representing a particular sentence in the language
     * <p>taht the grammar defines. The abstract syntax tree is assembled from instance of the NonterminalExpression and TerminalExpression classes</p>
     * <p>Invokes the Interpret operation</p>
     * @param input
     * @return
     */

    private static int interpret(String input){
        if(input.contains("cộng")){
            Expression expression = new AddExpression(input);
            return expression.interpret(new Context());
        }else if(input.contains("trừ")){
            Expression expression = new SubtractExpression(input);
            return expression.interpret(new Context());
        }else if(input.contains("nhân")){
            Expression expression = new MultiplicationExpression(input);
            return expression.interpret(new Context());
        }

        throw new UnsupportedOperationException();

    }

}
