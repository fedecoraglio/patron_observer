public class Main {

    public static void main(String[] args) throws InterruptedException {
        final OrderBoard board = new OrderBoard();
        final Buyer bob = new Buyer("A1", "bob");
        final Buyer joe = new Buyer("A2", "joe");
        final Buyer george = new Buyer("A4", "george");
        final Buyer john = new Buyer("A3", "john");

        //Adding all the observers
        board.addObserver(bob);
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
