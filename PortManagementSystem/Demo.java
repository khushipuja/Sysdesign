package PortManagementSystem;

public class Demo {

    public static void main(String[] args) {
        PortManager portManager = new PortManager();
        portManager.addPort(0);
        portManager.addPort(1);
        portManager.addPort(2);

        portManager.getFreePorts();
        portManager.getFreePorts();
        portManager.getFreePorts();
        portManager.getFreePorts();

        portManager.freePort(1);
        portManager.getFreePorts();
        portManager.getFreePorts();
    }
}
