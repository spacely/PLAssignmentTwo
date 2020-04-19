
// A class that assigns a variable to a value or an expression
public class  AssignVariables extends Command {
  Variable variable ;
  Expression expr;
  public AssignVariables(Variable variable,Expression expr){
    this.variable = variable;
    this.expr = expr;
  }

  @Override
  public boolean equals(Object o){
      if(this == o){
        return true;
      }
      if(o==null || getClass()!=o.getClass()){
        return false;
      }
      AssignVariables ass = (AssignVariables)o;
      if(!variable.equals(ass.variable)){
        return false;
      }
    return expr.equals(ass.expr);
  }




}
