//Consider the example of a Notification system:

// Notification class
/*
class Notification
{
    // method implementing send notification functionality
    public void sendNotification()
    {
        System.out.println("Notification sent");
    }
}

// Main class
class Main
{
    //  main method
    public static void main(String args[])
    {
        // Creating an object of Notification class
        Notification notification = new Notification();

        // Working code on the notification object
        notification.sendNotification();
    }
}
*/

// Assume we wish to introduce some new type of notifications, say Email Notification or Text Notification.
// In such a case, we can create a new class for each type of notification, and we can easily extend the system
// without breaking existing code using the Liskov Substitution Principle.

// Notification class
class Notification
{
    // method implementing send notification functionality
    public void sendNotification()
    {
        System.out.println("Notification sent");
    }
}

// Subclass of Notification class for Email Notification
class EmailNotification extends Notification
{
    @Override
    public void sendNotification()
    {
        System.out.println("Email Notification sent");
    }
}

// Subclass of Notification class for Text Notification
class TextNotification extends Notification
{
    @Override
    public void sendNotification()
    {
        System.out.println("Text Notification sent");
    }
}

// Main class
class Driver
{
    //  main method
    public static void main(String args[])
    {
        /* Replaced the Notification class object
           with one of its subclass' objects */
        Notification notification = new EmailNotification();

        // Working code on the notification object
        notification.sendNotification();
    }
}
