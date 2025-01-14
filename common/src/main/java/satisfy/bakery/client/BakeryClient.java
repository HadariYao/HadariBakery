package satisfy.bakery.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import satisfy.bakery.client.gui.BakerStationGui;
import satisfy.bakery.client.gui.CookingPotGui;
import satisfy.bakery.client.gui.StoveGui;
import satisfy.bakery.client.model.WanderingBakerModel;
import satisfy.bakery.client.render.entity.WanderingBakerRenderer;
import satisfy.bakery.registry.EntityRegistry;
import satisfy.bakery.registry.ScreenHandlerTypeRegistry;

import static satisfy.bakery.registry.ObjectRegistry.*;

@Environment(EnvType.CLIENT)
public class BakeryClient {

    public static void initClient() {
        RenderTypeRegistry.register(RenderType.cutout(),
                CAKE_STAND.get(), IRON_TABLE.get(), IRON_CHAIR.get(), JAR.get(), SWEETBERRY_JAM.get(), CHOCOLATE_JAM.get(),
                STRAWBERRY_JAM.get(), GLOWBERRY_JAM.get(), APPLE_JAM.get(), OAT_CROP.get(), STRAWBERRY_CROP.get(), STRAWBERRY_JUNGLE.get(),
                STRAWBERRY_TAIGA.get()
        );

        ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> BiomeColors.getAverageGrassColor(world, pos), STRAWBERRY_TAIGA);


        ClientStorageTypes.init();
        RenderTypeRegistry.register(RenderType.translucent(), TRAY.get());
        RenderTypeRegistry.register(RenderType.translucent(), CAKE_STAND.get());

        MenuRegistry.registerScreenFactory(ScreenHandlerTypeRegistry.STOVE_SCREEN_HANDLER.get(), StoveGui::new);
        MenuRegistry.registerScreenFactory(ScreenHandlerTypeRegistry.COOKING_POT_SCREEN_HANDLER.get(), CookingPotGui::new);
        MenuRegistry.registerScreenFactory(ScreenHandlerTypeRegistry.BAKER_STATION_SCREEN_HANDLER.get(), BakerStationGui::new);

    }


    public static void preInitClient() {
        registerEntityRenderers();
        registerEntityModelLayer();

    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(EntityRegistry.WANDERING_BAKER, WanderingBakerRenderer::new);
    }

    public static void registerEntityModelLayer() {
        EntityModelLayerRegistry.register(WanderingBakerModel.LAYER_LOCATION, WanderingBakerModel::getTexturedModelData);

    }
}
