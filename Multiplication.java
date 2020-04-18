//An expression composition that handles adding two values
// within an expression

public class Multiplication extends Expression{
  Expression first;
  Expression second;

  public Multiplication(Expression first, Expression second){
    this.first = first;
    this.second = second;
  }

  //over riding of the default object method to do comparison of two things.
  //We compare the class of the object and use it for assignment operators in general.
 @Override
  public boolean equals(Object o){
    if(o == this) {
      return true;
    }
    if(o == null || getClass()!= o.getClass()) {
      return false;
    }

    Multiplication mult = (Multiplication)o; //cash incoming object to Type of Addition
    if(!first.equals(mult.first) ){
      return false;
    }

    return second.equals(mult.second);
  }




}
