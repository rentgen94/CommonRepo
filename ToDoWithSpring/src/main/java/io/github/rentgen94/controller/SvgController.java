package io.github.rentgen94.controller;

import io.github.rentgen94.model.SvgFragment;
import io.github.rentgen94.model.User;
import io.github.rentgen94.user.ActiveUserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class SvgController {

    @Autowired
    private ActiveUserStore activeUserStore;

    @RequestMapping("/svg")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            System.out.println("Non authorized");
            model.addAttribute("webSocketUrl", "This is default websocket: localhost:7777");
        } else {
            String webSocketUrl = activeUserStore.findUserByEmail(principal.getName()).getWebSocketUrl();
            if (webSocketUrl != null) {
                model.addAttribute("webSocketUrl", webSocketUrl);
            }
        }
        StringBuffer attr1 = new StringBuffer();
        StringBuffer attr2 = new StringBuffer();
        appendAttr(attr1, "x", "0");
        appendAttr(attr1, "y", "0");
        appendAttr(attr1, "width", "200");
        appendAttr(attr1, "height", "200");
        appendAttr(attr2, "x", "200");
        appendAttr(attr2, "y", "200");
        appendAttr(attr2, "width", "100");
        appendAttr(attr2, "height", "100");

        ArrayList<SvgFragment> fragments = new ArrayList<>();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("parentClass", "hmi.pump");
        arguments.put("attr", attr1.toString());
        SvgFragment fragment = new SvgFragment("svgTemplates/svgText", "svgText", arguments);
        fragments.add(fragment);

        arguments = new HashMap<>();
        arguments.put("attr", attr2.toString());
        fragment = new SvgFragment("svgTemplates/svgText", "svgText", arguments);
        fragments.add(fragment);

        model.addAttribute("fragments", fragments);
        return "svgView";
    }

    private static void appendAttr(StringBuffer buffer, String attr, String value) {
        buffer.append(attr);
        buffer.append("=${'");
        buffer.append(value.replaceAll("\"", "''"));
        buffer.append("'}, ");
    }
}
