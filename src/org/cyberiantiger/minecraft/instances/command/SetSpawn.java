/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cyberiantiger.minecraft.instances.command;

import java.util.Collections;
import java.util.List;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberiantiger.minecraft.instances.Instances;

/**
 *
 * @author antony
 */
public class SetSpawn extends AbstractCommand {

    
    public SetSpawn() {
        super(SenderType.PLAYER);
    }
    
    @Override
    public List<String> execute(Instances instances, CommandSender sender, String[] args) {
        if (args.length != 0) {
            return null;
        }
        Player player = (Player) sender;
        World world = player.getWorld();
        if (instances.isInstance(world)) {
            return Collections.singletonList("Cannot set the spawn world to an instance.");
        }
        instances.setSpawn(world);
        return Collections.singletonList("Spawn set to " + player.getWorld().getName() + '.');
    }
}
