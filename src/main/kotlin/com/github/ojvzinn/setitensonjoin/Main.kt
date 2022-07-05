package com.github.ojvzinn.setitensonjoin

import com.github.ojvzinn.setitensonjoin.listeners.Listeners
import com.github.ojvzinn.setitensonjoin.objectects.Itens
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {

    companion object {
        private var instance: Main? = null

        fun getInstance(): Main? {
            return instance
        }
    }

    override fun onEnable() {
        super.onEnable()
        instance = this
        saveDefaultConfig()

        Listeners.setupListeners()
        Itens.setupItens()

        Bukkit.getConsoleSender().sendMessage("§a[SolarItensOnJoin] O plugin iniciou com sucesso!")
    }
    override fun onDisable() {
        super.onDisable()
        Bukkit.getConsoleSender().sendMessage("§c[SolarItensOnJoin] O plugin desligou com sucesso!")
    }
}