package com.gildedrose.innitem;

import com.gildedrose.Item;

/**
 * The standard inn item.
 * <p>
 * Each time this item ages:
 * <ul>
 *     <li> The quality decreases by 1
 *     <li> The sell-in days decreases by 1
 * </ul>
 */
class StandardInnItem implements InnItem {

    private static final int MAXIMUM_QUALITY = 50;

    private final Item item;
    private final ItemQualityModifier qualityModifier;
    private final ItemSellInModifier sellInModifier;

    StandardInnItem(final Item item) {
        this.item = item;
        this.qualityModifier = new ItemQualityModifier(item, MAXIMUM_QUALITY);
        this.sellInModifier = new ItemSellInModifier(item);
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
        qualityModifier.decreaseQuality(1);
        if (sellInModifier.hasSellByDateElapsed()) {
            qualityModifier.decreaseQuality(1);
        }
        sellInModifier.decreaseSellIn(1);
    }
}
