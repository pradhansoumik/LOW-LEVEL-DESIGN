/**
 * The current implementation of the collaborative document editor can be improved by refactoring the code using the Mediator Pattern. Instead of having users directly communicate with each other to notify changes, the CollaborativeDocument will act as the mediator. This way, users only interact with the document (mediator) to communicate changes, promoting loose coupling and simplifying the overall structure.
 *
 */
import java.util.*;

// Mediator Interface
interface DocumentSessionMediator
{
    void broadcastChange(String change, User sender);
    void join(User user);
}

// Concrete Mediator Class
class CollaborativeDocument implements DocumentSessionMediator
{
    private List<User> users = new ArrayList<>();

    @Override
    public void join(User user)
    {
        users.add(user);
    }

    @Override
    public void broadcastChange(String change, User sender)
    {
        for (User user : users) {
            if (user != sender) {
                user.receiveChange(change, sender);
            }
        }
    }
}

// User Class
class User
{
    protected String name;
    protected DocumentSessionMediator mediator;

    public User(String name, DocumentSessionMediator mediator)
    {
        this.name = name;
        this.mediator = mediator;
    }

    // Method for users to make a change
    public void makeChange(String change)
    {
        System.out.println(name + " edited the document: " + change);
        mediator.broadcastChange(change, this);
    }

    // Method to receive a change from another user
    public void receiveChange(String change, User sender)
    {
        System.out.println(name + " saw change from " + sender.name + ": \"" + change + "\"");
    }
}

// Client Code
class Main
{
    public static void main(String[] args)
    {
        CollaborativeDocument doc = new CollaborativeDocument();

        // Creating users
        User alice = new User("Alice", doc);
        User bob = new User("Bob", doc);
        User charlie = new User("Charlie", doc);

        // Joining the collaborative document
        doc.join(alice);
        doc.join(bob);
        doc.join(charlie);

        // Users making changes
        alice.makeChange("Added project title");
        bob.makeChange("Corrected grammar in paragraph 2");
    }
}
/**
 * Explanation of Changes
 * Mediator Interface (DocumentSessionMediator): Defines the methods for broadcasting changes and adding users to the document.
 * Concrete Mediator (CollaborativeDocument): Implements the DocumentSessionMediator and manages users. It broadcasts changes to all users except the sender.
 * User Class: Now interacts only with the CollaborativeDocument (mediator) rather than directly notifying other users. This reduces the coupling between users.
 */
/**
 * How the Mediator Pattern Solves the Issues
 * Issue	How it is Solved

     * Tight Coupling Between Users	- The users no longer hold references to each other. They communicate through the mediator (CollaborativeDocument), reducing direct dependencies between them.
     * Adding/Removing Users Breaks the Structure - The CollaborativeDocument now manages the users and their interactions. Adding or removing users is handled centrally, making the system more maintainable.
     * Hard to Orchestrate Roles (Editor/Viewer/Admin) - Roles can now be managed through the mediator. Different roles and permissions can be introduced in the CollaborativeDocument class, making the structure more flexible.
     * Difficulty in Managing Permissions, States, and Notifications - The mediator centralizes the notifications and can be extended to manage permissions, states, and notifications more efficiently.
     * Lack of Separation of Concerns - The User class now only handles user-specific behavior (making changes and receiving changes), while the mediator handles all communication, adhering to the Single Responsibility Principle.
     * Scalability Issues - With the mediator handling communication, it is easier to scale the system, as new users or features (like different types of notifications) can be added without altering the existing structure.

 */