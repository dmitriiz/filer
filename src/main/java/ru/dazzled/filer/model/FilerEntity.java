package ru.dazzled.filer.model;

/**
 *
 * @author dmitriiz
 */
public interface FilerEntity {
    String getGuid();
    String getMimeType();
    FilerEntityType getEntityType();
    Object getProperty(final String name);
    String getName();
    byte[] getContent();
}
