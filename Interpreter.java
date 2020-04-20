//An interpreter class builds semantic objects together
//Gets it ready for evaluation.
import java.util.*;

public class Interpreter extends Visitor{
  private Map<String,Integer> evaluation = new HashMap<String,Integer>();


  public Map<String,Integer> getEvaluation(){
    Map<String,Integer> results = new HashMap<String,Integer>();
    results.putAll(evaluation);
    return results;
  }

public Interpreter(Command command){
  visit(command);
}

public void AssignmentInterpret(AssignVariables composition){
Evaluator evaluator = new Evaluator(composition.expr,evaluation);
evaluation.put(composition.variable.name,evaluator.getValue());

}

public void CombinationInterpret(Combination combination){
  visit(combination.first);
  visit(combination.second);
}

public void ConditionalInterpret(Conditionals conditional){
  Evaluator evaluator = new Evaluator(conditional.ACondition,evaluation);
  if(evaluator.getValue() !=0){
    visit(conditional.thenphase);

  }else{
    visit(conditional.elsephase);
  }

}

public void LoopInterpret(Loop loop){
  Evaluator evaluator = new Evaluator(loop.expr,evaluation);
  if(evaluator.getValue()!=0){
    visit(new Combination(loop.command,loop));
  }

}

}
