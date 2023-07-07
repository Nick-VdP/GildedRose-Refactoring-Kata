package com.gildedrose;

import com.gildedrose.innitem.InnItem;
import com.gildedrose.innitem.InnItemFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {

    private final List<InnItem> innItems;

    public GildedRose(final Item[] items) {
        this.innItems = Arrays.stream(items)
            .map(InnItemFactory::fromItem)
            .collect(Collectors.toList());
    }

    public void updateQuality() {
        innItems.forEach(InnItem::age);
    }
}
