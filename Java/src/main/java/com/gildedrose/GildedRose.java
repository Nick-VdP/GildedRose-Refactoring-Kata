package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // Decrease item quality by 1
            // If item is not 'Aged Brie' or 'Backstage passes to a TAFKAL80ETC concert' or 'Sulfuras, Hand of Ragnaros'
            // And item has quality higher than 0
            if (!items[i].name.equals("Aged Brie") &&
                !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                // Increase item quality by 1
                // If item is 'Aged Brie' or 'Backstage passes to a TAFKAL80ETC concert'
                // And item has quality lower than 50
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    // Increase item quality by 1
                    // If item is 'Backstage passes to a TAFKAL80ETC concert'
                    // And item has sellIn lower than 11
                    // And item has quality lower than 50
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        // Increase item quality by 1
                        // If item is 'Backstage passes to a TAFKAL80ETC concert'
                        // And item has sellIn lower than 6
                        // And item has quality lower than 50
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // Decrease item sellIn by 1
            // If item is not 'Sulfuras, Hand of Ragnaros'
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                // Decrease item quality by 1
                                // If item is not 'Aged Brie' or 'Backstage passes to a TAFKAL80ETC concert' or 'Sulfuras, Hand of Ragnaros'
                                // And item has sellIn lower than 0
                                // And item has quality higher than 0
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        // Set item quality to 0
                        // If item is 'Backstage passes to a TAFKAL80ETC concert'
                        // And item has sellIn lower than 0
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    // Increase item quality by 1
                    // If item is 'Aged Brie'
                    // And item has sellIn lower than 0
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
