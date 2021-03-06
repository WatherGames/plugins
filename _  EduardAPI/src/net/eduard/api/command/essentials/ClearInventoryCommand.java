
package net.eduard.api.command.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.CommandManager;
import net.eduard.api.setup.Mine;

public class ClearInventoryCommand extends CommandManager {
	public String message = "�6Seu inventario foi limpo!";
	public String messageTarget = "�6Voce limpou o inventario do �e$player";
	public ClearInventoryCommand() {
		super("clearinventory");
		
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				Mine.clearInventory(p);
				API.chat(p,message);
			}else 
			return false;
		} else {
			String name = args[0];
			if (API.existsPlayer(sender, name)) {
				Player target = Mine.getPlayer(name);
				API.chat(sender, messageTarget.replace("$player",
						target.getDisplayName()));
				API.chat(target,message);
				Mine.clearInventory(target);
			}
		}

		return true;
	}
}
