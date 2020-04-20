
//A Structure that holds Loop expressions.
public class Loop extends Command{
public Expression expr;
public Command command;

  public Loop(Expression expr,Command command){
    this.expr = expr;
    this.command = command;

  }
  @Override
  public boolean equals(Object o){
      if(this == o){
        return true;
      }
      if(o == null || getClass() !=o.getClass()){
        return false;
      }
      Loop loop = (Loop)o;

      if(!expr.equals(loop.expr)){
        return false;
      }
      return command.equals(loop.command);



  }



}
