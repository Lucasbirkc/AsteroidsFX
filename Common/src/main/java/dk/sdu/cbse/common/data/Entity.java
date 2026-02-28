package dk.sdu.cbse.common.data;

import dk.sdu.cbse.common.parts.IEntityPart;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Entity {
    private final String id;
    private final Map<Class<? extends IEntityPart>, IEntityPart> parts;

    public Entity() {
        this.id = UUID.randomUUID().toString();
        this.parts = new ConcurrentHashMap<>();
    }

    public String getID() {
        return id;
    }

    public void addPart(IEntityPart part) {
        this.parts.put(part.getClass(), part);
    }

    public void removePart(IEntityPart part) {
        this.parts.remove(part.getClass());
    }

    public IEntityPart getParts() {
        return this.parts.values();
    }
}
