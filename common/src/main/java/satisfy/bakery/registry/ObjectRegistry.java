package satisfy.bakery.registry;

import de.cristelknight.doapi.Util;
import de.cristelknight.doapi.common.block.ChairBlock;
import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import satisfy.bakery.Bakery;
import satisfy.bakery.block.*;
import satisfy.bakery.block.cakes.CakeBlock;
import satisfy.bakery.block.cakes.*;
import satisfy.bakery.block.crops.OatCropBlock;
import satisfy.bakery.block.crops.StrawberryCropBlock;
import satisfy.bakery.block.crops.WildBush;
import satisfy.bakery.item.*;
import satisfy.bakery.util.BakeryIdentifier;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Bakery.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Bakery.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> STRAWBERRY_TAIGA = registerWithoutItem("strawberry_taiga", () -> new WildBush(getBushSettings()));
    public static final RegistrySupplier<Block> STRAWBERRY_JUNGLE = registerWithoutItem("strawberry_jungle", () -> new WildBush(getBushSettings()));
    public static final RegistrySupplier<Block> STRAWBERRY_CROP = registerWithoutItem("strawberry_crop", () -> new StrawberryCropBlock(getBushSettings()));
    public static final RegistrySupplier<Item> STRAWBERRY_SEEDS = registerItem("strawberry_seeds", () -> new BlockItem(STRAWBERRY_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item> STRAWBERRY = registerItem("strawberry", () -> new TooltipItem(getSettings().food(Foods.BEETROOT)));
    public static final RegistrySupplier<Block> OAT_CROP = registerWithoutItem("oat_crop", () -> new OatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistrySupplier<Item> OAT_SEEDS = registerItem("oat_seeds", () -> new BlockItem(OAT_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item> OAT = registerItem("oat", () -> new TooltipItem(getSettings().food(Foods.BEETROOT)));
    public static final RegistrySupplier<Block> STRAWBERRY_CRATE = registerWithItem("strawberry_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> OAT_CRATE = registerWithItem("oat_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> OAT_BLOCK = registerWithItem("oat_block", () -> new HayBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).strength(2.0F, 3.0F).sound(SoundType.GRASS)));
    public static final RegistrySupplier<Block> OAT_STAIRS = registerWithItem("oat_stairs", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.GRASS)));
    public static final RegistrySupplier<Block> OAT_SLAB = registerWithItem("oat_slab", () -> new SlabBlock(getSlabSettings().sound(SoundType.GRASS)));
    public static final RegistrySupplier<Block> KITCHEN_SINK = registerWithItem("kitchen_sink", () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> BRICK_STOVE = registerWithItem("brick_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> BAKER_STATION = registerWithItem("baker_station", () -> new BakerStationBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> BRICK_COUNTER = registerWithItem("brick_counter", () -> new CounterBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> CABINET = registerWithItem("cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.BLOCK_CABINET_OPEN, SoundEventRegistry.BLOCK_CABINET_CLOSE));
    public static final RegistrySupplier<Block> DRAWER = registerWithItem("drawer", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.BLOCK_CABINET_OPEN, SoundEventRegistry.BLOCK_CABINET_CLOSE));
    public static final RegistrySupplier<Block> WALL_CABINET = registerWithItem("wall_cabinet", () -> new CabinetWallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.BLOCK_CABINET_OPEN, SoundEventRegistry.BLOCK_CABINET_CLOSE));
    public static final RegistrySupplier<Block> IRON_CHAIR = registerWithItem("iron_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2.0f, 3.0f).sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> IRON_TABLE = registerWithItem("iron_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<Block> STREET_SIGN = registerWithItem("street_sign", () -> new BoardBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), true));
    public static final RegistrySupplier<Block> CAKE_STAND = registerWithItem("cake_stand", () -> new CakeStandBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> BREADBOX = registerWithItem("breadbox", () -> new BreadBox(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> TRAY = registerWithItem("tray", () -> new TrayBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> BREAD_CRATE = registerWithItem("bread_crate", () -> new BreadCrateBox(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> CHOCOLATE_BOX = registerWithItem("chocolate_box", () -> new ChocolateBoxBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> ROLLING_PIN = registerItem("rolling_pin", () -> new SwordItem(Tiers.WOOD, 1, -2f, getSettings().rarity(Rarity.COMMON)));
    public static final RegistrySupplier<Item> BREAD_KNIFE = registerItem("bread_knife", () -> new SwordItem(Tiers.IRON, 1, -2f, getSettings().rarity(Rarity.COMMON)));
    public static final RegistrySupplier<Block> SMALL_COOKING_POT = registerWithItem("small_cooking_pot", () -> new CookingPotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistrySupplier<Block> JAR = registerWithItem("jar", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> STRAWBERRY_JAM = registerWithItem("strawberry_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> GLOWBERRY_JAM = registerWithItem("glowberry_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> SWEETBERRY_JAM = registerWithItem("sweetberry_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> CHOCOLATE_JAM = registerWithItem("chocolate_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> APPLE_JAM = registerWithItem("apple_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().sound(SoundType.GLASS).noOcclusion()));
    public static final RegistrySupplier<Item> YEAST = registerItem("yeast", () -> new IndulgentDelightItem(getSettings().food(Foods.ROTTEN_FLESH), 100));
    public static final RegistrySupplier<Item> DOUGH = registerItem("dough", () -> new IndulgentDelightItem(getSettings().food(Foods.ROTTEN_FLESH), 100));
    public static final RegistrySupplier<Item> SWEET_DOUGH = registerItem("sweet_dough", () -> new IndulgentDelightItem(getSettings().food(Foods.ROTTEN_FLESH), 100));
    public static final RegistrySupplier<Item> CROISSANT = registerItem("croissant", () -> new SweetsItem(getFoodItemSettings(5, 0.6f, EffectRegistry.STUFFED.get(), 60 * 15), 400));
    public static final RegistrySupplier<Block> CRUSTY_BREAD_BLOCK = registerWithoutItem("crusty_bread_block", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> CRUSTY_BREAD = registerItem("crusty_bread", () -> new FoodBlockItem(CRUSTY_BREAD_BLOCK.get(), getFoodItemSettings(5, 1.2f, EffectRegistry.STUFFED.get(), 4800)));
    public static final RegistrySupplier<Block> BREAD_BLOCK = registerWithoutItem("bread_block", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> BREAD = registerItem("bread", () -> new FoodBlockItem(BREAD_BLOCK.get(), getFoodItemSettings(5, 1.2f, EffectRegistry.STUFFED.get(), 4200)));
    public static final RegistrySupplier<Block> BAGUETTE_BLOCK = registerWithoutItem("baguette_block", () -> new StackableBunBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> BAGUETTE = registerItem("baguette", () -> new FoodBlockItem(BAGUETTE_BLOCK.get(), getFoodItemSettings(5, 1.2f, EffectRegistry.STUFFED.get(), 4200)));
    public static final RegistrySupplier<Block> TOAST_BLOCK = registerWithoutItem("toast_block", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> TOAST = registerItem("toast", () -> new FoodBlockItem(TOAST_BLOCK.get(), getFoodItemSettings(3, 0.8f, EffectRegistry.STUFFED.get(), 5400)));
    public static final RegistrySupplier<Block> BRAIDED_BREAD_BLOCK = registerWithoutItem("braided_bread_block", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> BRAIDED_BREAD = registerItem("braided_bread", () -> new FoodBlockItem(BRAIDED_BREAD_BLOCK.get(), getFoodItemSettings(5, 1.2f, EffectRegistry.STUFFED.get(), 4200)));
    public static final RegistrySupplier<Block> BUN_BLOCK = registerWithoutItem("bun_block", () -> new StackableBunBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> BUN = registerItem("bun", () -> new FoodBlockItem(BUN_BLOCK.get(), getFoodItemSettings(5, 1.2f, EffectRegistry.STUFFED.get(), 2800)));
    public static final RegistrySupplier<Item> VEGETABLE_SANDWICH = registerItem("vegetable_sandwich", () -> new SaturatedItem(getFoodItemSettings(3, 0.8f, EffectRegistry.STUFFED.get(), 4800)));
    public static final RegistrySupplier<Item> SANDWICH = registerItem("sandwich", () -> new SaturatedItem(getFoodItemSettings(6, 1.2f, EffectRegistry.STUFFED.get(), 6000)));
    public static final RegistrySupplier<Item> STRAWBERRY_CAKE_SLICE = registerItem("strawberry_cake_slice", () -> new SweetsItem(getSettings().food(Foods.COOKED_BEEF), 700));
    public static final RegistrySupplier<Item> SWEETBERRY_CAKE_SLICE = registerItem("sweetberry_cake_slice", () -> new SweetsItem(getSettings().food(Foods.COOKED_BEEF), 700));
    public static final RegistrySupplier<Item> CHOCOLATE_CAKE_SLICE = registerItem("chocolate_cake_slice", () -> new SweetsItem(getSettings().food(Foods.COOKED_BEEF), 700));
    public static final RegistrySupplier<Item> PUDDING_SLICE = registerItem("pudding_slice", () -> new SweetsItem(getSettings().food(Foods.COOKED_BEEF), 700));
    public static final RegistrySupplier<Item> BUNDT_CAKE_SLICE = registerItem("bundt_cake_slice", () -> new SweetlySatiatedItem(getFoodItemSettings(5, 1.4f, EffectRegistry.STUFFED.get(), 60 * 15), 800));
    public static final RegistrySupplier<Item> LINZER_TART_SLICE = registerItem("linzer_tart_slice", () -> new SweetlySatiatedItem(getFoodItemSettings(5, 1.4f, EffectRegistry.STUFFED.get(), 60 * 15), 800));
    public static final RegistrySupplier<Item> APPLE_PIE_SLICE = registerItem("apple_pie_slice", () -> new SweetlySatiatedItem(getFoodItemSettings(5, 1.4f, EffectRegistry.STUFFED.get(), 60 * 15), 800));
    public static final RegistrySupplier<Item> GLOWBERRY_PIE_SLICE = registerItem("glowberry_pie_slice", () -> new SweetlySatiatedItem(getFoodItemSettings(5, 1.4f, EffectRegistry.STUFFED.get(), 60 * 15), 800));
    public static final RegistrySupplier<Item> CHOCOLATE_TART_SLICE = registerItem("chocolate_tart_slice", () -> new SweetsItem(getSettings().food(Foods.COOKED_BEEF), 700));
    public static final RegistrySupplier<Block> STRAWBERRY_CAKE = registerWithItem("strawberry_cake", () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.STRAWBERRY_CAKE_SLICE));
    public static final RegistrySupplier<Block> SWEETBERRY_CAKE = registerWithItem("sweetberry_cake", () -> new CakeBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.SWEETBERRY_CAKE_SLICE));
    public static final RegistrySupplier<Block> CHOCOLATE_CAKE = registerWithItem("chocolate_cake", () -> new CakeBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.CHOCOLATE_CAKE_SLICE));
    public static final RegistrySupplier<Block> PUDDING = registerWithItem("pudding", () -> new PuddingBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.PUDDING_SLICE));
    public static final RegistrySupplier<Block> BUNDT_CAKE = registerWithItem("bundt_cake", () -> new BundtCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.BUNDT_CAKE_SLICE));
    public static final RegistrySupplier<Block> LINZER_TART = registerWithItem("linzer_tart", () -> new LinzerTartBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.LINZER_TART_SLICE));
    public static final RegistrySupplier<Block> APPLE_PIE = registerWithItem("apple_pie", () -> new ApplePieBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.APPLE_PIE_SLICE));
    public static final RegistrySupplier<Block> GLOWBERRY_TART = registerWithItem("glowberry_tart", () -> new GlowberryTartBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.GLOWBERRY_PIE_SLICE));
    public static final RegistrySupplier<Block> CHOCOLATE_TART = registerWithItem("chocolate_tart", () -> new ChocolateTart(BlockBehaviour.Properties.copy(Blocks.CAKE), CHOCOLATE_TART_SLICE));
    public static final RegistrySupplier<Item> STRAWBERRY_GLAZED_COOKIE = registerItem("strawberry_glazed_cookie", () -> new SweetsItem(getSettings().food(Foods.BREAD), 300));
    public static final RegistrySupplier<Item> SWEETBERRY_GLAZED_COOKIE = registerItem("sweetberry_glazed_cookie", () -> new SweetsItem(getSettings().food(Foods.BREAD), 300));
    public static final RegistrySupplier<Item> CHOCOLATE_GLAZED_COOKIE = registerItem("chocolate_glazed_cookie", () -> new SweetsItem(getSettings().food(Foods.BREAD), 300));
    public static final RegistrySupplier<Item> STRAWBERRY_CUPCAKE = registerItem("strawberry_cupcake", () -> new SweetsItem(getSettings().food(Foods.BREAD), 500));
    public static final RegistrySupplier<Item> SWEETBERRY_CUPCAKE = registerItem("sweetberry_cupcake", () -> new SweetsItem(getSettings().food(Foods.BREAD), 500));
    public static final RegistrySupplier<Item> APPLE_CUPCAKE = registerItem("apple_cupcake", () -> new SweetsItem(getSettings().food(Foods.BREAD), 500));
    public static final RegistrySupplier<Item> JAM_ROLL = registerItem("jam_roll", () -> new SweetlySatiatedItem(getFoodItemSettings(4, 0.7f, EffectRegistry.STUFFED.get(), 60 * 15), 800));
    public static final RegistrySupplier<Block> WAFFLE_BLOCK = registerWithoutItem("waffle_block", () -> new StackableBunBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> WAFFLE = registerItem("waffle", () -> new FoodBlockItem(WAFFLE_BLOCK.get(), getFoodItemSettings(5, 1.2f, EffectRegistry.STUFFED.get(), 800)));
    public static final RegistrySupplier<Item> CHOCOLATE_TRUFFLE = registerItem("chocolate_truffle", () -> new SweetsItem(getSettings().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).fast().build()), 200));
    public static final RegistrySupplier<Block> COBBLESTONE_STOVE = registerWithItem("cobblestone_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> SANDSTONE_STOVE = registerWithItem("sandstone_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> STONE_BRICKS_STOVE = registerWithItem("stone_bricks_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> DEEPSLATE_STOVE = registerWithItem("deepslate_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> GRANITE_STOVE = registerWithItem("granite_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> END_STOVE = registerWithItem("end_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> MUD_STOVE = registerWithItem("mud_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> QUARTZ_STOVE = registerWithItem("quartz_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Block> RED_NETHER_BRICKS_STOVE = registerWithItem("red_nether_bricks_stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistrySupplier<Item> BLANK_CAKE = registerItem("blank_cake", () -> new Item(getSettingsWithoutTab().food(Foods.ROTTEN_FLESH)));
    public static final RegistrySupplier<Item> WANDERING_BAKER_SPAWN_EGG = registerItem("wandering_baker_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.WANDERING_BAKER, -1, -1, getSettingsWithoutTab()));

    public static void init() {
        ITEMS.register();
        BLOCKS.register();
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    private static Item.Properties getSettingsWithoutTab(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(settings -> {
        });
    }

    private static Item.Properties getSettingsWithoutTab() {
        return getSettingsWithoutTab(settings -> {
        });
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return Util.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new BakeryIdentifier(name), block);
    }


    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return Util.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, new BakeryIdentifier(path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return Util.registerItem(ITEMS, ITEM_REGISTRAR, new BakeryIdentifier(path), itemSupplier);
    }

    private static BlockBehaviour.Properties getBushSettings() {
        return BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH);
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, MobEffect effect, int duration) {
        return getFoodItemSettings(nutrition, saturationMod, effect, duration, false, false);
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, MobEffect effect, int duration, boolean alwaysEat, boolean fast) {
        return getSettings().food(createFood(nutrition, saturationMod, effect, duration, alwaysEat, fast));
    }

    private static FoodProperties createFood(int nutrition, float saturationMod, MobEffect effect, int duration, boolean alwaysEat, boolean fast) {
        FoodProperties.Builder food = new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturationMod);
        if (alwaysEat) food.alwaysEat();
        if (fast) food.fast();
        if (effect != null) food.effect(new MobEffectInstance(effect, duration), 1.0f);
        return food.build();
    }

    private static BlockBehaviour.Properties getLogBlockSettings() {
        return BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties getSlabSettings() {
        return getLogBlockSettings().explosionResistance(3.0F);
    }
}

