package net.bonn2.votechannel;

import net.bonn2.modules.settings.Settings;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Listener extends ListenerAdapter {

    final Main module;

    public Listener(Main module) {
        this.module = module;
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (Settings.get(module, event.getGuild().getId(), "channels").getAsMessageChannelList(event.getGuild()).contains(event.getChannel())) {
            event.getMessage().addReaction(Emoji.fromUnicode("\uD83D\uDC4D")).queue();
            event.getMessage().addReaction(Emoji.fromUnicode("\uD83D\uDC4E")).queue();
        }
    }
}

