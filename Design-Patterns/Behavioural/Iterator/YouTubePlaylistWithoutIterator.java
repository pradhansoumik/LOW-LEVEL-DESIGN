/**
 * Let’s say we’re building a YouTube Playlist system. We want to store a list of videos and print their titles one by one. Let's look at the initial code setup:
 */

import java.util.*;

// A simple Video class with title
class Video {
    String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// YouTubePlaylist class holds a list of Video objects
class YouTubePlaylist {
    private List<Video> videos = new ArrayList<>();

    // Add a video to the playlist
    public void addVideo(Video video) {
        videos.add(video);
    }

    // Expose the video list
    public List<Video> getVideos() {
        return videos;
    }
}

// Client Code
class Main {
    public static void main(String[] args) {
        YouTubePlaylist playlist = new YouTubePlaylist();
        playlist.addVideo(new Video("LLD Tutorial"));
        playlist.addVideo(new Video("System Design Basics"));

        // Loop through videos and print titles
        for (Video v : playlist.getVideos()) {
            System.out.println(v.getTitle());
        }
    }
}
/**
 * What are the Issues?
 * While the code works, there are several design-level concerns:
 *
 * Exposes internal structure:
     * The internal list or array is directly returned via getVideos() or similar methods.
     * This breaks encapsulation, as clients can access or even modify the internal collection outside the owning class.
 *
 * Tight coupling with underlying structure:
     * The external code is tightly bound to the specific type of collection used (like vector, list, etc.).
     * Any change in the internal structure may require changes in client code.
 *
 * No control over traversal:
     * Traversal logic is managed outside the class.
     * You can't enforce custom traversal behaviors (e.g., reverse, skip elements, filter) without modifying external code.
 *
 * Difficult to support multiple independent traversals:
     * If two parts of your program want to iterate over the same playlist independently, there's no built-in way to do that cleanly.
     * You have to manage indexing and traversal state manually.
 */