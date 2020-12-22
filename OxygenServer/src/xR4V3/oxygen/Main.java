package xR4V3.oxygen;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import xR4V3.oxygen.chat.GroupChat;
import xR4V3.oxygen.customnpc.NPCCommands;
import xR4V3.oxygen.customnpc.NPCEvents;
import xR4V3.oxygen.dailyrewards.DailyRewards;
import xR4V3.oxygen.friends.FriendsListener;
import xR4V3.oxygen.groups.GroupsListener;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/kup4y
 **/

public class Main extends JavaPlugin {


	public void onEnable() {
		this.saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new DailyRewards(), this);
		Bukkit.getPluginManager().registerEvents(new GroupsListener(), this);
		Bukkit.getPluginManager().registerEvents(new FriendsListener(), this);
		Bukkit.getPluginManager().registerEvents(new GroupChat(), this);
		Bukkit.getPluginManager().registerEvents(new NPCEvents(), this);
		this.getCommand("npc").setExecutor(new NPCCommands());

	}

	public static Main getInstance() {
		return (Main) Bukkit.getPluginManager().getPlugin("OxygenServer");
	}
}
