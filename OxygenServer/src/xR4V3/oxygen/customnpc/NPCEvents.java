package xR4V3.oxygen.customnpc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import xR4V3.oxygen.NpcData;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/cr1p_walk
 **/

public class NPCEvents implements Listener {

	@EventHandler
	public void npcDeath(EntityDamageByEntityEvent e) {
		LivingEntity li = (LivingEntity) e.getEntity();
		if((li.getHealth()  - e.getDamage()) <= 0) {
			Player killer = (Player) e.getDamager();
			World w = e.getEntity().getWorld();
			Location l = e.getEntity().getLocation();
			NpcData npcData = new NpcData(e.getEntity().getUniqueId());
			killer.sendMessage(npcData.getExp() + " : " + npcData.getMoney());
			
			((ExperienceOrb) w.spawn(l, ExperienceOrb.class)).setExperience(npcData.getExp());
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
					"wallet give " + killer.getName() + " " + npcData.getMoney());
		}
	}

}
