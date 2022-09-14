package net.bonn2.votechannel;

import net.bonn2.Bot;
import net.bonn2.modules.Module;
import net.bonn2.modules.settings.Settings;
import net.bonn2.modules.settings.types.Setting;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public class Main extends Module {
    public Main() {
        version = "1.0";
        name = "VoteChannel";
    }

    @Override
    public void registerLoggingChannels() {}

    @Override
    public void registerSettings() {
        Settings.register(this, "channels", Setting.Type.TEXT_CHANNEL_LIST, Setting.Type.TEXT_CHANNEL_LIST.unset,
                "The channels to add voting reactions to.");
    }

    @Override
    public void load() {
        Bot.jda.addEventListener(new Listener(this));
    }

    @Override
    public CommandData[] getCommands() {
        return new CommandData[0];
    }
}