/*
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/5/20 22:44
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mbx.plugin.hexo.handler;

import cn.sixlab.mbx.core.common.base.BaseHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index/hexo")
public class IndexHexoHandler extends BaseHandler {
    @RequestMapping(value = {"", "/"})
    public String index(ModelMap modelMap) {
        String uri = "/auth/article/list/10";
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            return "redirect:"+uri;
        }
        
        modelMap.put("sub", "hexo");
        modelMap.put("url", uri);
        return "login";
    }
}
