/**
*A class that handles variables 
*/


public class Variable extends Expression{
String name;

  public Variable(String name){
    this.name = name;

  }

  public boolean equals(Object o){
    if(this == o){
      return true;
    }
    if(o==null || getClass()!=o.getClass()){
      return false;
    }
    Variable that = (Variable)o;
    return name.equals(that.name);
  }


}
