package com.info6205.algorithm;

public interface BagInterface<Order>{
    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize();

    /**
     * Checks whether this bag is empty.
     *
     * @return True if the bag is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, false if not.
     */
    public boolean add(Cloth newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public Cloth remove();

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, false if not.
     */
    public boolean remove(Cloth anEntry);

    /**
     * Removes all entries from this bag.
     */
    public void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(Cloth anEntry);

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to find.
     * @return True if the bag contains anEntry, false if not.
     */
    public boolean contains(Cloth anEntry);
}
