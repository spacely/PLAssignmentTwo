//A Class that combines two sub commands together.

public class Combination extends Command {
  Command first;
  Command second;
  public Combination(Command first,Command second){
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean equals(Object o){
      if(this == o){
        return true;
      }
      if(o==null || getClass()!=o.getClass()){
        return false;
      }
      Combination comb = (Combination)o;
      if(!comb.equals(comb.first)){
        return false;
      }
    return second.equals(comb.second);
  }


}
