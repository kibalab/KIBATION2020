package com.kibaemon.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandManager {

    public CommandManager() {
    }

    public void MessageCommandTerminal(MessageReceivedEvent event){
        String[] commeandPram = event.getMessage().getContentRaw().replace("?", "").split(" ");
        switch (commeandPram[0]) {
            case "test" :
                new testCommand().run(event);
                break;
            case "help" :
                new helpCommand().run(event);
                break;
            case "play" :
                new playCommand().run(event);
                break;
            case "pause" :
                new pauseCommand().run(event);
                break;
            case "leave" :
                new leaveCommand().run(event);
                break;
            case "volume" :
                new volumeCommand().run(event);
                break;
        }
    }

    public void GenericMessageTerminal(MessageReceivedEvent event){
        String message = event.getMessage().getContentRaw();
        if (new ResizeEmoji().findEmote(event)) {
            new ResizeEmoji().run(event);
            return;
        } else if (message.startsWith("?")) {
            MessageCommandTerminal(event);
            return;
        }
    }

}
