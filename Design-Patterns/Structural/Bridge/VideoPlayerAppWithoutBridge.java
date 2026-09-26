/**
 * Assume we are building a video player that aims to model different video players (like Web, Mobile, Smart TV) each with different quality types (HD, Ultra HD, 4K).
 * Using Tight Coupling Causing Class Explosion
 */
import java.util.*;

// ======= Interface for video quality =======
interface PlayQuality
{
    void play(String title);
}

// Each class here represents a combination of platform and quality
class WebHDPlayer implements PlayQuality
{
    public void play(String title)
    {
        // Web player plays in HD
        System.out.println("Web Player: Playing " + title + " in HD");
    }
}

class MobileHDPlayer implements PlayQuality
{
    public void play(String title)
    {
        // Mobile player plays in HD
        System.out.println("Mobile Player: Playing " + title + " in HD");
    }
}

class SmartTVUltraHDPlayer implements PlayQuality
{
    public void play(String title)
    {
        // Smart TV plays in Ultra HD
        System.out.println("Smart TV: Playing " + title + " in ultra HD");
    }
}

class Web4KPlayer implements PlayQuality
{
    public void play(String title)
    {
        // Web player plays in 4K
        System.out.println("Web Player: Playing " + title + " in 4K");
    }
}

// ============ Main class ================
class Main
{
    public static void main(String[] args)
    {
        PlayQuality player = new WebHDPlayer();
        player.play("Interstellar");
    }
}
/**
 * Understanding the Issue:
 *
 * In the given design, platform types (like Web, Mobile, Smart TV) are tightly coupled with video quality types (like HD, Ultra HD, 4K).
 * This results in a rigid system where every combination requires a separate class - for example, WebHDPlayer, MobileHDPlayer, SmartTVUltraHDPlayer, and so on.
 *
 * As new platforms or quality types are introduced, the number of classes grows rapidly.
 * Adding just one new platform or one new quality level leads to multiple new classes. If you have 5 platforms and 5 quality types, you end up with 25 distinct classes - most of which share very similar code.
 *
 * Such tightly coupled designs are hard to test, extend, and manage over time.
 * This is where the Bridge Pattern proves valuable - by decoupling the abstraction (platform) from its implementation (quality), it allows both to evolve independently, eliminating unnecessary class combinations.
 */