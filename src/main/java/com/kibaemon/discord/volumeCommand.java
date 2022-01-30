package com.kibaemon.discord;

import com.kibaemon.discord.audiocore.PlayerManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class volumeCommand {
    private PlayerManager manager;

    public volumeCommand() {
        this.manager = PlayerManager.getInstance();
    }

    public void run(MessageReceivedEvent event) {
        String[] arg = event.getMessage().getContentRaw().split(" ");

        AudioPlayer player = manager.getGuildMusicManager(event.getGuild()).player;

        player.setVolume(Integer.parseInt(arg[1]));
    }
}
