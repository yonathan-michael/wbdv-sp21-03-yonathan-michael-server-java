package com.example.wbdvsp2103ymichaelserverjava.services;

import com.example.wbdvsp2103ymichaelserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();
//    {
//        Widget w1 = new Widget();
//        Widget w2 = new Widget();
//        w1.setId(1);
//        w2.setId(2);
//        w1.setType("HEADING");
//        w2.setType("PARAGRAPH");
//        widgets.add(w1);
//        widgets.add(w2);
//    }

    // implement crud operations
    public Widget createWidget(String tid, Widget widget){
        Long id = (new Date()).getTime();
        widget.setId(id);
        widget.setTopicId(tid);
        widgets.add(widget);
        return widget;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(tid)) {
                ws.add(w);
            }
        }
        return ws;
    }

    public List<Widget> findWidgets() {
        return widgets;
    }

    public Integer updateWidget(String wid, Widget widget) {
        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(wid)) {
                widgets.set(i, widget);
                return 1;
            }
        }
        return -1;
    }

    public Integer deleteWidget(String wid){
        int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(wid)) {
                index = i;
            }
        }
        if(index >= 0) {
            widgets.remove(index);
            return 1;
        }
        return -1;
    }

}
