/*
 * Magma Server
 * Copyright (C) 2019-2020.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.magmafoundation.magma;

import net.minecraftforge.server.permission.PermissionAPI;
import org.magmafoundation.magma.commands.permission.BukkitPermissionsHandler;
import org.magmafoundation.magma.configuration.MagmaConfig;
import org.magmafoundation.magma.modPatcher.ModPatcherManager;
import org.magmafoundation.magma.patcher.PatcherManager;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 19/08/2019 - 05:01 am
 */
public class Magma {

    private static final String NAME = "Magma";
    private static final String VERSION = (Magma.class.getPackage().getImplementationVersion() != null) ? Magma.class.getPackage().getImplementationVersion() : "dev-env";
    private static final String BUKKIT_VERSION = "v1_12_R1";
    private static final String NMS_PREFIX = "net/minecraft/server/";
    private static final String LIBRARY_VERSION = "4";
    private static Magma INSTANCE = new Magma();
    private PatcherManager patcherManager;
    private ModPatcherManager modPatcherManager;

    public Magma() {
        INSTANCE = this;

        if (System.getProperty("log4j.configurationFile") == null) {
            System.setProperty("log4j.configurationFile", "log4j2_magma.xml");
        }

    }

    public static Magma getInstance() {
        return INSTANCE;
    }

    public static String getName() {
        if(MagmaConfig.instance.overrideServerBrand.getValues()) return MagmaConfig.instance.serverBrand.getValues();
        return NAME;
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getBukkitVersion() {
        return BUKKIT_VERSION;
    }

    public static String getNmsPrefix() {
        return NMS_PREFIX;
    }

    public static String getLibraryVersion() {
        return LIBRARY_VERSION;
    }

    public PatcherManager getPatcherManager() {
        return patcherManager;
    }

    public void setPatcherManager(PatcherManager patcherManager) {
        this.patcherManager = patcherManager;
    }

    public ModPatcherManager getModPatcherManager() {
        return modPatcherManager;
    }

    public void setModPatcherManager(ModPatcherManager modPatcherManager) {
        this.modPatcherManager = modPatcherManager;
    }
}
