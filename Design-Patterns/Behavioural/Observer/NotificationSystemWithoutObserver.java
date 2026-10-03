/**
 * Understanding the Problem:
 *
 *      Let’s say we’re building a simple YouTube-like Notification System.
 *      Whenever a creator uploads a new video, all their subscribers should get notified.
 *
 * Below is a naive implementation of this logic:
 */
import java.util.*;

class YouTubeChannel
{
    public void uploadNewVideo(String videoTitle)
    {
        // Upload the video
        System.out.println("Uploading: " + videoTitle + "\n");

        // Manually notify users
        System.out.println("Sending email to user1@example.com");
        System.out.println("Pushing in-app notification to user3@example.com");
    }
}

class Main
{
    public static void main(String[] args)
    {
        // Create a channel and upload a new video
        YouTubeChannel channel = new YouTubeChannel();
        channel.uploadNewVideo("Design Patterns in Java");
    }
}
/**
 * What’s Wrong with This Approach?
 *  While the code works, there are several design-level concerns:
 *
 *  Tightly Coupled Code: The YouTubeChannel class is directly responsible for how users are notified. If tomorrow we want to send an SMS or push notification, we’ll have to edit this class.
 *  No Reusability: The notification logic (email, app, etc.) is hardcoded. You can't reuse or extend this behavior in other places without copying code.
 *  Scalability Issues: Imagine having hundreds of users and multiple notification types. You’d end up cluttering this class with all the notification logic.
 *  Violation of Single Responsibility Principle (SRP): The class is doing two things: handling video uploads and managing user notifications. Ideally, each class should have one responsibility.
 */
