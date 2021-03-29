package com.example.wbdvsp2103ymichaelserverjava.services;

import com.example.wbdvsp2103ymichaelserverjava.models.Widget;
import com.example.wbdvsp2103ymichaelserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
//    private List<Widget> widgets = new ArrayList<>();

    @Autowired
    WidgetRepository repository;


    // implement crud operations
    public Widget createWidget(String tid, Widget widget){
        widget.setTopicId(tid);
        return repository.save(widget);
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        return repository.findWidgetsForTopic(tid);
    }

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }

    public Widget findWidgetById(Integer wid) {
        return repository.findWidgetById(wid);
    }


    public Integer updateWidget(Integer wid, Widget widget) {
        Widget originalWidget = findWidgetById(wid);

        originalWidget.setText(widget.getText());
        originalWidget.setType(widget.getType());
        originalWidget.setSize(widget.getSize());
        originalWidget.setWidth(widget.getWidth());
        originalWidget.setHeight(widget.getHeight());
        originalWidget.setUrl(widget.getUrl());

        repository.save(originalWidget);
        return 1;
    }

    public Integer deleteWidget(Integer wid){
        repository.deleteById(wid);
        return 1;
    }

}
