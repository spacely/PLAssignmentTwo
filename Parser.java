/**
* A class that parses the grammar of While programming language
*
*
*
*
*/



public Class Parser{

  private String expression;
  int position;

  public Parser(String expression){
    this.expression = expression;

  }

  // Handles white spaces within the expression.
  void consumeWhiteSpace(){
    while(position < expression.length() && Character.isWhilespace(expression.charAt(position))){
      position = position+1;
    }

  }

//This performs a consumption of tokens within the expression.
  void consumeToken(String token){
      consumeWhiteSpace();
      if(position + token.length() <= expression.length() && expression.substring(position,position + token.length()).equals(token)){
          position = position.token.length();

      }

  }

  boolean checkahead(string token){
      int start = position;
      boolean success;
      consumeToken(token);
      success = true;
      position = start;
      return success;

  }

  





}
