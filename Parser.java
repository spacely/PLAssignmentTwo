/**
* A class that parses the grammar of While programming language
*
*Class will break input string into tokens
*
*
*/

import java.util.*;
import java.lang.*;


public class Parser{

  private String expression;
  int position;

  public Parser(String expression){
    this.expression = expression;

  }

  // Handles white spaces within the expression.
  void consumeWhiteSpace(){
    while(position < expression.length() && Character.isWhitespace(expression.charAt(position))){
      position = position+1;
    }

  }

//This performs a consumption of tokens within the expression.
  void consumeToken(String token){
      consumeWhiteSpace();
      if(position + token.length() <= expression.length() && expression.substring(position,position + token.length()).equals(token)){
          position = position + token.length();

      }

  }

  boolean checkahead(String token){
      int start = position;
      boolean success;
      consumeToken(token);
      success = true;
      position = start;
      return success;

  }

  enum Operator{PLUS,MINUS,MULT,SUB}

/**
* Tracks expressions with operators
*
*/
  static class OperatorExpression{
    private Operator ops;
    Expression expression;

    public OperatorExpression(Operator ops,Expression expression){
      this.ops = ops;
      this.expression = expression;
    }




  }

//A concrete class which keeps a data structure that reflects the structure of the expression that has been tokenized.
//This consumes the smallest unit of the expression.
  Expression unit(){
    int start = position;
    Expression result;
    result = variable();
    position = start;
    consumeToken("(");
    result = expression();
    consumeToken(")");

    return result;


  }

  Variable variable(){
      consumeWhiteSpace();
      int start = position;
      while(position < expression.length() && (expression.charAt(position) >='a' && expression.charAt(position) <='z')){
        position++;
      }
      if(position > start){
        return new Variable(expression.substring(start,position));
      }
      return null;
  }


Expression parseIntegers(){
  consumeWhiteSpace();
  int start = position;
  boolean negative_sign = position < expression.length() && expression.charAt(position) == '-';
  if(negative_sign){
    position++;
  }
  boolean found_digits = false;
  //check for digists and start building
  while(position < expression.length() && Character.isDigit(expression.charAt(position) ) ){
    position++;
    found_digits = true;
  }

  if(found_digits){
    return new Int(Integer.parseInt(expression.substring(start,position)));
  }
  return null;
}


Operator operator(){
  consumeWhiteSpace();
  char next = 'x';
  if(position < expression.length()){
    next = expression.charAt(position);
    position++;
  }
  if(next == '+'){
    return Operator.PLUS;
  } else if(next == '-'){
    return Operator.MINUS;
  }else if(next == '*'){
    return Operator.MULT;
  }

  return null;
}


  boolean operators_test(){
    int start = position;
    boolean result = false;
    operator();
    result = true;
    position = start;
    return result;
  }


//A method to build the expression from parsed strings based on the input
  Expression expression(){
    Expression firstUnit = unit();

    List<OperatorExpression> AllUnits = new ArrayList<OperatorExpression>();

    while(operators_test()){
      Operator op = operator();
      Expression expr = unit();
      AllUnits.add(new OperatorExpression(op,expr));
    }
    Expression expr = firstUnit;
    for(OperatorExpression unit: AllUnits){
        switch(unit.ops){
          case PLUS:
          expr = new Addition(expr,unit.expression);
          break;
          case MINUS:
          expr = new Substraction(expr,unit.expression);
          break;
          case MULT:
          expr = new Multiplication(expr,unit.expression);
          break;

        }

    }


    return expr;
  }









}
