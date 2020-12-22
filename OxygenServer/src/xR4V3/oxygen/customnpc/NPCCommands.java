package xR4V3.oxygen.customnpc;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import xR4V3.oxygen.Main;
import xR4V3.oxygen.NpcData;
import xR4V3.oxygen.Utils;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/cr1p_walk
 **/

public class NPCCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("npc")) {
			if (args[0].equalsIgnoreCase("add")) {
				Entity ent = (Entity) s;
				NpcData npcData = new NpcData(getTargetEntity(ent).getUniqueId());
				npcData.createNpcDate(getTargetEntity(ent).getUniqueId());
				if (args[1].equalsIgnoreCase("money")) {
					String[] money = args[2].split("-");
					npcData.getNPCdata().set("Money.Range1", Integer.parseInt(money[0]));
					npcData.getNPCdata().set("Money.Range2", Integer.parseInt(money[1]));
					npcData.save();
					ent.sendMessage("Добавлено " + money[0] + money[1]);
				}
				if (args[1].equalsIgnoreCase("item")) {

				}
				if (args[1].equalsIgnoreCase("exp")) {
					String[] exp = args[2].split("-");
					npcData.getNPCdata().set("Exp.Range1", Integer.parseInt(exp[0]));
					npcData.getNPCdata().set("Exp.Range2", Integer.parseInt(exp[1]));
					npcData.save();
					ent.sendMessage("Добавлено");
				}
			}
		}

		return false;
	}

	public static Entity getTargetEntity(final Entity entity) {
		return getTarget(entity, entity.getWorld().getEntities());
	}

	public static <T extends Entity> T getTarget(final Entity entity, final Iterable<T> entities) {
		if (entity == null)
			return null;
		T target = null;
		final double threshold = 1;
		for (final T other : entities) {
			final Vector n = other.getLocation().toVector().subtract(entity.getLocation().toVector());
			if (entity.getLocation().getDirection().normalize().crossProduct(n).lengthSquared() < threshold
					&& n.normalize().dot(entity.getLocation().getDirection().normalize()) >= 0) {
				if (target == null || target.getLocation().distanceSquared(entity.getLocation()) > other.getLocation()
						.distanceSquared(entity.getLocation()))
					target = other;
			}
		}
		return target;
	}

}
