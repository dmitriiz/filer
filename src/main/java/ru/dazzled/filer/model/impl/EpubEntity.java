package ru.dazzled.filer.model.impl;

import java.io.File;

/**
 *
 * @author dmitriiz
 */
public class EpubEntity extends EbookEntity {

    public EpubEntity(File file) {
        super("application/epub+zip", file);
    }
    
}
