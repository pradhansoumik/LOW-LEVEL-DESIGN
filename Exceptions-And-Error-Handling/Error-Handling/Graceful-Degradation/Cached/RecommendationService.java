import java.util.List;
import java.util.logging.Logger;

class RecommendationService
{
    private static final Logger log = Logger.getLogger(RecommendationService.class.getName());
    private final CacheService cacheService = new CacheService();

    public List<String> getRecommendedItems(String userId)
    {
        try
        {
            // Attempt to fetch live recommendations
            return fetchLiveRecommendations(userId);
        }
        catch (Exception ex)
        {
            // If the live service fails, log the error and fall back to cache
            log.warning("Live service failed, falling back to cache");
            return cacheService.getCachedRecommendations(userId);  // Fallback to cached data
        }
    }

    public List<String> fetchLiveRecommendations(String userId) {
        return List.of("movie-1", "movie-2");  // Simulated live recommendation data
    }
}
class CacheService
{
    public List<String> getCachedRecommendations(String userId)
    {
        return List.of("movie-3", "movie-4");  // Simulated cached recommendation data
    }
}
