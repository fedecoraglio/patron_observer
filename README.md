Para poder implementar este patrón de manera sencilla, Java introduce dos clases (una interfaz y una clase) :

        java.util.Observer -- cualquier objeto que necesité ser notificado cuando el estado de otro objeto cambia.
        java.util.Observable -- cualquier objeto donde el cambio de su estado sea importante y otros puedan registrarse para rebicir la notificación de ese cambio de estado. 


Ahora podemos plantear un caso de ejemplo, supongamos que en un lugar de comida rápida dispone de una pizarra electrónica donde se notifica cuando un pedido esta completo. A su vez, existen compradores que están esperando que su pedido este listo y aparezca en dicha pizarra para poder retirarlos.

Para ello creamos una clase llamada OrderBoard para simular el funcionamiento de la pizarra cuando un pedido esta listo.

La clase puede definirse de esta manera:

import java.util.Observable;

class OrderBoard extends Observable {

  public void newOrderReady(final String orderNumber) {
    //it is necessary in order to hasChanged returns true.

    setChanged();
    //Notify all observers    notifyObservers(orderNumber);
  }
}

 

Es importante notar que esta clase va a ser observable por distintos observadores(Compradores) 

para saber cuando su pedido esta listo. Ahora definimos los distintos observadores en una clase 

llamada Buyer de la siguiente manera: 

 

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
 

Tener en cuenta que OrderBoard extiende de Observable y que Buyer implementa la interfaz 

Observer. Por último creamos una clase Main para unificar todo este comportamiento:

 

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final OrderBoard board = new OrderBoard();
        final Buyer bob = new Buyer("A1", "bob");
        final Buyer joe = new Buyer("A2", "joe");
        final Buyer george = new Buyer("A4", "george");
        final Buyer john = new Buyer("A3", "john");
        
        //Adding all the observers        board.addObserver(bob);
        board.addObserver(joe);
        board.addObserver(george);
        board.addObserver(john);

        //We complete all the orders per each user.         

         board.newOrderReady("A1");
        board.newOrderReady("A4");
        board.newOrderReady("A3");
        board.newOrderReady("A2");
    }
}
 

La salida de la ejecución de este método es: 

 

bob says:  This is my order!!! - A1
george says:  This is my order!!! - A4
john says:  This is my order!!! - A3
joe says:  This is my order!!! - A2

 

Espero que sea de utilidad. 

 

Referencias:

http://migranitodesoftware.blogspot.com.ar/2015/01/patrones-de-diseno-patron-observer.html

http://www.javaworld.com/article/2077258/learn-java/observer-and-observable.html

http://migranitodejava.blogspot.com.ar/search/label/Observer

http://docs.oracle.com/javase/7/docs/api/java/util/Observer.html

http://docs.oracle.com/javase/7/docs/api/java/util/Observable.html

http://es.wikipedia.org/wiki/Observer_%28patr%C3%B3n_de_dise%C3%B1o%29 







