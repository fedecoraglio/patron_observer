import java.util.Observable;
import java.util.Observer;

final class Buyer implements Observer {

  private final String orderNumber;
  private final String name;

  public Buyer(final String orderNumber, final String name) {
    this.orderNumber = orderNumber;
    this.name = name;
  }

  public void update(final Observable observable, final Object arg) {
    if(arg != null && arg.equals(orderNumber)) {
      System.out.println(name + " says: " + " This is my order!!! - " + orderNumber);
    }
  }
}
