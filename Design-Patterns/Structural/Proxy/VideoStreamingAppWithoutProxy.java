/**
 * Imagine you're building a feature like a video streaming app (think YouTube or Netflix) where users can download videos.
 * Now, consider this: multiple users might try to download the same video multiple times - or even the same user may repeat the request. In such scenarios, if we go ahead and download the video from the internet every single time, it leads to unnecessary network calls, longer wait times, and wasted bandwidth.
 *
 * Let’s consider a scenario where we want to download a video multiple times, perhaps from different places in the code or by different users. A poor design would look like this:
 * Bad Design: Without Proxy
 */
// ========== RealVideoDownloader Class ==========
class RealVideoDownloader
{
    public String downloadVideo(String videoUrl)
    {
        // caching logic missing
        // filtering logic missing
        // access logic missing
        System.out.println("Downloading video from URL: " + videoUrl);
        String content = "Video content from " + videoUrl;
        System.out.println("Downloaded Content: " + content);
        return content;
    }
}

// ================ Main Class ===================
class Main
{
    public static void main(String[] args)
    {
        System.out.println("User 1 tries to download the video.");
        RealVideoDownloader downloader1 = new RealVideoDownloader();
        downloader1.downloadVideo("https://video.com/proxy-pattern");

        System.out.println();

        System.out.println("User 2 tries to download the same video again.");
        RealVideoDownloader downloader2 = new RealVideoDownloader();
        downloader2.downloadVideo("https://video.com/proxy-pattern");
    }
}

/**
 * Understanding the Issues:
 *
     * There's no caching, so the same video is downloaded again and again even if it’s already available.
     * There's no access control or content filtering - any video URL is downloaded without restrictions.
     * The client directly depends on the RealVideoDownloader, meaning there’s no way to intercept, log, or modify the download behavior without changing core logic.
     * It results in multiple object creations and redundant resource usage.
 *
 * The previous implementation made direct use of the RealVideoDownloader class for every download request, even if the same video was requested multiple times. This meant the system would re-download and reprocess the same video repeatedly, leading to unnecessary network usage and redundant computation.
 */