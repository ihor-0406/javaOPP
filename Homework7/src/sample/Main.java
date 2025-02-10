package sample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DockManager dockManager = new DockManager(2);
		
		Ships ship1 = new Ships("Ship 1", dockManager );
		Ships ship2 = new Ships("Ship 2", dockManager);
		Ships ship3 = new Ships("Ship 3", dockManager );
		
		ship1.start();
		ship2.start();
		ship3.start();
	}

}
