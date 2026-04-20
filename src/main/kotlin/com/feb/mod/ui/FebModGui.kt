package com.feb.mod.ui

import net.minecraft.client.gui.components.Button
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import com.feb.mod.features.AntiCobbleBreaker

class FebModGui : Screen(Component.literal("FebMod")) {

    override fun init() {
        val button = Button.builder(Component.literal("AntiCobbleBreaker")) {
            AntiCobbleBreaker.toggle()
        }
            .bounds(width / 2 - 50, height / 2 - 10, 100, 20)
            .build()

        addRenderableWidget(button)
    }

    override fun render(
        guiGraphics: net.minecraft.client.gui.GuiGraphics,
        mouseX: Int,
        mouseY: Int,
        partialTick: Float
    ) {
        super.render(guiGraphics, mouseX, mouseY, partialTick)
    }

    override fun isPauseScreen() = false

}