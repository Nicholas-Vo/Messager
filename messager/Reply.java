package messager;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reply extends Message implements CommandExecutor {
	public Logger console = Bukkit.getLogger();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = null;

		if (sender instanceof Player) {
			player = (Player) sender;
		}

		if (args.length == 0) {
			usage(sender);
			return true;
		}

		Player target = getTarget(player);

		if (target == null || !target.getPlayer().isOnline()) {
			fail(sender, "Cannot find target to reply to.");
			return true;
		}

		String message = getMessage(args);
		sendMessage(sender, target, message);
		logToConsole(sender, target, message);
		replyMap.put(target, (Player) sender);
		return false;
	}

	public String getMessage(String[] args) {
		String message = "";
		for (int i = 0; i < args.length; i++)
			message = message + args[i] + " ";
		return message;
	}

	public Player getTarget(Player player) {
		Player target = replyMap.get(player);
		Player target2 = map2.get(player);

		if (target != null)
			target = replyMap.get(player);
		else if (target2 != null)
			target = map2.get(player);
		return target;
	}

	public void sendMessage(CommandSender sender, Player target, String message) {
		sender.sendMessage(Chat.gold + "[To: " + target.getName() + "] " + Chat.gray + message);
		target.sendMessage(Chat.gold + "[From: " + sender.getName() + "] " + Chat.gray + message);
	}

	public void usage(CommandSender sender) {
		sender.sendMessage("Usage: /reply <message>");
	}
}
