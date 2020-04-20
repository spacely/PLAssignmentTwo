import java.util.HashMap;
import java.util.Map;


public class Evaluator extends Visitor<Integer> {
  private int value;
  private Map<String,Integer> valuation = new HashMap<String,Integer>();

  public Evaluator(Expression expression,Map<String,Integer> valuation){
    this.valuation.putAll(valuation);
    value = visit(expression);
  }
  public int value(){
    return value;
  }

  public Integer AdditionInterpreter(Addition addition){
    return visit(addition.first) + visit(addition.second);
  }

  public Integer SubstractionInterpreter(Addition addition){
    return visit(addition.first) - visit(addition.second);
  }

  public Integer IntInterpreter(Int integer){
    return integer.val;
  }
  public Integer VariableInterpreter(Variable variable){
    if(valuation.containsKey(variable.name)){
      return valuation.get(variable.name);
    }
    else {
      throw new Exception();
    }
  }


}
