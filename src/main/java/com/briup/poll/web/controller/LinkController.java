package com.briup.poll.web.controller;

import com.briup.poll.bean.Link;
import com.briup.poll.exception.CustomerException;
import com.briup.poll.service.ILinkService;
import com.briup.poll.util.Message;
import com.briup.poll.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
@Api(description = "这是链接管理")
public class LinkController {
        @Autowired
        private ILinkService service;

        @GetMapping("/addOrUpdateLink")
        @ApiOperation("添加或修改链接")
        public Message<String> addOrUpdateLink(Link link){
            try {
                service.addOrUpdateLink(link);
            }catch (CustomerException e){
                return MessageUtil.error(500,e.getMessage());
            }
            return MessageUtil.success("success");
        }

        @GetMapping("/deleteLink")
        @ApiOperation("删除链接")
        public  Message<String> deleteLink(Integer id){
            try {
                service.deleteLink(id);
            }catch (CustomerException e){
                return MessageUtil.error(500,e.getMessage());
            }
            return MessageUtil.success("success");
        }

        /*@GetMapping("/updateById")
        @ApiOperation("修改内容")
        public Message<String> updateById(Link link){
            try{
                service.updateById(link);
            }catch (CustomerException e){
                return MessageUtil.error(500,e.getMessage());
            }
            return MessageUtil.success("success");
        }*/
        @GetMapping("/selectById")
        @ApiOperation("查询")
        public Message<Link> selectById(Integer id){
            Link link = new Link();
            try{
                 link = service.selectById(id);

            }catch (CustomerException e){
                return MessageUtil.error(500,e.getMessage());
            }
            return MessageUtil.success(link);
        }

}
