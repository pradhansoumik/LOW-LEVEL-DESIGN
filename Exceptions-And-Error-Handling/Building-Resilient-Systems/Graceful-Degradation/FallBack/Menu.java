public class Menu
{
    private final MenuService menuService = new MenuService();
    public Menu(String s) {

    }

    // Show fallback UI
    public Menu getMenu(String restaurantId)
    {
        try
        {
            // Attempt to fetch the live menu
            return menuService.fetchMenu(restaurantId);
        }
        catch (Exception e)
        {
            // If the live menu is unavailable, show a fallback message in the UI
            return new Menu("Menu currently unavailable. Please try again later.");
        }
    }
}
class MenuService
{
    public Menu fetchMenu(String restaurantId)
    {
        // Simulated live menu fetching logic
        return new Menu("Live menu for " + restaurantId);
    }
}