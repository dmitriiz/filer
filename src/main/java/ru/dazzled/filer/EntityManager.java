package ru.dazzled.filer;

import java.util.Collection;
import ru.dazzled.filer.model.FilerEntity;
import ru.dazzled.filer.model.FilerEntityType;

/**
 *
 * @author dmitriiz
 */
public interface EntityManager {

    Collection<FilerEntity> getEntities(final FilerEntityType type);
    FilerEntity getEntity(final String guid);

}
