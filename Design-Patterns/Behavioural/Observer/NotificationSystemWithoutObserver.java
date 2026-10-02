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
