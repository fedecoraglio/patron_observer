import java.util.Observable;

class OrderBoard extends Observable {

  public void newOrderReady(final String orderNumber) {
    //it is necessary in order to hasChanged returns true.
    setChanged();
    //Notify all observers
    notifyObservers(orderNumber);
  }
}
