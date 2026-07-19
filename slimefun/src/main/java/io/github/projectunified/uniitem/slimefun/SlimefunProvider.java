package io.github.projectunified.uniitem.slimefun;

import io.github.projectunified.uniitem.api.Item;
import io.github.projectunified.uniitem.api.ItemKey;
import io.github.projectunified.uniitem.api.ItemProvider;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class SlimefunProvider implements ItemProvider {
    public static final String TYPE = "slimefun";
    public static final List<String> TYPES = Arrays.asList(
            TYPE,
            "sf"
    );

    public static boolean isAvailable() {
        if (Bukkit.getPluginManager().getPlugin("Slimefun") == null) return false;
        try {
            Class.forName("io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> availableTypes() {
        return TYPES;
    }

    @Override
    public @NotNull Item wrap(@NotNull ItemStack item) {
        return new SFItem(item);
    }

    @Override
    public @NotNull Item wrap(@NotNull ItemKey key) {
        return key.isType(TYPES) ? new SFItem(key.id()) : Item.INVALID;
    }
}
