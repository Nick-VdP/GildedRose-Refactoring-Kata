package com.gildedrose.innitem;

import com.gildedrose.Item;

/**
 * This modifier facilitates the modification of an item's quality.
 * <p>
 * The quality value denotes how valuable the item is.
 */
class ItemQualityModifier {

    private final Item item;
    private final int maximumQuality;

    ItemQualityModifier(final Item item,
                        final int maximumQuality) {
        this.item = item;
        this.maximumQuality = maximumQuality;
    }

    /**
     * Set the quality of the item to the given value.
     *
     * @param quality The new quality
     */
    void setQuality(final int quality) {
        item.quality = Math.min(quality, maximumQuality);
    }

    /**
     * Increase the quality of the item by the given value.
     *
     * @param value The value to increase
     */
    void increaseQuality(final int value) {
        item.quality = Math.min(item.quality + value, maximumQuality);
    }

    /**
     * Decrease the quality of the item by the given value.
     *
     * @param value The value to decrease
     */
    void decreaseQuality(final int value) {
        item.quality = Math.max(item.quality - value, 0);
    }
}
