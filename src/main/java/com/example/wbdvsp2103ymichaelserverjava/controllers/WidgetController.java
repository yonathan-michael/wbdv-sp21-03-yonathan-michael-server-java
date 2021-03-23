package com.example.wbdvsp2103ymichaelserverjava.controllers;

import com.example.wbdvsp2103ymichaelserverjava.models.Widget;
import com.example.wbdvsp2103ymichaelserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// make data available to the rest of the world
@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidgetForTopic(@PathVariable("tid") String tid,
                                       @RequestBody Widget widget) {
        return service.createWidget(tid, widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid) {
        return service.findWidgetsForTopic(tid);
    }

    @GetMapping("/api/all/widgets")
    public List<Widget> findWidgets() {
        return service.findWidgets();
    }

    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(@PathVariable("wid") String wid,
                                @RequestBody Widget widget) {
        return service.updateWidget(wid, widget );
    }

    @DeleteMapping("/api/widgets/{wid}")
    public Integer deleteWidget(@PathVariable("wid") String wid) {
        return service.deleteWidget(wid);
    }
}
