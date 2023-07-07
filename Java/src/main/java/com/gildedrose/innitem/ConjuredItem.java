package com.gildedrose.innitem;

import com.gildedrose.Item;

/**
 * The conjured item is a non-standard inn item.
 * <p>
 * Each time this item ages:
 * <ul>
 *     <li> The quality decreases by 2
 *     <li> The sell-in days decreases by 1
 * </ul>
 */
class ConjuredItem implements InnItem {

    static final String NAME_PREFIX = "Conjured";
    static final int MAXIMUM_QUALITY = 50;

    private final Item item;
    private final ItemQualityModifier qualityModifier;
    private final ItemSellInModifier sellInModifier;

    ConjuredItem(final Item item) {
        this.item = item;
        this.qualityModifier = new ItemQualityModifier(item, MAXIMUM_QUALITY);
        this.sellInModifier = new ItemSellInModifier(item);
    }

    static boolean canDecorate(final Item item) {
        return item.name.startsWith(NAME_PREFIX);
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
        qualityModifier.decreaseQuality(2);
        if (sellInModifier.hasSellByDateElapsed()) {
            qualityModifier.decreaseQuality(2);
        }
        sellInModifier.decreaseSellIn(1);
    }
}
