package com.github.ojvzinn.setitensonjoin.listeners

import com.github.ojvzinn.setitensonjoin.Main
import com.github.ojvzinn.setitensonjoin.listeners.player.PlayerInteractListeners
import com.github.ojvzinn.setitensonjoin.listeners.player.PlayerJoinListeners
import org.bukkit.Bukkit
class Listeners {

    companion object {
        fun setupListeners() {
            try {
                Bukkit.getPluginManager().registerEvents(PlayerJoinListeners(), Main.getInstance())
                Bukkit.getPluginManager().registerEvents(PlayerInteractListeners(), Main.getInstance())
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }
}