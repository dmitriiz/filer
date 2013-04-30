package ru.dazzled.filer.model.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
import ru.dazzled.filer.model.FilerEntity;
import ru.dazzled.filer.model.FilerEntityType;

/**
 *
 * @author dmitriiz
 */
public class FileEntity implements FilerEntity {

    private final String guid;
    private final String mimeType;
    private final FilerEntityType entityType;
    private final File file;
    private final Map<String, Object> properties;
    private byte[] content;

    FileEntity(final String mimeType, final FilerEntityType entityType, final File file) {
        this.guid = UUID.randomUUID().toString();
        this.entityType = entityType;
        this.mimeType = mimeType;
        this.file = file;
        this.properties = new HashMap<>();
        this.content = null;
    }

    protected File getFile() {
        return file;
    }

    protected void setProperty(String name, Object data) {
        properties.put(name, data);
    }

    @Override
    public String getGuid() {
        return guid;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public FilerEntityType getEntityType() {
        return entityType;
    }

    @Override
    public Object getProperty(String name) {
        return properties.get(name);
    }

    @Override
    public String getName() {
        return file.getName();
    }


    @Override
    public byte[] getContent() {
        if (content == null) {
            try {
                InputStream in = new FileInputStream(file);
                content = IOUtils.toByteArray(in);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return content;
    }
    
}
