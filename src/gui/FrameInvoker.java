package gui;

public class FrameInvoker implements Runnable {

    private final FrameApplication frameApplication;

    public FrameInvoker(FrameApplication frameApplication) {
        this.frameApplication = frameApplication;
    }
    
    
    @Override
    public void run() {
        System.out.println("Unutar FrameInvoker klase poziv metode run izvršava: " +Thread.currentThread().getName());
        frameApplication.showFrame();
    }
}
