package ru.dazzled.filer.model.impl;

import java.io.File;
import ru.dazzled.filer.model.FilerEntityType;

/**
 *
 * @author dmitriiz
 */
public class EbookEntity extends FileEntity {

    static enum EbookType {
        PDF
    }

    public EbookEntity(String mimeType, File file) {
        super(mimeType, FilerEntityType.EBOOK, file);
    }

}
