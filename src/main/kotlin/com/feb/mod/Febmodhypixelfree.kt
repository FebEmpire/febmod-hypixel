package com.feb.mod

import com.feb.mod.command.Commands
import com.feb.mod.command.DotCommands
import com.feb.mod.features.Features
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Febmodhypixelfree : ModInitializer {
    private val logger = LoggerFactory.getLogger("febmod-hypixel-free")

    override fun onInitialize() {
        Commands.registerAll()
        DotCommands.initialize()
        Features.registerAll()

        logger.info("FebMod initalized")
    }
}