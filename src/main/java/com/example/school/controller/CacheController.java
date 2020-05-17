package com.example.school.controller;

import com.example.school.cache.CacheLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janak on 16-05-2020.
 */

@RestController
public class CacheController {
    @Autowired
    private CacheLogger cacheLogger;
    @RequestMapping(path = "/ClearCache", method = RequestMethod.GET )
    public void evictCache(){
        cacheLogger.evictCache();
    }
}
