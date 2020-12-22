package xR4V3.oxygen.groups;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;

import xR4V3.oxygen.Main;
import xR4V3.oxygen.Utils;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/cr1p_walk
 **/

public class GroupsListener implements Listener {

	@EventHandler
	public void damageGroupMembers(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			if (Main.getInstance().getConfig().getBoolean("Oxygen.Groups.disable-pvp-members")) {
				Player damager = (Player) e.getDamager();
				Player entity = (Player) e.getEntity();
				if (Utils.getPlayerGroup(damager) != null) {
					if (Utils.getGroupMembers(damager).contains(Utils.getPlayerUUID(entity))) {
						e.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void expGroup(PlayerExpChangeEvent e) {
		if (Main.getInstance().getConfig().getBoolean("Oxygen.Groups.exp.exp-per-members")) {
			int xp = e.getAmount();

			Player p = e.getPlayer();
			if (Utils.getPlayerGroup(p) != null) {
				for (UUID uuid : Utils.getGroupMembers(p)) {
					Bukkit.broadcastMessage("Кол-во игроков онлайн: " + Utils.getGroupSize(p));
					if (Bukkit.getPlayer(uuid) != null) {
						Utils.getPlayerbyUUID(uuid).giveExp(xp / Utils.getGroupSize(p));
					}
					Bukkit.broadcastMessage(xp + "/" + Utils.getGroupSize(p) + "=" + (xp / Utils.getGroupSize(p)));
					e.setAmount(0);
				}
			}
		}
	}

}
