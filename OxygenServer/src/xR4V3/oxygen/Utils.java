package xR4V3.oxygen;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import austeretony.oxygen_core.server.api.OxygenHelperServer;
import austeretony.oxygen_dailyrewards.server.DailyRewardsManagerServer;
import austeretony.oxygen_friendslist.common.ListEntry;
import austeretony.oxygen_friendslist.server.FriendsListManagerServer;
import austeretony.oxygen_groups.common.Group;
import austeretony.oxygen_groups.server.GroupsManagerServer;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/kup4y
 **/

public class Utils {

	public static UUID getPlayerUUID(Player p) {
		return OxygenHelperServer.getPlayerUUID(p.getName());
	}
	
	public static Player getPlayerbyUUID(UUID uuid) {
		return Bukkit.getPlayer(uuid);
	}
	
	public static Group getPlayerGroup(Player p) {
		return GroupsManagerServer.instance().getGroupsDataContainer().getGroup(getPlayerUUID(p));
	}
	
	public static Set<UUID> getGroupMembers(Player p) {
		return GroupsManagerServer.instance().getGroupsDataContainer().getGroup(getPlayerUUID(p)).getMembers();
	}
	
	public static boolean isRewardAvailable(Player p) {
		return DailyRewardsManagerServer.instance().getPlayerDataContainer().getPlayerData(getPlayerUUID(p)).isRewardAvailable(getPlayerUUID(p));
	}
	
	public static ListEntry getFriends(Player p,Player target) {
		return FriendsListManagerServer.instance().getPlayerDataContainer().getPlayerData(getPlayerUUID(p)).getListEntryByUUID(getPlayerUUID(target));
	}
	
	public static int getGroupSize(Player p) {
		int size = 0;
		for (UUID uuid : Utils.getGroupMembers(p)) {
			if (Bukkit.getPlayer(uuid) != null) {
				size++;
			}
		}
		return size;
	}
	
}
