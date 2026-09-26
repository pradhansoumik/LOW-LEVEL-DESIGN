/**
 * To solve this, we use the Proxy Design Pattern - a structural pattern that provides a placeholder or surrogate for another object to control access to it.
 *
 * Good Design: Using Proxy Pattern
 */

import java.util.*;

interface VideoDownloader
{
    String downloadVideo(String videoURL);
}

// ========== RealVideoDownloader Class ==========
class RealVideoDownloader implements VideoDownloader
{

    @Override
    public String downloadVideo(String videoUrl)
    {
        System.out.println("Downloading video from URL: " + videoUrl);
        return "Video content from " + videoUrl;
    }
}

// =============== Proxy With Cache ====================
class CachedVideoDownloader implements VideoDownloader
{

    private RealVideoDownloader realDownloader;
    private Map<String, String> cache;

    public CachedVideoDownloader()
    {
        this.realDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }

    @Override
    public String downloadVideo(String videoUrl)
    {
        if (cache.containsKey(videoUrl))
        {
            System.out.println("Returning cached video for: " + videoUrl);
            return cache.get(videoUrl);
        }

        System.out.println("Cache miss. Downloading...");
        String video = realDownloader.downloadVideo(videoUrl);
        cache.put(videoUrl, video);
        return video;
    }
}


// ================ Main Class ===================
class Main
{
    public static void main(String[] args)
    {
        VideoDownloader cacheVideoDownloader = new CachedVideoDownloader();
        System.out.println("User 1 tries to download the video.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");

        System.out.println();

        System.out.println("User 2 tries to download the same video again.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");
    }
}

/**
 * How Proxy Pattern Solves the Issue
 * In this example, the proxy (CachedVideoDownloader Class) was used that implements a caching logic that checks if a video has already been downloaded. If so, it simply returns the cached result, saving time and resources.
 *
 * This way, the real object is accessed only when absolutely necessary, while repeated requests are served efficiently through the proxy - resulting in faster response times and optimized performance.
 */