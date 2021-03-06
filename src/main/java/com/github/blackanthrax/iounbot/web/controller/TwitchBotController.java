package com.github.blackanthrax.iounbot.web.controller;

import static com.github.blackanthrax.iounbot.irc.util.IrcUtils.nameToChannel;

import org.pircbotx.PircBotX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.blackanthrax.iounbot.web.dto.ChannelDto;

@RestController
@RequestMapping("/api")
public class TwitchBotController {

    @Autowired
    private PircBotX bot;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public void join(@RequestBody ChannelDto channel) {
        bot.send().joinChannel(nameToChannel(channel.getName()));
    }

    @RequestMapping(value = "/leave", method = RequestMethod.POST)
    public void leave(@RequestBody ChannelDto channel) {
        bot.sendRaw().rawLine("PART " + channel.getName());
    }
}
