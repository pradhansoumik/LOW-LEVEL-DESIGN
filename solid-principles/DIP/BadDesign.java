/**
 * Without DIP - Tightly Coupled Code
 */
// Class implementing the recommendations based on recently added
class RecentlyAdded_
{
    // Method to get the recommendations
    public void getRecommendations()
    {
        System.out.println("Showing recently added content...");
    }
}

// Class implementing the overall Recommendation Engine
class RecommendationEngine_
{
    private RecentlyAdded_ recommender = new RecentlyAdded_();

    public void recommend()
    {
        recommender.getRecommendations();
    }
}
