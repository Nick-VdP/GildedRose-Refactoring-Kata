package com.gildedrose.innitem;

import com.gildedrose.Item;

public class InnItemFactory {

    /**
     * Create a new inn item that decorates the given item.
     *
     * @param item The 'legacy' item
     * @return A new inn item
     */
    public static InnItem fromItem(final Item item) {
        if (AgedBrieItem.canDecorate(item)) return new AgedBrieItem(item);
        if (BackstagePassesItem.canDecorate(item)) return new BackstagePassesItem(item);
        if (SulfurasItem.canDecorate(item)) return new SulfurasItem(item);
        if (ConjuredItem.canDecorate(item)) return new ConjuredItem(item);
        return new StandardInnItem(item);
    }
}
