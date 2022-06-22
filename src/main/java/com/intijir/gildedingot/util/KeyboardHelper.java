package com.intijir.gildedingot.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper {

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingShift(){
        return InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingCtrl(){
        return InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_CONTROL);
    }
}
