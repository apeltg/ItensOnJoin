package com.github.ojvzinn.setitensonjoin.objectects

import com.github.ojvzinn.setitensonjoin.Main
import com.github.ojvzinn.setitensonjoin.utils.BukkitUtils
import com.github.ojvzinn.setitensonjoin.utils.StringUtils
import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.*

class Itens() {

    private var key: String? = null
    private var item: String? = null
    private var slot: Int? = null
    private var action: String? = null
    companion object {
        private var itens: List<Itens> = ArrayList()

        fun setupItens() {
            val CONFIG: FileConfiguration? = Main.getInstance()?.config
            for (key:String in CONFIG?.getConfigurationSection("itens")?.getKeys(false)!!) {
                val iten = Itens(
                    key,
                    CONFIG.getString("itens." + key + ".item"),
                    CONFIG.getInt("itens." + key + ".slot"),
                    CONFIG.getString("itens." + key + ".action")
                )
                itens = itens + iten
            }
        }

        fun setItens(player: Player) {
            player.inventory.clear()
            for (item: Itens in getItens()) {
                item.getSlot()?.let { player.inventory.setItem(item.getSlot()!!, BukkitUtils.deserializeItemStack(item.getItem()?.replace("{player}", player.name))) }
            }
        }

        fun getItens(): List<Itens> {
            return itens
        }

        fun setAction(player: Player, item: Itens) {
            val split: Array<String>? = item.getAction()?.split(" : ")?.toTypedArray()
            for (i in 0 until split!!.size) {
                val opt = split[i]
                if (opt.startsWith("tell>")) {
                    player.sendMessage(StringUtils.formatColors(opt.split(">")[1]).replace("{player}", player.name))
                } else if (opt.startsWith("command>")) {
                    player.performCommand(StringUtils.formatColors(opt.split(">")[1]).replace("{player}", player.name))
                } else if (opt.startsWith("console>")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), StringUtils.formatColors(opt.split(">")[1]).replace("{player}", player.name))
                }
            }
        }
    }

    constructor(key: String, item: String, slot: Int, action: String) : this() {
        this.key = key
        this.item = item
        this.slot = slot
        this.action = action
    }

    fun getKey(): String? {
        return this.key
    }

    fun getItem(): String? {
        return this.item
    }

    fun getSlot(): Int? {
        return this.slot
    }

    fun getAction(): String? {
        return this.action
    }
}