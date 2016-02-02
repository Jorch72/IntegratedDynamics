package org.cyclops.integrateddynamics.modcompat.waila;

import mcmultipart.multipart.IMultipartContainer;
import mcp.mobius.waila.api.IWailaRegistrar;
import org.cyclops.cyclopscore.helper.L10NHelpers;
import org.cyclops.integrateddynamics.Reference;
import org.cyclops.integrateddynamics.api.part.IPartContainerFacade;
import org.cyclops.integrateddynamics.tileentity.TileProxy;

/**
 * Waila support class.
 * @author rubensworks
 *
 */
public class Waila {
    
    /**
     * Waila callback.
     * @param registrar The Waila registrar.
     */
    public static void callbackRegister(IWailaRegistrar registrar){
        registrar.addConfig(Reference.MOD_NAME, getPartConfigId(), L10NHelpers.localize("gui." + Reference.MOD_ID + ".waila.partConfig"));
        registrar.addConfig(Reference.MOD_NAME, getProxyConfigId(), L10NHelpers.localize("gui." + Reference.MOD_ID + ".waila.proxyConfig"));
        registrar.registerBodyProvider(new PartDataProvider(), IPartContainerFacade.class);
        registrar.registerBodyProvider(new PartDataProvider(), IMultipartContainer.class);
        registrar.registerBodyProvider(new ProxyDataProvider(), TileProxy.class);
    }
    
    /**
     * Part config ID.
     * @return The config ID.
     */
    public static String getPartConfigId() {
        return Reference.MOD_ID + ".part";
    }

    /**
     * Proxy config ID.
     * @return The config ID.
     */
    public static String getProxyConfigId() {
        return Reference.MOD_ID + ".proxy";
    }
    
}
