package com.willfp.ecopets.pets.entity

import com.willfp.eco.core.items.builder.SkullBuilder
import com.willfp.ecopets.pets.Pet
import org.bukkit.Location
import org.bukkit.entity.ArmorStand
import org.bukkit.inventory.ItemStack
import org.bukkit.Material

class SkullPetEntity(pet: Pet) : PetEntity(pet) {
    override fun spawn(location: Location): ArmorStand {
        val stand = emptyArmorStandAt(location, pet)

        val skull: ItemStack = SkullBuilder()
            .setSkullTexture(pet.entityTexture)
            .build()
            
        //use item pets
        val item = ItemStack(Material.PAPER);
        val itemData = item.itemMeta;
        itemData.setCustomModelData(pet.itemcmd);
        item.itemMeta = itemData;


        @Suppress("UNNECESSARY_SAFE_CALL") // Can be null.
        if (pet.entityTexture.isEmpty()) {
            stand.equipment?.helmet = item
        }else {
        stand.equipment?.helmet = skull
        }

        return stand
    }
}
