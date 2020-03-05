public class InvalidExprException extends Exception {
 String message = "Invalid expression";
  public InvalidExprException(String message){
   super(message);
  }
}