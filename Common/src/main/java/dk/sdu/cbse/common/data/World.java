package dk.sdu.cbse.common.data;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class World {

    private final Map<UUID, Entity> entityMap = new ConcurrentHashMap<>();

    public void addEntity(Entity entity) {
        entityMap.put(entity.getId(), entity);
    }

    public void removeEntity(UUID entityId) {
        entityMap.remove(entityId);
    }

    public void removeEntity(Entity entity) {
        entityMap.remove(entity.getId());
    }

    public Entity getEntity(UUID entityId) {
        return entityMap.get(entityId);
    }

    public Collection<Entity> getEntities() {
        return entityMap.values();
    }

    public <E extends Entity> List<Entity> getEntities(Class<E>... entityTypes) {
        List<Entity> result = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes) {
                if (entityType.equals(e.getClass())) {
                    result.add(e);
                }
            }
        }
        return result;
    }
}
