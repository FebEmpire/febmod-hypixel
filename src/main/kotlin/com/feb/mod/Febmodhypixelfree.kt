package com.feb.mod

import com.feb.mod.command.Commands
import com.feb.mod.features.features
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Febmodhypixelfree : ModInitializer {
    private val logger = LoggerFactory.getLogger("febmod-hypixel-free")

	override fun onInitialize() {

        Commands.registerAll()
        features.registerAll()

		logger.info("Hello Fabric world!")
	}
}