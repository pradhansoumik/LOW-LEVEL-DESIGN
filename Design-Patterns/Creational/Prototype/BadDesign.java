import java.util.*;

interface EmailTemplate
{
    void setContent(String content);
    void send(String to);
}

// A concrete email class, hardcoded
class WelcomeEmail implements EmailTemplate
{
    private String subject;
    private String content;

    public WelcomeEmail() {
        this.subject = "Welcome to TUF+";
        this.content = "Hi there! Thanks for joining us.";
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
}

class Main
{
    public static void main(String[] args)
    {
        // Create a welcome email
        WelcomeEmail email1 = new WelcomeEmail();
        email1.send("user1@example.com");

        // Suppose we want a similar email with slightly different content
        WelcomeEmail email2 = new WelcomeEmail();
        email2.setContent("Hi there! Welcome to TUF Premium.");
        email2.send("user2@example.com");

        // Yet another variation
        WelcomeEmail email3 = new WelcomeEmail();
        email3.setContent("Thanks for signing up. Let's get started!");
        email3.send("user3@example.com");
    }
}
/**
 * ::Issues in the Bad design::
 *
 * Tight Coupling to Concrete Class:
         The code uses the WelcomeEmail class directly.
         No abstraction for cloning-client code is tightly bound to object creation logic (new WelcomeEmail() everywhere).
 *
 * Repetitive Instantiation:
        For every variation, a new instance is created using the constructor-even though most data remains the same.
        This leads to unnecessary duplication of code and logic.

 * Violates DRY Principle: Repeated calls to new WelcomeEmail() and then setContent() for slight modifications break the Don't Repeat Yourself principle.

 * No Cloning or Copy Mechanism: There is no concept of cloning or reusing a pre-defined template and just modifying small parts.
 */