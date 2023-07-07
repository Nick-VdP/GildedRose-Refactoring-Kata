package com.gildedrose.innitem;

import com.gildedrose.Item;

/**
 * The sulfuras item is a non-standard inn item. The properties of a sulfuras item do not change when it ages.
 */
class SulfurasItem implements InnItem {

    private static final String NAME = "Sulfuras, Hand of Ragnaros";

    private final Item item;

    SulfurasItem(final Item item) {
        this.item = item;
    }

    static boolean canDecorate(final Item item) {
        return NAME.equals(item.name);
    }

    @Override
    public String getName() {
        return item.name;
    }

    @Override
    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public int getQuality() {
        return item.quality;
    }

    @Override
    public void age() {
        // A sulfuras item does not change when it ages
    }
}
