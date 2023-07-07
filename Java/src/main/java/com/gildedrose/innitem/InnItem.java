package com.gildedrose.innitem;

/**
 * An inn item is a good that is sold by the Gilded Rose Inn.
 */
public interface InnItem {

    /**
     * The name describes the item.
     */
    String getName();

    /**
     * The sell-in value denotes the number of days in which the item should be sold.
     */
    int getSellIn();

    /**
     * The quality value denotes how valuable the item is.
     */
    int getQuality();

    /**
     * Age this item by one day.
     */
    void age();
}
