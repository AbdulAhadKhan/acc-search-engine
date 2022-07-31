package com.acc.searchEngine;

import autocomplete.AutoComplete;
import com.acc.searchEngine.component.SearchComponent;
import com.acc.searchEngine.component.SuggestionBoxComponent;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Route("")
public class HomeView extends VerticalLayout {
    AutoComplete autoComplete;
    SearchComponent searchComponent;
    SuggestionBoxComponent suggestionBox;

    private Button buildButton(String label) {
        Button button = new Button(label);
        button.setWidth(58, Unit.EM);
        button.getStyle()
                .set("text-align", "left")
                .set("background", "none");

        button.addClickListener(event -> {
            searchComponent.searchBar.setValue(label);
        });

        return button;
    }

    public List<Button> createSelectableSuggestions(List<String> suggestions) {
        List<Button> buttonList = new ArrayList<>();
        for (String suggestion : suggestions.stream().limit(5).toList())
            buttonList.add(buildButton(suggestion));
        return buttonList;
    }

    public HomeView() throws IOException {
        getStyle().set("background", "#EDEEF2");
        autoComplete = new AutoComplete("src/main/resources/engmix.txt");

        searchComponent = new SearchComponent();
        searchComponent.searchBar.setValueChangeMode(ValueChangeMode.EAGER);
        add(searchComponent);

        suggestionBox = new SuggestionBoxComponent();
        add(suggestionBox);

        searchComponent.searchBar.addValueChangeListener(event -> {
            List<String> suggestions = autoComplete.suggest(event.getValue());
            List<Button> buttonList = createSelectableSuggestions(suggestions);
            suggestionBox.embedButtons(buttonList);
        });

        searchComponent.searchButton.addClickListener(event -> {
            String query = searchComponent.searchBar.getValue().replace("", "+");
            getUI().get().getPage().setLocation("http://localhost:8010/search?searchKey=" + query);
        });

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }
}
