package com.github.ojvzinn.setitensonjoin.listeners.player

import com.github.ojvzinn.setitensonjoin.objectects.Itens
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListeners: Listener {

    @EventHandler fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage = null
        val player:Player = event.player

        Itens.setItens(player)
    }
}