package com.feb.mod.command

import com.feb.mod.utils.ChatUtils

object HelpCommand {

    fun message () {

        ChatUtils.modMessage("FebMod commands:")
        ChatUtils.modMessage(".cobble")

    }

}