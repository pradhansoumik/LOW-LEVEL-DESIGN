/**
 * Let’s imagine a collaborative document editor where users can make changes to a shared document. Each user has the ability to give access to other users, enabling them to collaborate on the same document.
 *
 * The following code snippet demonstrates how this functionality might be implemented:
 */
import java.util.*;

// Class representing a User in a collaborative document editor.
class User
{
    private String name;
    private List<User> others;  // List of users that have access to this user

    // Constructor for creating a User with a name.
    public User(String name)
    {
        this.name = name;
        this.others = new ArrayList<>();
    }

    // Method to add a collaborator to this user (grants access to the user).
    public void addCollaborator(User user)
    {
        others.add(user);
    }

    // Method to make a change to the document and notify all collaborators.
    // Each collaborator will receive the change notification.
    public void makeChange(String change)
    {
        System.out.println(name + " made a change: " + change);
        for (User u : others) {
            u.receiveChange(change, this);  // Notify each collaborator about the change.
        }
    }

    // Method to receive a change notification from another user.
    public void receiveChange(String change, User from)
    {
        System.out.println(name + " received: \"" + change + "\" from " + from.name);
    }
}


// Client Code
class Main
{
    public static void main(String[] args)
    {
        // Creating users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        // Adding collaborators (Alice gives access to Bob and Charlie)
        alice.addCollaborator(bob);
        alice.addCollaborator(charlie);

        // Alice makes a change, notifying Bob and Charlie
        alice.makeChange("Updated the document title");

        // Bob makes a change, but no collaborators are notified because Bob has no collaborators added
        bob.makeChange("Added a new section to the document");
    }
}
/**

  Explanation of The Code:

     * addCollaborator(User user): This method allows a user to give access to another user, adding them to the list of collaborators.
     * makeChange(String change): This method allows the user to make a change to the document. It notifies all the collaborators by calling the receiveChange method on each of them.
     * receiveChange(String change, User from): This method is called to notify a user about a change made by another user. It prints out the change and the name of the user who made it.

 */
/**
  Issues with the Current Approach

     * Tight Coupling Between Users: Each user has references to every other user they collaborate with, creating a tight coupling. This makes it difficult to manage the system when changes (like adding/removing users) need to be made.
     * Adding/Removing Users Breaks the Structure: Modifying the list of collaborators (adding or removing users) can easily break the structure, especially in larger systems where users are dynamically managed. This increases the complexity of maintaining the system.
     * Hard to Orchestrate Roles (Editor/Viewer/Admin): The current design does not account for different roles (e.g., editor, viewer, admin). Managing these roles within the existing structure would require significant changes, violating the Open-Closed Principle and making the system hard to scale.
     * Difficulty in Managing Permissions, States, and Notifications: The current approach makes it difficult to manage user-specific permissions (e.g., read-only or full access) and notifications (e.g., user roles influencing change notifications). A single user’s changes are broadcasted to all collaborators, which makes it challenging to customize behavior based on user roles or states.
     * Lack of Separation of Concerns: The User class is responsible for managing collaborators, making changes, and notifying collaborators. This violates the Single Responsibility Principle (SRP) as the class is handling multiple responsibilities (collaboration management, change notifications, etc.).
     * Scalability Issues: As the number of users increases, the system becomes harder to manage and maintain due to the direct references between users. The complexity grows rapidly with the addition of new features or users.

 */