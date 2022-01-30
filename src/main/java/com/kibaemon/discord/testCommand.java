package com.kibaemon.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class testCommand {
    public testCommand(){

    }

    public void run(MessageReceivedEvent event){

        event.getChannel().sendMessage("Hello, World!").queue();
    }
}
