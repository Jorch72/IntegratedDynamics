package org.cyclops.integrateddynamics.core.evaluate.variable;

import org.cyclops.cyclopscore.helper.MinecraftHelpers;
import org.cyclops.integrateddynamics.IntegratedDynamics;

/**
 * Collection of variable types.
 * @author rubensworks
 */
public class ValueTypes {

    public static final IValueTypeRegistry REGISTRY = constructRegistry();

    public static ValueTypeAny     ANY     = REGISTRY.register(new ValueTypeAny());
    public static ValueTypeBoolean BOOLEAN = REGISTRY.register(new ValueTypeBoolean());
    public static ValueTypeInteger INTEGER = REGISTRY.register(new ValueTypeInteger());
    public static ValueTypeString  STRING  = REGISTRY.register(new ValueTypeString());

    private static IValueTypeRegistry constructRegistry() {
        // This also allows this registry to be used outside of a minecraft environment.
        if(MinecraftHelpers.isModdedEnvironment()) {
            return IntegratedDynamics._instance.getRegistryManager().getRegistry(IValueTypeRegistry.class);
        } else {
            return ValueTypeRegistry.getInstance();
        }
    }

    public static void load() {}

}
