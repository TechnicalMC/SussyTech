package sussytech.lib.material;

import sussytech.api.material.property.type.MaterialBlockType;

public final class BlockTypes {

    private BlockTypes() {/**/}

    public static final MaterialBlockType BLOCK = new BlockTypeImpl("block", ItemTypes.BLOCK_ITEM);
    public static final MaterialBlockType FRAME = new BlockTypeImpl("frame", ItemTypes.FRAME_ITEM);
}
