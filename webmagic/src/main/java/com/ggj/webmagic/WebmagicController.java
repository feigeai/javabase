package com.ggj.webmagic;

import com.ggj.webmagic.autoconfiguration.TieBaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:gaoguangjin
 * @date 2016/8/19 10:58
 */
@Controller
public class WebmagicController {
    @Autowired
    private WebmagicService webmagicService;
    @Autowired
    private TieBaConfiguration tieBaConfiguration;

    @RequestMapping("/tiebatop/{tieBaName}/{size}")
    public String tieBaTop(@PathVariable("tieBaName") String tieBaName, @PathVariable("size") Integer size, Model model) throws  Exception{
       webmagicService.getTieBaTop(tieBaName,size,model);
        model.addAttribute("name",tieBaName);
        return "tiebatop";
    }
    @RequestMapping("/tiebatop/level/{tieBaName}/")
    public String tieBaTop(@PathVariable("tieBaName") String tieBaName, Model model) throws  Exception{
       webmagicService.getLevelCount(tieBaName,model);
        model.addAttribute("name",tieBaName);
        return "tiebatoplevel";
    }
    @RequestMapping("/tieba/img/{tieBaName}")
    public String tieBaTop( Model model,@PathVariable("tieBaName") String tieBaName) throws  Exception{
        model.addAttribute("pageUrlPrefix",tieBaConfiguration.getTiebaContentPageUrl());
       webmagicService.getTieBaImage(model,tieBaName);
        return "tiebaimage";
    }

}