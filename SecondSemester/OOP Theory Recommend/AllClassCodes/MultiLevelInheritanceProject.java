class User {
    public void login() {
        System.out.println("🔐 User has logged in.");
    }

    public void logout() {
        System.out.println("🔓 User has logged out.");
    }
}

class Employee extends User {
    private String message;

    public void sendMessage(String m) {
        this.message = m;
        System.out.println("📤 Employee has sent a message.");
    }

    public String receiveMessage() {
        System.out.println("📥 Employee has received a message.");
        return "Message: " + this.message;
    }
}

class Manager extends Employee {
    public void broadcastMessage(String message) {
        System.out.println("📢 Manager broadcasted: " + message);
    }

    public void viewReport() {
        System.out.println("📊 Manager is viewing employee reports...");
    }
}

public class MultiLevelInheritanceProject {
    public static void main(String[] args) {
        Manager mgr = new Manager();

        // User level
        mgr.login();

        // Employee level
        mgr.sendMessage("Finish the monthly report.");
        String reply = mgr.receiveMessage();
        System.out.println("Received: " + reply);

        // Manager level
        mgr.broadcastMessage("Team meeting at 3 PM.");
        mgr.viewReport();

        mgr.logout();
    }
}

