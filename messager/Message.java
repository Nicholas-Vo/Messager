package messager;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message implements CommandExecutor {
	public Map<Player, Player> replyMap = new HashMap<Player, Player>();
	public Map<Player, Player> map2 = new HashMap<Player, Player>();
	public Logger console = Bukkit.getLogger();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = null;

		if (sender instanceof Player) {
			player = (Player) sender;
		}
		
		if (args.length == 0) {
			usage(sender);
			return false;
		}

		Player target = Bukkit.getPlayer(args[0]);

		if (target == sender) {
			fail(sender, "You cannot message yourself.");
			return false;
		}

		if (args.length == 1) {
			fail(sender, "You must enter a message.");
			return false;
		}

		if (target == null) {
			fail(sender, "That player isn't online.");
			return false;
		} else if (target != null) {
			String message = getMessage(args);
			sendMessage(sender, target, message);
			logToConsole(sender, target, message);
			replyMap.put(target, (Player) sender);
			map2.put((Player) sender, target);
		}
		return false;
	}

	public void sendMessage(CommandSender sender, Player target, String message) {
		sender.sendMessage(Chat.gold + "[To: " + target.getName() + "] " + Chat.gray + message);
		target.sendMessage(Chat.gold + "[From: " + sender.getName() + "] " + Chat.gray + message);
	}

	public void logToConsole(CommandSender sender, Player target, String message) {
		console.info(sender.getName() + " --> " + target.getName() + " " + message);
	}

	public String getMessage(String[] args) {
		String message = "";
		for (int i = 1; i < args.length; i++)
			message = message + args[i] + " ";
		return message;
	}

	public void usage(CommandSender s) {
		String usage = "Usage: /msg <player> <message>";
		s.sendMessage(usage);
	}

	public void fail(CommandSender sender, String why) {
		sender.sendMessage(why);
	}
}
