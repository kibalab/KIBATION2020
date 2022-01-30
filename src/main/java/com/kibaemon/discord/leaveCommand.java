package com.kibaemon.discord;

import com.kibaemon.discord.audiocore.PlayerManager;
import com.kibaemon.discord.audiocore.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class leaveCommand {
    private VoiceChannel Vch = null;
    private PlayerManager manager;


    public leaveCommand() {
        this.manager = PlayerManager.getInstance();
    }

    public void run(MessageReceivedEvent event) {
        AudioPlayer player = manager.getGuildMusicManager(event.getGuild()).player;
        TrackScheduler scheduler = manager.getGuildMusicManager(event.getGuild()).scheduler;

        event.getGuild().getAudioManager().closeAudioConnection();

        scheduler.getQueue().clear();
        player.stopTrack();
        player.setPaused(false);
    }
}
