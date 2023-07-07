package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void standardItem_sellByNotElapsed_degradeQuality() {
        final Item[] items = new Item[]{new Item("+5 Dexterity Vest", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("+5 Dexterity Vest", items[0].name);
            assertEquals(9, items[0].quality);
        });
    }

    @Test
    void standardItem_sellByNotElapsed_degradeQualityToZero() {
        final Item[] items = new Item[]{new Item("+5 Dexterity Vest", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("+5 Dexterity Vest", items[0].name);
            assertEquals(0, items[0].quality);
        });
    }

    @Test
    void standardItem_sellByElapsed_degradeQuality() {
        final Item[] items = new Item[]{new Item("+5 Dexterity Vest", 0, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("+5 Dexterity Vest", items[0].name);
            assertEquals(8, items[0].quality);
        });
    }

    @Test
    void standardItem_sellByElapsed_degradeQualityToZero() {
        final Item[] items = new Item[]{new Item("+5 Dexterity Vest", 0, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("+5 Dexterity Vest", items[0].name);
            assertEquals(0, items[0].quality);
        });
    }

    @Test
    void standardItem_decreaseSellIn_oneDay() {
        final Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("+5 Dexterity Vest", items[0].name);
            assertEquals(9, items[0].sellIn);
        });
    }

    @Test
    void standardItem_decreaseSellIn_multipleDays() {
        final Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("+5 Dexterity Vest", items[0].name);
            assertEquals(-10, items[0].sellIn);
        });
    }

    @Test
    void agedBrie_sellByNotElapsed_enhanceQuality() {
        final Item[] items = new Item[]{new Item("Aged Brie", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Aged Brie", items[0].name);
            assertEquals(11, items[0].quality);
        });
    }

    @Test
    void agedBrie_sellByNotElapsed_enhanceQualityTo50() {
        final Item[] items = new Item[]{new Item("Aged Brie", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 41 days
        IntStream.range(0, 41).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Aged Brie", items[0].name);
            assertEquals(50, items[0].quality);
        });
    }

    @Test
    void agedBrie_sellByElapsed_enhanceQuality() {
        final Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Aged Brie", items[0].name);
            assertEquals(12, items[0].quality);
        });
    }

    @Test
    void agedBrie_sellByElapsed_enhanceQualityTo50() {
        final Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Aged Brie", items[0].name);
            assertEquals(50, items[0].quality);
        });
    }

    @Test
    void agedBrie_decreaseSellIn_oneDay() {
        final Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Aged Brie", items[0].name);
            assertEquals(9, items[0].sellIn);
        });
    }

    @Test
    void agedBrie_decreaseSellIn_multipleDays() {
        final Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Aged Brie", items[0].name);
            assertEquals(-10, items[0].sellIn);
        });
    }

    @Test
    void sulfuras_sellByNotElapsed_fixedQuality() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 99, 80)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
            assertEquals(80, items[0].quality);
        });
    }

    @Test
    void sulfuras_sellByElapsed_fixedQuality() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
            assertEquals(80, items[0].quality);
        });
    }

    @Test
    void sulfuras_fixedSellIn() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
            assertEquals(10, items[0].sellIn);
        });
    }

    @Test
    void backstagePasses_sellByNotElapsed_enhanceQuality() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
            assertEquals(11, items[0].quality);
        });
    }

    @Test
    void backstagePasses_sellByApproaching10_enhanceQuality() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
            assertEquals(12, items[0].quality);
        });
    }

    @Test
    void backstagePasses_sellByApproaching5_enhanceQuality() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
            assertEquals(13, items[0].quality);
        });
    }

    @Test
    void backstagePasses_sellByNotElapsed_enhanceQualityTo50() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 41 days
        IntStream.range(0, 41).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
            assertEquals(50, items[0].quality);
        });
    }

    @Test
    void backstagePasses_sellByElapsed_qualityIsZero() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
            assertEquals(0, items[0].quality);
        });
    }

    @Test
    void backstagePasses_decreaseSellIn_oneDay() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
            assertEquals(9, items[0].sellIn);
        });
    }

    @Test
    void backstagePasses_decreaseSellIn_multipleDays() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
            assertEquals(-10, items[0].sellIn);
        });
    }

    @Test
    void conjuredItem_sellByNotElapsed_degradeQuality() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Conjured Mana Cake", items[0].name);
            assertEquals(8, items[0].quality);
        });
    }

    @Test
    void conjuredItem_sellByNotElapsed_degradeQualityToZero() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 99, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Conjured Mana Cake", items[0].name);
            assertEquals(0, items[0].quality);
        });
    }

    @Test
    void conjuredItem_sellByElapsed_degradeQuality() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Conjured Mana Cake", items[0].name);
            assertEquals(6, items[0].quality);
        });
    }

    @Test
    void conjuredItem_sellByElapsed_degradeQualityToZero() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Conjured Mana Cake", items[0].name);
            assertEquals(0, items[0].quality);
        });
    }

    @Test
    void conjuredItem_decreaseSellIn_oneDay() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 1 day
        gildedRose.updateQuality();

        assertAll(() -> {
            assertEquals("Conjured Mana Cake", items[0].name);
            assertEquals(9, items[0].sellIn);
        });
    }

    @Test
    void conjuredItem_decreaseSellIn_multipleDays() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 10, 10)};
        final GildedRose gildedRose = new GildedRose(items);

        // Simulate 20 days
        IntStream.range(0, 20).forEach(days -> gildedRose.updateQuality());

        assertAll(() -> {
            assertEquals("Conjured Mana Cake", items[0].name);
            assertEquals(-10, items[0].sellIn);
        });
    }
}
