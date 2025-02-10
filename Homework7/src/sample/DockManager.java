package sample;

public class DockManager {

	private int docksAvailable;
	
	public DockManager(int docksAvailable) {
		super();
		this.docksAvailable = docksAvailable;
	}
	
	public synchronized void enterDock(String shipName) {
		for(; docksAvailable <= 0;) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		docksAvailable = docksAvailable - 1;
		System.out.println(shipName + " -> * в доке *");
	}
	public synchronized void leaveDock(String shipName) {
		docksAvailable++;
		System.out.println(shipName + " -> * Покинул док *");
		notify();
	}
}
