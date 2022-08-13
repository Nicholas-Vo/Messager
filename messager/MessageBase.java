package messager;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 
public class MessageBase extends JavaPlugin implements Listener {
	Logger myPluginLogger = Bukkit.getLogger();

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		this.myPluginLogger.info("Enabling Java Messager...");
		this.getCommand("msg").setExecutor(new Message());
		this.getCommand("reply").setExecutor(new Reply());
	}

	public void onDisable() {
		this.myPluginLogger.info("PrivateMessage disabled.");
	}
}
