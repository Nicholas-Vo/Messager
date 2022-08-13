package messager;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import messager.Chat;

public class Chat {
	public static String bold = ChatColor.BOLD + "";
	public static String gold = ChatColor.GOLD + "";
	public static String HR = ChatColor.STRIKETHROUGH + StringUtils.repeat(" ", 20);
	public static String HR2 = ChatColor.STRIKETHROUGH + StringUtils.repeat(" ", 6);
	public static String white = ChatColor.WHITE + "";
	public static String yellow = ChatColor.YELLOW + "";
	public static String gray = ChatColor.GRAY + "";
	public static String red = ChatColor.RED + "";
	public static String green = ChatColor.GREEN + "";
	public static String it = ChatColor.ITALIC + "";
	public static String blue = ChatColor.BLUE + "";
	public static String aqua = ChatColor.DARK_AQUA + "";
	public static String purple = ChatColor.LIGHT_PURPLE + "";
	public static String re = ChatColor.RESET + "";
	public static String strike = ChatColor.STRIKETHROUGH + "    ";
	public static String space = "            ";
	public static String space2 = "  ";
	public static String itgray = ChatColor.GRAY + "" + ChatColor.ITALIC + "";
	public static String a = ChatColor.RED + "Alert // " + ChatColor.RESET;
	public static String reset = ChatColor.RESET + "";
	public static String menuPrefix = gray + " " + HR2 + re + gold;
	public static String menuSuffix = gray + HR2;
	public static String bar = Chat.gray + Chat.HR + Chat.re + Chat.gold + Chat.bold;
}
