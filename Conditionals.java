//A Class that combines two sub commands together.

public class Conditionals extends Command {
  private Expression ACondition;
  private Command thenphase;
  private Command elsephase;

  public Conditionals(Expression ACondition,Command thenphase,Command elsephase){
    this.ACondition = ACondition;
    this.thenphase = thenphase;
    this.elsephase = elsephase;
  }

  @Override
  public boolean equals(Object o){
      if(this == o){
        return true;
      }
      if(o==null || getClass()!=o.getClass()){
        return false;
      }
      Conditionals comb = (Conditionals)o;
      if(!thenphase.equals(comb.thenphase)){
        return false;
      }
      if(!ACondition.equals(comb.ACondition)){
        return false;
      }
    return elsephase.equals(comb.elsephase);
  }


}
