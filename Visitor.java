
//Designing an abstract class that directs traffic to the right class for evaluation of semantics.

public abstract class Visitor<T>{

  @SuppressWarnings("unchecked")
   public T visit(Object object) {
       try {
           /*! Get the name of the class of the given object, search for a method with this name in self and call it. */
           return (T) this.getClass().getMethod("visit" + object.getClass().getSimpleName(), object.getClass()).invoke(this, object);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }


}
