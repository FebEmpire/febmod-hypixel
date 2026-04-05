package com.feb.mod.features

import com.mojang.brigadier.CommandDispatcher
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.fabricmc.fabric.api.event.player.AttackBlockCallback
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.InteractionResult
import com.feb.mod.utils.ChatUtils

object AntiCobbleBreaker {
    private var enabled = false
    val client = Minecraft.getInstance()

    fun initialize() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            registerCommand(dispatcher)
        }

        AttackBlockCallback.EVENT.register { player, world, hand, pos, direction ->
            if (enabled) {
                val blockState = world.getBlockState(pos)
                if (blockState.block == Blocks.COBBLESTONE) {
                    return@register InteractionResult.FAIL
                }
            }
            InteractionResult.PASS
        }
    }

    private fun registerCommand(dispatcher: CommandDispatcher<FabricClientCommandSource>) {
        dispatcher.register(
            ClientCommandManager.literal("cobble")
                .executes {
                    enabled = !enabled
                    val status = if (enabled) "enabled" else "disabled"
                    ChatUtils.modMessage("Anti cobble breaker $status")
                    1
                }
        )
    }
}