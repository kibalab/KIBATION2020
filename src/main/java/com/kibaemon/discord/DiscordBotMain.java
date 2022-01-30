package com.kibaemon.discord;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.*;

public class DiscordBotMain extends ListenerAdapter {

    public static void main(String[] args) throws Exception {
        new DiscordBotMain().start();
    }

    private void start() throws Exception {
        JDABuilder builder = new JDABuilder(AccountType.BOT);

        String token = "NjA2NDc1NzE4MzA1Nzc1NjM2.XULmjw.vYwYU3M816BsjuW-mXxXauGVVx4"; //"NjA2NDc1NzE4MzA1Nzc1NjM2.XULmjw.vYwYU3M816BsjuW-mXxXauGVVx4";
        builder.setToken(token);
        builder.setActivity(Activity.playing("<개발중> 구조조정"));
        builder.addEventListeners(this);
        builder.build();
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        String str = null;
        str = "\n" + event.getGuild().getName() + "[" + event.getGuild().getId() + "]" + " : ";
        for(TextChannel c : event.getGuild().getTextChannels()) {
            str += "\n   - " + c.getName() + "[" + c.getId() + "]" + " : " + c.canTalk(); // + " : {";
            /*for(Member m : c.getMembers()) {
                str += m.getNickname() + "(" + m.getUser().getName() + "#" + m.getUser().getId() + ")";
            }*/
            //str += "}\n";
        }
        System.out.println(str);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.print(event.getGuild().getName());
        new CommandManager().GenericMessageTerminal(event);
    }
}
