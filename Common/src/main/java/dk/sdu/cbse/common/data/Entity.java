package dk.sdu.cbse.common.data;

import java.util.UUID;

public class Entity {
    private final String ID = UUID.randomUUID().toString();

    public String getID() {
        return ID;
    }
}
