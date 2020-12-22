package xR4V3.oxygen.dailyrewards;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import xR4V3.oxygen.Utils;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/kup4y
 **/

public class DailyRewards implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (Utils.isRewardAvailable(e.getPlayer())) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
					"oxygenop dailyrewards -open-menu " + e.getPlayer().getName());
		}
	}
}
