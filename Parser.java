/**
* A class that parses the grammar of While programming language
*
*Class will break input string into tokens
*
*
*/



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









}
