package sample;

public class Ships extends Thread{

	private int boxes = 10;
	private String name;
	private DockManager dockManager;
	

	public Ships(String name, DockManager dockManager) {
		super();
		this.name = name;
		this.dockManager = dockManager;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		dockManager.enterDock(name);
		for(int i = 0; i <= boxes; i++) {
			try {
				Thread.sleep(500);
				System.out.println(name + ": Розгружено -> " + i + " <-");
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		dockManager.leaveDock(name);
	}
	
	
	
}
