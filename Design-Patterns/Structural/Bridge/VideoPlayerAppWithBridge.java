/**
 * Using Bridge Pattern
 */

import java.util.*;

// ======== Implementor Interface =========
interface VideoQuality
{
    void load(String title);
}

// ============ Concrete Implementors ==============
class SDQuality implements VideoQuality
{
    public void load(String title)
    {
        System.out.println("Streaming " + title + " in SD Quality");
    }
}

class HDQuality implements VideoQuality
{
    public void load(String title)
    {
        System.out.println("Streaming " + title + " in HD Quality");
    }
}

class UltraHDQuality implements VideoQuality
{
    public void load(String title)
    {
        System.out.println("Streaming " + title + " in 4K Ultra HD Quality");
    }
}

// ========== Abstraction ==========
abstract class VideoPlayer
{
    protected VideoQuality quality;

    public VideoPlayer(VideoQuality quality)
    {
        this.quality = quality;
    }

    public abstract void play(String title);
}

// =========== Refined Abstractions ==============
class WebPlayer extends VideoPlayer
{
    public WebPlayer(VideoQuality quality)
    {
        super(quality);
    }

    public void play(String title)
    {
        System.out.println("Web Platform:");
        quality.load(title);
    }
}

class MobilePlayer extends VideoPlayer
{
    public MobilePlayer(VideoQuality quality)
    {
        super(quality);
    }

    public void play(String title)
    {
        System.out.println("Mobile Platform:");
        quality.load(title);
    }
}

// Client Code
class Main
{
    public static void main(String[] args)
    {
        // Playing on Web with HD Quality
        VideoPlayer player1 = new WebPlayer(new HDQuality());
        player1.play("Interstellar");

        // Playing on Mobile with Ultra HD Quality
        VideoPlayer player2 = new MobilePlayer(new UltraHDQuality());
        player2.play("Inception");
    }
}
/**
 * How Bridge Pattern Solves the Issue:
 *
     * Separation of Concerns: VideoPlayer (abstraction) focuses on the platform-specific behavior, while VideoQuality (implementor) handles quality-specific streaming logic.
     * Flexible Combinations: You can mix and match any platform with any quality at runtime without creating new classes.
     * Easier to Extend: Adding a new platform or a new quality only requires one new class, not multiple combinations:
         * Add SmartTVPlayer → works with all existing qualities.
         * Add FullHDQuality → works with all existing players.
     * Cleaner Code Structure: Each class has a single responsibility. This promotes maintainability, scalability, and adheres to the Open/Closed Principle.
 */