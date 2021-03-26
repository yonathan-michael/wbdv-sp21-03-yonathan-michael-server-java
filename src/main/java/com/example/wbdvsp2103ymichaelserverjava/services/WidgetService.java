package com.example.wbdvsp2103ymichaelserverjava.services;

import com.example.wbdvsp2103ymichaelserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<>();


    // implement crud operations
    public Widget createWidget(String tid, Widget widget){
        Long id = (new Date()).getTime();
        widget.setId(id);
        widget.setTopicId(tid);
        widgets.add(widget);
        return widget;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> ws = new ArrayList<>();
        for(Widget w: widgets) {
                if (w.getTopicId().equals(tid)) {
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
            String s = String.valueOf(w.getId());
            if(s.equals(wid)) {
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
            String s = String.valueOf(w.getId());
            if(s.equals(wid)) {
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
