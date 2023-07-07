package com.gildedrose.innitem;

import com.gildedrose.Item;

/**
 * The aged brie item is a non-standard inn item.
 * <p>
 * Each time this item ages:
 * <ul>
 *     <li> The quality increases by 1
 *     <li> The quality increases by an additional 1 if the sell by date has elapsed
 *     <li> The sell-in days decreases by 1
 * </ul>
 */
class AgedBrieItem implements InnItem {

    private static final String NAME = "Aged Brie";
    private static final int MAXIMUM_QUALITY = 50;

    private final Item item;
    private final ItemQualityModifier qualityModifier;
    private final ItemSellInModifier sellInModifier;

    AgedBrieItem(final Item item) {
        this.item = item;
        this.qualityModifier = new ItemQualityModifier(item, MAXIMUM_QUALITY);
        this.sellInModifier = new ItemSellInModifier(item);
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
        qualityModifier.increaseQuality(1);
        if (sellInModifier.hasSellByDateElapsed()) {
            qualityModifier.increaseQuality(1);
        }
        sellInModifier.decreaseSellIn(1);
    }
}
