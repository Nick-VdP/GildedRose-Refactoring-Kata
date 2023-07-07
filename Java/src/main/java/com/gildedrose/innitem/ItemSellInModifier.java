package com.gildedrose.innitem;

import com.gildedrose.Item;

/**
 * This modifier facilitates the modification of an item's sell-in value.
 * <p>
 * The sell-in value denotes the number of days in which the item should be sold.
 */
class ItemSellInModifier {

    private final Item item;

    ItemSellInModifier(final Item item) {
        this.item = item;
    }

    /**
     * Decrease the sell-in days by the given value.
     *
     * @param value The value to decrease
     */
    void decreaseSellIn(final int value) {
        item.sellIn -= value;
    }

    /**
     * Check if the sell by date has elapsed.
     *
     * @return True if the sell by date has elapsed.
     */
    boolean hasSellByDateElapsed() {
        return item.sellIn <= 0;
    }

    /**
     * Check if the sell by date is approaching in the given days.
     *
     * @return True if the sell by date is approaching.
     */
    boolean isSellByDateApproaching(final int days) {
        return item.sellIn > 0 && item.sellIn <= days;
    }
}
