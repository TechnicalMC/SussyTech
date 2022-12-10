package sussytech.lib.material;

import sussytech.api.Constants;
import sussytech.api.material.property.type.MaterialItemType;

@SuppressWarnings("unused")
public final class ItemTypes {

    private ItemTypes() {/**/}

    public static final MaterialItemType INGOT = new ItemTypeImpl("ingot", Constants.M);
    public static final MaterialItemType CHUNK = new ItemTypeImpl("chunk", Constants.M / 4);
    public static final MaterialItemType NUGGET = new ItemTypeImpl("nugget", Constants.M / 9);
    public static final MaterialItemType DUST = new ItemTypeImpl("dust", Constants.M);
    public static final MaterialItemType PLATE = new ItemTypeImpl("plate", Constants.M);
    public static final MaterialItemType DOUBLE_PLATE = new ItemTypeImpl("double_plate", Constants.M * 2);
    public static final MaterialItemType TRIPLE_PLATE = new ItemTypeImpl("triple_plate", Constants.M * 3);
    public static final MaterialItemType QUADRUPLE_PLATE = new ItemTypeImpl("quadruple_plate", Constants.M * 4);
    public static final MaterialItemType QUINTUPLE_PLATE = new ItemTypeImpl("quintuple_plate", Constants.M * 5);
    public static final MaterialItemType DENSE_PLATE = new ItemTypeImpl("dense_plate", Constants.M * 9);
    public static final MaterialItemType CURVED_PLATE = new ItemTypeImpl("curved_plate", Constants.M);
    public static final MaterialItemType FOIL = new ItemTypeImpl("foil", Constants.M / 4);
    public static final MaterialItemType ROD = new ItemTypeImpl("rod", Constants.M / 2);
    public static final MaterialItemType LONG_ROD = new ItemTypeImpl("long_rod", Constants.M);
    public static final MaterialItemType BOLT = new ItemTypeImpl("bolt", Constants.M / 8);
    public static final MaterialItemType NAIL = new ItemTypeImpl("nail", Constants.M / 8);
    public static final MaterialItemType SCREW = new ItemTypeImpl("screw", Constants.M / 9);
    public static final MaterialItemType SMALL_SPRING = new ItemTypeImpl("small_spring", Constants.M / 2);
    public static final MaterialItemType SPRING = new ItemTypeImpl("spring", Constants.M);
    public static final MaterialItemType RING = new ItemTypeImpl("ring", Constants.M / 4);
    public static final MaterialItemType ROTOR = new ItemTypeImpl("rotor", Constants.M * 4 + Constants.M / 4);
    public static final MaterialItemType SMALL_GEAR = new ItemTypeImpl("small_gear", Constants.M);
    public static final MaterialItemType GEAR = new ItemTypeImpl("gear", Constants.M * 4);
    public static final MaterialItemType FINE_WIRE = new ItemTypeImpl("fine_wire", Constants.M / 8);
    public static final MaterialItemType ROUND = new ItemTypeImpl("round", Constants.M / 9);
    public static final MaterialItemType GEM = new ItemTypeImpl("gem", Constants.M);
    public static final MaterialItemType BOULE = new ItemTypeImpl("boule", Constants.M * 4);
    public static final MaterialItemType LENS = new ItemTypeImpl("lens", Constants.M * 3 / 4);

    public static final MaterialItemType BLOCK_ITEM = new ItemTypeImpl("block", Constants.M * 9, false);
    public static final MaterialItemType FRAME_ITEM = new ItemTypeImpl("frame", Constants.M * 2);
}
