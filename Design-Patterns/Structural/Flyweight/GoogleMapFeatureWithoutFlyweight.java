/**
 * Imagine you're building a feature like Google Maps where you need to visually represent trees across the globe.
 * Now, even though millions of trees are shown, most of them belong to only a few common types like “Oak”, “Pine”, or “Birch”. However, if we were to create a separate object for each individual tree — storing the same data repeatedly for tree type, color, and texture — it would lead to massive memory consumption.
 *
 * Let’s consider a scenario where we want to create 1 million trees, all with the same name, color, and texture. A poor design would look like this:
 * Bad Design: Without Flyweight
 */

import java.util.*;

// ================ Tree Class =================
class Tree
{
    // Attributes that keep on changing
    private int x;
    private int y;

    // Attributes that remain constant
    private String name;
    private String color;
    private String texture;

    public Tree(int x, int y, String name, String color, String texture)
    {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw()
    {
        System.out.println("Drawing tree at (" + x + ", " + y + ") with type " + name);
    }
}

// ================ Forest Class =================
class Forest
{

    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture)
    {
        Tree tree = new Tree(x, y, name, color, texture);
        trees.add(tree);
    }

    public void draw()
    {
        for (Tree tree : trees)
        {
            tree.draw();
        }
    }
}

// =============== Client Code ==================
class Main
{
    public static void main(String[] args)
    {
        Forest forest = new Forest();

        // Planting 1 million trees
        for(int i = 0; i < 1000000; i++)
        {
            forest.plantTree(i, i, "Oak", "Green", "Rough");
        }

        System.out.println("Planted 1 million trees.");
    }
}
/**
 * Understanding the Issues:
 *
     * Although the above codes works absolutely fine but there are a few problems associated with it:
         * Redundant memory usage: Same tree data duplicated a million times.
         * Inefficient: Slower rendering, higher GC overhead.
 *
 * The previous implementation created a new Tree object for each of the 1 million trees, even when most of them had identical properties like name, color, and texture. This led to unnecessary duplication of memory for the shared attributes.
 */