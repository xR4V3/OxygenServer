package xR4V3.oxygen;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author xR4V3
 *
 * @vk https://vk.com/kup4y
 **/

public class NpcData {

	UUID uuid;
	File npcData;
	FileConfiguration npcDataConfig;

	public NpcData(UUID uuid) {
		this.uuid = uuid;
		npcData = new File(Main.getInstance().getDataFolder() + File.separator + "data" + File.separator + uuid + ".yml");
		npcDataConfig = YamlConfiguration.loadConfiguration(npcData);
	}

	public void createNpcDate(UUID uuid) {
		try {
			if (!npcData.exists()) {
				npcData.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileConfiguration getNPCdata() {
		return npcDataConfig;
	}

	public void save() {
		try {
			getNPCdata().save(npcData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getMoney() {
		int r1 = npcDataConfig.getInt("Money.Range1");
		int r2 = npcDataConfig.getInt("Money.Range2");

		return getRandomNumber(r1, r2);
	}

	public int getExp() {
		int r1 = npcDataConfig.getInt("Exp.Range1");
		int r2 = npcDataConfig.getInt("Exp.Range2");

		return getRandomNumber(r1, r2);
	}

	private static int getRandomNumber(int a, int b) {
		if (b < a)
			return getRandomNumber(b, a);
		return a + (int) ((1 + b - a) * Math.random());
	}

}
