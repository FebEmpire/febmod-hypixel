package com.feb.mod.command

import com.feb.mod.features.AntiCobbleBreaker
import com.feb.mod.command.HelpCommand
import com.feb.mod.ui.FebModGui
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents

object DotCommands {
    fun initialize() {
        ClientSendMessageEvents.ALLOW_CHAT.register { message ->
            if (message.startsWith(".")) {
                handle(message)
                return@register false
            }
            true
        }
    }

    private fun handle(message: String) {
        val args = message.substring(1).split(" ")
        when (args[0].lowercase()) {
            "cobble" -> AntiCobbleBreaker.toggle()
            "help" -> HelpCommand.message()
            "f", "feb", "febmod" -> {
                val mc = net.minecraft.client.Minecraft.getInstance()
                mc.execute { mc.setScreen(FebModGui()) }
            }
        }
    }
}