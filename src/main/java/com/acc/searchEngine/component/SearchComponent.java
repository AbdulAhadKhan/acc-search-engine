package com.acc.searchEngine.component;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class SearchComponent extends HorizontalLayout {
    public TextField searchBar;
    public Button searchButton;

    private void configureSearchBar() {
        searchBar = new TextField();
        searchBar.setPlaceholder("Search");
        searchBar.setWidth(50, Unit.EM);
        searchBar.setPrefixComponent(VaadinIcon.SEARCH.create());
    }

    private void configureSearchButton() {
        searchButton = new Button();
        searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        searchButton.setText("Search");
    }

    public SearchComponent() {
        configureSearchBar();
        configureSearchButton();

        add(searchBar, searchButton);
    }
}
