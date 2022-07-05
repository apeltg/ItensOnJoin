package com.github.ojvzinn.setitensonjoin.listeners.player

import com.github.ojvzinn.setitensonjoin.objectects.Itens
import com.github.ojvzinn.setitensonjoin.utils.BukkitUtils
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class PlayerInteractListeners: Listener {

    @EventHandler fun onInteract(event: PlayerInteractEvent) {
        val player:Player = event.player
        if (Itens.getItens().stream().anyMatch{item -> BukkitUtils.deserializeItemStack(item.getItem()).equals(event.item)}) {
         Itens.setAction(player, Itens.getItens().stream().filter{item -> BukkitUtils.deserializeItemStack(item.getItem()).equals(event.item)}.findFirst().get())
        }
    }
}