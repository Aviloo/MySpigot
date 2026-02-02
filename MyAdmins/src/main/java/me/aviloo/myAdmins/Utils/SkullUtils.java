package me.aviloo.myAdmins.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

public class SkullUtils {


    private static final Gson GSON = new Gson();

    public static ItemStack skull = new ItemStack(Material.PLAYER_HEAD);

    public static ItemStack getSkullByBase64EncodedTextureUrl(@NotNull final String base64Url) {
        final ItemStack head = skull.clone();
        if (base64Url.isEmpty()) {
            return head;
        }

        final SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        if (headMeta == null) {
            return head;
        }

        if (VersionHelper.HAS_PLAYER_PROFILES) {
            final PlayerProfile profile = getPlayerProfile(base64Url);
            headMeta.setOwnerProfile(profile);
            head.setItemMeta(headMeta);
            return head;
        }

        final GameProfile profile = getGameProfile(base64Url);
        final Field profileField;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (final NoSuchFieldException | IllegalArgumentException | IllegalAccessException exception) {
            Bukkit.getConsoleSender().sendMessage("Failed to get head item from base64 texture url");
            exception.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    @NotNull
    private static GameProfile getGameProfile(@NotNull final String base64Url) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", base64Url));
        return profile;
    }

    /**
     * Create a player profile object
     * Player profile was introduced in 1.18.1+
     * @param base64Url the base64 encoded texture URL to use
     * @return player profile
     */
    @NotNull
    private static PlayerProfile getPlayerProfile(@NotNull final String base64Url) {
        final PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());

        final String decodedBase64 = decodeSkinUrl(base64Url);
        if (decodedBase64 == null) {
            return profile;
        }

        final PlayerTextures textures = profile.getTextures();

        try {
            textures.setSkin(new URL(decodedBase64));
        } catch (final MalformedURLException exception) {
            Bukkit.getConsoleSender().sendMessage("Something went horribly wrong trying to create basehead URL");
            exception.printStackTrace();
        }

        profile.setTextures(textures);
        return profile;
    }

    @Nullable
    private static String decodeSkinUrl(@NotNull final String base64Texture) {
        final String decoded = new String(Base64.getDecoder().decode(base64Texture));
        final JsonObject object = GSON.fromJson(decoded, JsonObject.class);

        final JsonElement textures = object.get("textures");

        if (textures == null) {
            return null;
        }

        final JsonElement skin = textures.getAsJsonObject().get("SKIN");

        if (skin == null) {
            return null;
        }

        final JsonElement url = skin.getAsJsonObject().get("url");
        return url == null ? null : url.getAsString();
    }
}
