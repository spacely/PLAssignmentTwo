

public class Int extends Expression{
  private int val;

  public Int(int val){
  this.val = val;
  }

@Override
public boolean equals(Object o){
  if(this == o){
    return true;
  }
  if(o == null || getClass()!=o.getClass()){
    return false;
  }
  Int integer = (Int)o;
  return val == integer.val;
}


}
