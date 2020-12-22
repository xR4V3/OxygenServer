package xR4V3.oxygen.friends;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import xR4V3.oxygen.Main;
import xR4V3.oxygen.Utils;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/kup4y
 **/

public class FriendsListener implements Listener {

	@EventHandler
	public void damageFriends(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			if (Main.getInstance().getConfig().getBoolean("Oxygen.Friends.disable-pvp-friends")) {
				Player damager = (Player) e.getDamager();
				Player entity = (Player) e.getEntity();
				if (Utils.getFriends(damager, entity) != null) {
					e.setCancelled(true);
				}
			}
		}
	}

}
