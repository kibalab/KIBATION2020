package com.kibaemon.discord;

import com.kibaemon.discord.audiocore.GuildMusicManager;
import com.kibaemon.discord.audiocore.PlayerManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class pauseCommand {
    private PlayerManager manager;

    public pauseCommand(){
        this.manager = PlayerManager.getInstance();
    }

    public void run(MessageReceivedEvent event) {
        AudioPlayer player = manager.getGuildMusicManager(event.getGuild()).player;

        if (!player.isPaused()) {
            player.setPaused(true);
        } else {
            player.setPaused(false);
        }
    }
}
