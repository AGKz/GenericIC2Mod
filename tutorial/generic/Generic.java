package tutorial.generic;

import ic2.api.item.Items;
import ic2.api.recipe.Recipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=Generic.modid, name="Generic", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Generic {

        // The instance of your mod that Forge uses.
        @Instance("Generic")
        public static Generic instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="tutorial.generic.client.ClientProxy", serverSide="tutorial.generic.CommonProxy")
        public static CommonProxy proxy;

		public final static String modid = "generic";
        
        public final static Item electricFood = new ElectricFood(5000);
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	LanguageRegistry.addName(electricFood, "Electric Food");
        	
        	
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
        	
        	Recipes.extractor.addRecipe(new ItemStack(Item.pocketSundial), Items.getItem("electronicCircuit"));
        	
            proxy.registerRenderers();
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
