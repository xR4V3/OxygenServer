package xR4V3.oxygen.chat;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import xR4V3.oxygen.Utils;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/kup4y
 **/

public class GroupChat implements Listener {

	public void chat(Player p, String msg) {
		if (Utils.getPlayerGroup(p) != null) {
			for (UUID uuid : Utils.getGroupMembers(p)) {
				if (Bukkit.getPlayer(uuid) != null) {
					Bukkit.getPlayer(uuid).sendMessage(msg);
				}
			}
		}
	}

	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent e) {
		if (e.getMessage().startsWith("#")) {
			if (Utils.getPlayerGroup(e.getPlayer()) != null) {
				this.chat(e.getPlayer(),
						e.getPlayer().getDisplayName() + ChatColor.GREEN + ": " + e.getMessage().replace("#", ""));
			}else {
				e.getPlayer().sendMessage(ChatColor.RED + "Вы не состоите в группе.");
			}
			e.setCancelled(true);
		}
	}

}
