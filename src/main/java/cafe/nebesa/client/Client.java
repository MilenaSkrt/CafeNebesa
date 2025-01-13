package cafe.nebesa.client;

public class Client implements Observer {
    private String name;
    private String contactInfo;

    public Client(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    @Override
    public void update(String status) {
        System.out.println("Notification for " + name + ": Your order status is now '" + status + "'.");
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}
