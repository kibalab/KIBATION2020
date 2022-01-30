package com.kibaemon.discord;

import com.kibaemon.discord.audiocore.*;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

public class playCommand {
    private VoiceChannel Vch = null;
    private PlayerManager manager;


    public playCommand() {
        this.manager = PlayerManager.getInstance();
    }

    public void run(MessageReceivedEvent event) {
        String[] arg = event.getMessage().getContentRaw().split(" ");

        AudioManager audiomng = event.getGuild().getAudioManager();
        checkVoiceChennal(event, audiomng);

        manager.loadAndPlay(event, arg[1]);
        manager.getGuildMusicManager(event.getGuild()).player.setVolume(15);
    }

    public void checkVoiceChennal(MessageReceivedEvent event, AudioManager audiomng) {
        Vch = event.getMember().getVoiceState().getChannel();
        if (!audiomng.isConnected()) {
            audiomng.openAudioConnection(Vch);
        }
    }
}
