package com.gildedrose.innitem;

import com.gildedrose.Item;

/**
 * The backstage passes item is a non-standard inn item.
 * <p>
 * Each time this item ages:
 * <ul>
 *     <li> The quality increases by 1
 *     <li> The quality increases by an additional 1 if the sell by date approaches and is at most 10 days away
 *     <li> The quality increases by an additional 1 if the sell by date approaches and is at most 5 days away
 *     <li> The sell-in days decreases by 1
 * </ul>
 * <p>
 * When the sell by date has elapsed the quality is 0.
 */
class BackstagePassesItem implements InnItem {

    private static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final int MAXIMUM_QUALITY = 50;

    private final Item item;
    private final ItemQualityModifier qualityModifier;
    private final ItemSellInModifier sellInModifier;

    BackstagePassesItem(final Item item) {
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
        if (sellInModifier.hasSellByDateElapsed()) {
            qualityModifier.setQuality(0);
        } else {
            if (sellInModifier.isSellByDateApproaching(10)) {
                qualityModifier.increaseQuality(1);
            }
            if (sellInModifier.isSellByDateApproaching(5)) {
                qualityModifier.increaseQuality(1);
            }
            qualityModifier.increaseQuality(1);
        }
        sellInModifier.decreaseSellIn(1);
    }
}
