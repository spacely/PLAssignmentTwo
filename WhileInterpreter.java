
import java.util.*;

public class WhileInterpreter{
  private String code;

  public WhileInterpreter(String code){
    this.code = code;

  }

  public void eval() throws Exception{

    Parser parser = new Parser(code);
    Command command = parser.parse();
    Interpreter interpret = new Interpreter(command);
    Map<String,Integer> ev = interpret.getEvaluation();
    System.out.println(ev);



  }

  public static void main(String args[]){


    Scanner scanner = new Scanner(System.in);
    try {


    while(scanner.hasNextLine()){

    StringBuilder sb =  new StringBuilder(scanner.nextLine());
    String code = sb.toString();
    WhileInterpreter interpreter = new WhileInterpreter(code);
    interpreter.eval();


    //StringBuilder sb = new StringBuilder(scanner.nextLine());


  }
  }catch(Exception e){
    System.out.println("Error " + e.getMessage());
  }



  }





}
