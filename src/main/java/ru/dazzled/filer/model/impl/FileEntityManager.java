package ru.dazzled.filer.model.impl;

import java.io.File;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import ru.dazzled.filer.EntityManager;
import ru.dazzled.filer.model.FilerEntity;
import ru.dazzled.filer.model.FilerEntityType;

/**
 *
 * @author dmitriiz
 */
public class FileEntityManager implements EntityManager {

    private Map<String, FilerEntity> entities;

    private Set<FilerEntity> scanFolder(File path) {
        Set<FilerEntity> result = new HashSet<>();
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                result.addAll(scanFolder(file));
            }
            else {
                final String name = file.getName();
                int n = name.lastIndexOf(".");
                if (n > 0) {
                    final String ext = name.substring(n + 1).toUpperCase();
                    switch (ext) {
                        case "PDF":
                            result.add(new PdfEntity(file));
                            break;
                        case "EPUB":
                            result.add(new EpubEntity(file));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return result;
    }

    public FileEntityManager(URI uri) {
        Set<FilerEntity> rawEntities = scanFolder(new File(uri));
        entities = new HashMap<>();
        for (FilerEntity entity : rawEntities) {
            entities.put(entity.getGuid(), entity);
        }
    }

    @Override
    public Collection<FilerEntity> getEntities(FilerEntityType type) {
        return entities.values();
    }

    @Override
    public FilerEntity getEntity(String guid) {
        return entities.get(guid);
    }
    
}
