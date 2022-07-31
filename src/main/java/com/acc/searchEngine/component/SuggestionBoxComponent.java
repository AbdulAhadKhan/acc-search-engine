package com.acc.searchEngine.component;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class SuggestionBoxComponent extends VerticalLayout {
    ListBox<String> suggestionList;
    Div container;

    private void configureStyling() {
        this.setWidth(60, Unit.EM);
        this.setHeight(20, Unit.EM);
        this.getStyle()
                .set("background", "#FCFDFF")
                .set("border-radius", "5px")
                .set("border", "1px #C2C2C2 solid");
        setAlignItems(Alignment.CENTER);
    }

    private void configureSuggestionList() {
        suggestionList = new ListBox<>();
        suggestionList.setWidth(18, Unit.EM);

        suggestionList.addValueChangeListener(event -> {
            if (event.getValue() == null)
                System.out.println(event.getValue());
        });
    }

    public void embedButtons(List<Button> suggestions) {
        container.removeAll();
        for (Button button : suggestions.stream().limit(5).toList())
            container.add(button);
        this.add(container);
    }

    public SuggestionBoxComponent() {
        configureSuggestionList();
        configureStyling();
        container = new Div();
    }
}
