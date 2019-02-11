
/**
 * An Inventory.
 * @author jdierberger3 and <Wchen487>
 * @version 1331.
 */
public class Inventory {

    private Item[] contents = new Item[4];

    // TODO : Add an Item[] instance variable called contents.
    // Initialize it at declaration; give it a default length of 4.

    // Merge two inventorys, merging other into this inventory.
    public void merge(Inventory other) {
        int totalLen = other.contents.length + contents.length;
        Item[] merged = new Item[totalLen];
        int i = 0;
        for (; i < contents.length; i++) {
            merged[i] = contents[i];
        }
        for (; i < totalLen; i++) {
            merged[i] = other.contents[i - contents.length];
        }
        contents = merged;
        // TODO : Compute contents.length + other.contents.length
        // TODO : Create a new Item[] of the size above
        // TODO : Copy all the elements from contents into the new Item[]
        // TODO : Copy all the elements from other.contents into the new Item[]
        // TODO : Set contents to be the new Item[] we just filled
    }

    // Get the i-th item, where the 0th item is the first.
    // Return null if the index is invalid.
    public Item getItem(int i) {
        if (i < 0 || i >= contents.length) {
            return null;
        } else {
            return contents[i];
        }
        // TODO : Check if "i" is a bad index into our array
            // If so, return null
        // TODO : Otherwise, return the element at index i
    }

    // Put an item at the i-th position, where the 0th item is the first.
    // Return false if the index is invalid. Otherwise return true.
    public boolean putItem(int i, Item item) {
        if (i < 0 || i >= contents.length) {
            return false;
        } else {
            contents[i] = item;
        // TODO : Check if "i" is a bad index into our array
            // If so, return false
        // TODO : Otherwise, set the element at index i to item
            return true;
        }
    }

    // Get the length of contents.
    public int getContentsLength() {
        // TODO : Return the length of contents.
        return contents.length; // remove this in your final code.
    }

    // public Item[] getContents() {
    //     return this.contents;
    // }

    // public void setItem(Item item, int i) {
    //     this.contents[i] = item;
    // }
    //

}