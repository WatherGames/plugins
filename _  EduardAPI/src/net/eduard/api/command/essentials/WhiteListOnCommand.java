
package net.eduard.api.command.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.eduard.api.API;
import net.eduard.api.manager.CommandManager;

public class WhiteListOnCommand extends CommandManager {

	public String message = "�aVoce ativou a WhiteList";

	public WhiteListOnCommand() {
		super("on", "enable");

	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Bukkit.setWhitelist(true);
		API.chat(sender,message);
		return true;
	}

}
